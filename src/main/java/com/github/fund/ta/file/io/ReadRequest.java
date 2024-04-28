package com.github.fund.ta.file.io;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import lombok.Builder;
import lombok.Data;


/**
 * read request
 *
 * @author suzhenyu
 * @since 2021/3/17 9:57 下午
 */
@Data
@Builder
public class ReadRequest {

  private InputStream inputStream;
  @Builder.Default
  private Boolean parallel=true;

  private Boolean firstCharLowercase;
  @Builder.Default
  private Charset charset = Charset.forName("GB18030");
  @Builder.Default
  private String fileEndStr = "OFDCFEND";


}
