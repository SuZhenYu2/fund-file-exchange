package com.github.fund.ta.file.parser;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.confirm.Ta05StaticsShare;
import com.github.fund.ta.file.io.ReadRequest;
import com.github.fund.ta.file.io.ReadResponse;
import com.github.fund.ta.file.io.TaFileHeader;
import com.github.fund.ta.file.io.TaFileReader;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 * 基金基础参数（C1 文件）
 */
@Slf4j
public class DefaultTaFileParserFactoryTest {


  @Test
  public void test04() {
    parseFile("05", "20210714", FileTypeEnum.FILE_TYPE_04);

  }

  @Test
  public void test02() {

    parseFile("05", "20210714", FileTypeEnum.FILE_TYPE_02);

  }

  @Test
  public void test05() {

    parseFile("98", "20231122", FileTypeEnum.FILE_TYPE_05);

  }

  @Test
  public void test06() {

    parseFile("05", "20210714", FileTypeEnum.FILE_TYPE_06);

  }

  @Test
  public void test07() {

    parseFile("05", "20210714", FileTypeEnum.FILE_TYPE_07);

  }

  @Test
  public void test08() {

    parseFile("05", "20210714", FileTypeEnum.FILE_TYPE_08);

  }

  @Test
  public void testR2() {

    parseFile("05", "20210714", FileTypeEnum.FILE_TYPE_R2);

  }

  @Test
  public void testX2() {

    parseFile("05", "20210714", FileTypeEnum.FILE_TYPE_X2);

  }

  @Test
  public void testX4() {

    parseFile("05", "20210714", FileTypeEnum.FILE_TYPE_X4);

  }

  @Test
  public void test26() {

    parseFile("05", "20210714", FileTypeEnum.FILE_TYPE_26);

  }

  @Test
  public void test44() {

    parseFile("05", "20210714", FileTypeEnum.FILE_TYPE_44);

  }

  @Test
  public void test25() {

    parseFile("05", "20210714", FileTypeEnum.FILE_TYPE_25);

  }

  @Test
  public void test47() {
    Stream.generate(() -> 1).limit(100).forEach(
        (i) -> parseFile("47", "20230116", FileTypeEnum.FILE_TYPE_04)
    );

  }

  @Test
  public void test47_05() {
    Stream.generate(() -> 1).limit(100).forEach(
        (i) -> parseFile("47", "20230116", FileTypeEnum.FILE_TYPE_05)
    );

  }

  private TaFileReader ofdReader = new TaFileReader();

  @Test
  public void test47_05_() {

    String fileUri =
        DefaultTaFileParserFactoryTest.class.getClassLoader().getResource("").getPath() + "/"
            + "OFD_47_001_20230116_05.TXT";
    File smbFile = new File(fileUri);
    AtomicLong atomicLong = new AtomicLong(0);

    Long start = System.currentTimeMillis();
    if (smbFile.isFile()) {
      try (InputStream inputStream = new FileInputStream(smbFile)) {
        ReadResponse ofdReadResponse = this.ofdReader.read(
            ReadRequest.builder().inputStream(inputStream).parallel(true).build());
        ofdReadResponse.getFileStream();
        try (Stream<String[]> stream = ofdReadResponse.getFileStream()) {
          TaFileHeader taFileHeader = ofdReadResponse.getTaFileHeader();
                stream.forEach(
                    strings -> {
                      Long l = atomicLong.addAndGet(1);
                      if (l % 100000 == 0) {
                        StringBuffer stringBuffer = new StringBuffer();
                        log.info(" 解析行数:" + l + " 耗时:" + (System.currentTimeMillis() - start) / 1000);
                        for (String s : strings
                        ) {
                          stringBuffer.append(s);
                        }
                        log.info(stringBuffer.toString());
                      }
                     }

                );

        } catch (Exception e) {
          log.error(e.getMessage(), e);
        }

        log.info(fileUri + " 解析完成 耗时:" + (System.currentTimeMillis() - start) / 1000);
      } catch (Exception e) {
        log.error(e.getMessage(), e);
      }
    }

  }

  private void parseFile(String taCode, String date, FileTypeEnum fileTypeEnum) {
    try {

      TaFileParseRequest taFileParseRequest = TaFileParseRequest.builder()
          .date(date)
          .path(DefaultTaFileParserFactoryTest.class.getClassLoader().getResource("").getPath())
          .taCode(taCode)
          .build();
      TaFileParseResponse<Ta05StaticsShare> taFileParseResponse = DefaultTaFileParserFactory.newInstance()
          .newTaFileParser(fileTypeEnum)
          .parse(taFileParseRequest);

      System.out.println(taFileParseResponse.isSuccess());

      System.out.println(taFileParseResponse.getTaFileHeader());
      long start = System.currentTimeMillis();
      AtomicInteger count = new AtomicInteger(0);
      try (Stream<Ta05StaticsShare> stream = taFileParseResponse.getStream()) {
        stream.forEach(t -> {
//          if (count.incrementAndGet() % 10000 == 0) {
//            log.info(" 解析行数:" + count.get() + " 耗时:" + (System.currentTimeMillis() - start) / 1000);
//          }
          if(!t.isDetail()){
            log.info(t.toString());
          }
        });

      } catch (Exception ignored) {

      }

//      TaFileGeneratorRequest taFileGeneratorRequest = TaFileGeneratorRequest.builder()
//          .taFileHeader(taFileParseResponse.getTaFileHeader()).taCode(taCode).date(date)
//          .path(DefaultTaFileParserFactoryTest.class.getClassLoader().getResource("").getPath()
//              + "/request")
//          .fileStream(taFileParseResponse.getStream()).build();
//
//      TaFileGeneratorResponse taFileGeneratorResponse = DefaultTaFileGeneratorFactory.newInstance()
//          .newTaFileGenerator(fileTypeEnum).generator(
//              taFileGeneratorRequest
//          );

//      log.info(taFileGeneratorResponse.toString());

    } catch (Exception e) {
      e.printStackTrace();

    }

//    if (taFileParseResponse.isSuccess() && taFileParseResponse.getTotal() > 0) {
//      AtomicInteger count = new AtomicInteger(0);
//      taFileParseResponse.getStream().parallel().forEach(
//          taEntity -> {
//            log.info(taEntity.toString());
////            if (count.incrementAndGet() % 1000 == 0) {
////              log.info(count.get() + "");
////            }
//          }
//      );
//      taFileParseResponse.getStream().close();
//    }
//    System.out.println(taFileParseResponse.isSuccess());

  }

}
