package com.github.fund.ta.file.io;

import java.util.stream.Stream;
import lombok.Builder;
import lombok.Data;

/**
 * ReadResponse
 *
 * @author suzhenyu
 */
@Data
@Builder
public class ReadResponse {


  private boolean success;

  private TaFileHeader taFileHeader;

  private String errorDetail;

  private Stream<String[]> fileStream;


}
