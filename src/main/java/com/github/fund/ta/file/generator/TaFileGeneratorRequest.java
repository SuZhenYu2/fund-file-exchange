package com.github.fund.ta.file.generator;

import com.github.fund.ta.file.domain.confirm.TaEntity;
import com.github.fund.ta.file.io.TaFileHeader;
import lombok.Builder;
import lombok.Data;

import java.util.stream.Stream;

import static com.github.fund.ta.file.domain.TaFileConstants.DISTRIBUTOR_CODE_DAN_JUAN;

/**
 * todo 备注
 *
 * @author suzhenyu
 * @since 2021/3/17 5:52 下午
 */
@Data
@Builder
public class TaFileGeneratorRequest<T extends TaEntity> {

  private String path;

  @Builder.Default
  private String charsetName = "GB18030";
  @Builder.Default
  private String fileEndStr = "OFDCFEND";

  private String number;
  @Builder.Default
  private String distributeCode = DISTRIBUTOR_CODE_DAN_JUAN;
  private TaFileHeader taFileHeader;
  private Stream<T> fileStream;


}
