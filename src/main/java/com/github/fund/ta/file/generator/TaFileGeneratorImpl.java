package com.github.fund.ta.file.generator;

import cn.org.atool.fluent.mybatis.utility.PoJoHelper;
import com.github.fund.ta.file.domain.Field;
import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.confirm.TaEntity;
import com.github.fund.ta.file.helper.TaEntityClassHelper;
import com.github.fund.ta.file.helper.TaUrlPathHelper;
import com.github.fund.ta.file.io.TaFileWriter;
import com.github.fund.ta.file.io.WriterRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.commons.lang3.time.StopWatch;

import static java.nio.file.Files.newOutputStream;

/**
 * ta file parser impl
 *
 * @author suzhenyu
 * @since 2021/3/17 5:46 下午
 */
@Slf4j
public class TaFileGeneratorImpl<T extends TaEntity> implements TaFileGenerator<T> {


  private final FileTypeEnum fileType;


  public TaFileGeneratorImpl(FileTypeEnum fileType) {
    this.fileType = fileType;
  }

  @Override
  public FileTypeEnum getFileType() {
    return fileType;
  }

  @Override
  public TaFileGeneratorResponse generator(TaFileGeneratorRequest taFileGeneratorRequest) {
    StopWatch stopWatch = new StopWatch();
    Long lines = 0L;
    String fileUri = TaUrlPathHelper.getFileUri(taFileGeneratorRequest.getPath(),
            taFileGeneratorRequest.getTaFileHeader().getSender(),
            taFileGeneratorRequest.getDistributeCode(),
            taFileGeneratorRequest.getTaFileHeader().getDate(), getFileType(),
            taFileGeneratorRequest.getNumber());
    File file;
    try {
       file =TaFileWriter.createNewFile(fileUri, true);
    }catch (IOException ioException){
      throw new RuntimeException(ioException.getMessage());
    }
    try (
            OutputStream outputStream = newOutputStream(file.toPath())
    ){

      stopWatch.start();
      taFileGeneratorRequest.getTaFileHeader().setFileTypeEnum(fileType);
      List<Field> fieldList = taFileGeneratorRequest.getTaFileHeader().getTaProtocolVersion()
          .getMapField().get(TaEntityClassHelper.getTaEntity(fileType));
      taFileGeneratorRequest.getTaFileHeader().setFields(fieldList);
      WriterRequest writerRequest = WriterRequest.builder()
          .fileEndStr(taFileGeneratorRequest.getFileEndStr()).fileStream(
              taFileGeneratorRequest.getFileStream().map(PoJoHelper::toMap)
          ).outputStream(outputStream)
          .taFileHeader(taFileGeneratorRequest.getTaFileHeader())
          .charsetName(taFileGeneratorRequest.getCharsetName())
          .build();
      lines = TaFileWriter.writer(writerRequest);
      return TaFileGeneratorResponse.builder().success(true).costTime(stopWatch.getTime())
          .total(lines).fileUri(fileUri).build();
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return TaFileGeneratorResponse.builder().success(false).errorDetail(e.getMessage())
          .costTime(stopWatch.getTime()).total(lines).build();
    } finally {
      stopWatch.stop();
    }
  }
}
