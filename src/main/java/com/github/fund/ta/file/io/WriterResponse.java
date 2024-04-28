package com.github.fund.ta.file.io;

import lombok.Builder;
import lombok.Data;

/**
 * ReadResponse
 *
 * @author suzhenyu
 */
@Data
@Builder
public class WriterResponse {


  private boolean success;


  private String errorDetail;



}
