package com.github.fund.ta.file.parser;

import static com.github.fund.ta.file.domain.TaFileConstants.DISTRIBUTOR_CODE_DAN_JUAN;

import lombok.Builder;
import lombok.Data;

/**
 * todo 备注
 *
 * @author suzhenyu
 * @since 2021/3/17 5:52 下午
 */
@Data
@Builder
public class TaFileParseRequest {

  private String taCode;
  private String path;
  private String date;
  private String number;
  @Builder.Default
  private String distributeCode = DISTRIBUTOR_CODE_DAN_JUAN;
  @Builder.Default
  private String charsetName = "GB18030";
  @Builder.Default
  private Boolean parallel = false;


}
