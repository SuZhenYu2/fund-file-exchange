package com.github.fund.ta.file.parser;

import com.github.fund.ta.file.domain.confirm.TaEntity;
import com.github.fund.ta.file.io.TaFileHeader;
import java.util.stream.Stream;
import lombok.Builder;
import lombok.Data;

/**
 * TaFileParseResponse
 *
 * @author suzhenyu
 */
@Data
@Builder
public class TaFileParseResponse<T extends TaEntity> {

  private boolean success;

  private String errorDetail;
  /**
   * 文件更新时间
   */
  private Long lastModifyTime;
  /**
   * 总数量
   */
  private Long total;
  /**
   * taFileHeader
   */
  private TaFileHeader taFileHeader;

  /**
   * stream
   */
  private Stream<T> stream;


}
