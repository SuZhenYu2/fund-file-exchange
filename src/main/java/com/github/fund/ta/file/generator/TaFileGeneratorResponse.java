package com.github.fund.ta.file.generator;

import lombok.Builder;
import lombok.Data;

/**
 * TaFileParseResponse
 *
 * @author suzhenyu
 */
@Data
@Builder
public class TaFileGeneratorResponse {

  private boolean success;

  private String errorDetail;

  /**
   * 总数量
   */
  private Long total;
  /**
   * 总时间
   */
  private Long costTime;
  /**
   * 文件完整路径
   */
  private String fileUri;

}
