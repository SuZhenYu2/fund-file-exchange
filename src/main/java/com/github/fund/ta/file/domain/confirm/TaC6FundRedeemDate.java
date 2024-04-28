package com.github.fund.ta.file.domain.confirm;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 理财产品可赎回日期 C6文件
 *
 * @author suzhenyu
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaC6FundRedeemDate extends TaEntity {

  /**
   * C 6 基金代码 Y
   */
  private String fundCode;
  /**
   * A 1 收费方式 0-前收费，1-后收费 Y
   */
  private String shareClass;
  /**
   * A 8 份额注册日期 Y
   */
  private String shareRegisterDate;
  /**
   * A 8 可赎回日期 可提交赎回申请的日期 Y
   */
  private String allowRedemptDate;
  /**
   * C 1 增删标志 0-作废，1-新增 Y
   */
  private String addFlag;


  @Override
  public FileTypeEnum getFileType() {
    return FileTypeEnum.FILE_TYPE_C6;
  }

  @Override
  public String getSortValue() {
    return fundCode;
  }
}
