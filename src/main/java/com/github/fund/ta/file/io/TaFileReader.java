package com.github.fund.ta.file.io;

import com.github.fund.ta.file.domain.Field;
import com.github.fund.ta.file.domain.FileCommonEnum.OFDCFTypeEnum;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;

/**
 * Reader
 *
 * @author suzhenyu
 */
@Slf4j
public class TaFileReader {

  /**
   * read
   *
   * @param request 请求参数
   * @return 返回值
   */
  public ReadResponse read(ReadRequest request) {
    Stream<String[]> stream = null;
    try {
      Charset charset =Charsets.toCharset("UTF-8");
      LineIterator it = IOUtils.lineIterator(request.getInputStream(), request.getCharset());
      OFDCFTypeEnum ofdcfTypeEnum = getFileType(it);
      TaFileHeader taFileHeader = getFileHeader(it, ofdcfTypeEnum);
      // 一次读入一行，直到读入null为文件结束
      FileLineSpliterator<String> fileLineSpliterator = new FileLineSpliterator<>(it,
            request.getFileEndStr(), new AtomicLong(0));

      Stream<String> streamTemp;
      if (request.getParallel()) {
        streamTemp = fileLineSpliterator.parallelStream();
      } else {
        streamTemp = fileLineSpliterator.stream();
      }
      stream = streamTemp.map(
          str -> {
            try {
              // 显示行号
              return convertArray(request, str, taFileHeader,charset);
            } catch (Exception e) {
              fileLineSpliterator.stream().close();
              throw new RuntimeException(e);
            }
          }
      ).onClose(
          () -> {
            try {
              close(it, request.getInputStream());
            } catch (IOException e) {
              log.error(e.getMessage(), e);
            }
          }

      );

      return ReadResponse.builder()
          .success(true)
          .taFileHeader(taFileHeader)
          .fileStream(stream)
          .build();
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      if (Objects.nonNull(stream)) {
        stream.close();
      }
    }
    return ReadResponse.builder()
        .success(false)
        .errorDetail("读取发生异常，详情查看日志")
        .build();

  }


  private String[] convertArray(ReadRequest request, String str, TaFileHeader taFileHeader,
      Charset charset)
      throws UnsupportedEncodingException {
    byte[] bytes = str.getBytes(request.getCharset());
    String[] strings = new String[taFileHeader.getFiledCount()];
    int idx = 0;
    int index = 0;
    for (Field field : taFileHeader.getFields()) {
      int length = field.getLength();
      String fieldValue = new String(new String(bytes, idx, length, request.getCharset()).getBytes(charset));
      idx += length;
      fieldValue = field.getType().getValue(fieldValue, field);
      strings[index] = StringUtils.trim(fieldValue);
      index++;
    }
    return strings;
  }

  private TaFileHeader getFileHeader(LineIterator reader, OFDCFTypeEnum ofdcfTypeEnum)
      throws IOException {

    return ofdcfTypeEnum.getTaFileHeader(reader);

  }


  private OFDCFTypeEnum getFileType(LineIterator reader) throws IOException {
    String type = reader.nextLine();
    return OFDCFTypeEnum.getOFDCFTypeEnumByType(type);
  }

  public static void close(Closeable closeable) throws IOException {
    if (closeable != null) {
      closeable.close();
    }

  }

  public static void close(Closeable... closeables) throws IOException {
    if (closeables != null) {
      for (Closeable closeable : closeables) {
            close(closeable);
        }
    }

  }
}
