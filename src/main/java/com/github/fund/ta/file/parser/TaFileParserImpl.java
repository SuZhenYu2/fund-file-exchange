package com.github.fund.ta.file.parser;

import cn.org.atool.fluent.mybatis.metadata.SetterMeta;
import cn.org.atool.fluent.mybatis.utility.MybatisUtil;
import cn.org.atool.fluent.mybatis.utility.ObjectArray;
import com.github.fund.ta.file.domain.Field;
import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.confirm.TaContextInfo;
import com.github.fund.ta.file.domain.confirm.TaEntity;
import com.github.fund.ta.file.helper.TaEntityClassHelper;
import com.github.fund.ta.file.helper.TaUrlPathHelper;
import com.github.fund.ta.file.io.ReadRequest;
import com.github.fund.ta.file.io.ReadResponse;
import com.github.fund.ta.file.io.TaFileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

/**
 * ta file parser impl
 *
 * @author suzhenyu
 * @since 2021/3/17 5:46 下午
 */
@Slf4j
public class TaFileParserImpl<T extends TaEntity> implements TaFileParser<T> {


  private final FileTypeEnum fileType;

  private final TaFileReader ofdReader = new TaFileReader();

  public TaFileParserImpl(FileTypeEnum fileType) {
    this.fileType = fileType;
  }

  @Override
  public FileTypeEnum getFileType() {
    return fileType;
  }

  @Override
  public TaFileParseResponse<?> parse(TaFileParseRequest request) {
    //获取具体的文件路径
    String fileUri = TaUrlPathHelper.getFileUri(request.getPath(),
        request.getTaCode(),
        request.getDistributeCode(),
        request.getDate(), getFileType(),
        request.getNumber());

    File file = new File(fileUri);
    if (!file.exists()) {
      log.info("File not exist, uri={}", file.getAbsolutePath());
      return TaFileParseResponse.builder()
          .success(false).taFileHeader(null)
          .errorDetail("文件不存在")
          .lastModifyTime(null)
          .build();
    }
    long lastModified = file.lastModified();
    try  {
      FileInputStream fileInputStream = new FileInputStream(file);

      ReadResponse ofdReadResponse = ofdReader.read(
          ReadRequest.builder().inputStream(fileInputStream).parallel(request.getParallel())
              .build());
      if (ofdReadResponse.isSuccess()) {
        TaContextInfo taContextInfo = TaContextInfo.builder()
            .lastModified(lastModified)
            .fileUri(ofdReadResponse.getTaFileHeader().getFileUri()).build();
        Stream<TaEntity> stream = ofdReadResponse.getFileStream().map(
            ar ->
                convertBean(ar,ofdReadResponse)
        ).peek(
            taEntity -> {
              taEntity.setRegistrarCode(request.getTaCode());
              taEntity.setTaContextInfo(taContextInfo);
            }
        );

        return TaFileParseResponse.builder()
            .success(true)
            .taFileHeader(ofdReadResponse.getTaFileHeader())
            .total(ofdReadResponse.getTaFileHeader().getTotal())
            .lastModifyTime(lastModified)
            .stream(stream).build();
      }
      return TaFileParseResponse.builder()
          .success(false).taFileHeader(ofdReadResponse.getTaFileHeader())
          .errorDetail(ofdReadResponse.getErrorDetail())
          .lastModifyTime(lastModified)
          .build();
    } catch (FileNotFoundException e) {
      return TaFileParseResponse.builder()
          .success(false).taFileHeader(null)
          .errorDetail("文件不存在")
          .lastModifyTime(null)
          .build();
    }


  }

  private TaEntity convertBean(String[] ar, ReadResponse ofdReadResponse) {

    Class<? extends  TaEntity> clazz = TaEntityClassHelper.getTaEntity(getFileType());

    TaEntity taEntity;
    try {
      taEntity =  clazz.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new RuntimeException("convert map to object[type=" + clazz.getName() + "] error: " + e.getMessage(), e);
    }
    int index =0;
    for (Field field:ofdReadResponse.getTaFileHeader().getFields()
    ) {
      if(ar[index]==null){
        continue;
      }
      String name = MybatisUtil.underlineToCamel(field.getName(), false);
      SetterMeta meta = SetterMeta.get(clazz, name);
      if (meta == null) {
        throw new RuntimeException("property[" + name + "] of class[" + clazz.getName() + "] not found.");
      }
      try {
        this.setDefaultType(meta,taEntity,ar[index]);
      }catch (Exception e){
        log.error(e.getMessage(),e);
      }
      index++;
    }
    return  taEntity;
  }

  void setDefaultType(SetterMeta meta, Object target, Object value) throws InvocationTargetException, IllegalAccessException {
    Class<?> type = (Class<?>) meta.fType;
    if (type == Long.class) {
      meta.setValue(target, Long.parseLong(value.toString()));
    } else if (type == Integer.class) {
      meta.setValue(target, Integer.parseInt(value.toString()));
    } else if (type == Boolean.class) {
      meta.setValue(target, ObjectArray.toBoolean(value));
    } else if (type == BigDecimal.class) {
      meta.setValue(target, new BigDecimal(value.toString()));
    } else if (type == BigInteger.class) {
      meta.setValue(target, new BigInteger(value.toString()));
    } else if (value instanceof Timestamp) {
      Timestamp t = (Timestamp) value;
      if (type == LocalDateTime.class) {
        meta.setValue(target, t.toLocalDateTime());
      } else if (type == LocalDate.class) {
        meta.setValue(target, LocalDate.from(t.toInstant().atZone(ZoneOffset.systemDefault())));
      } else if (type == LocalTime.class) {
        meta.setValue(target, LocalTime.from(t.toInstant().atZone(ZoneOffset.systemDefault())));
      } else {
        meta.setValue(target, value);
      }
    } else {
      meta.setValue(target, value);
    }
  }

}
