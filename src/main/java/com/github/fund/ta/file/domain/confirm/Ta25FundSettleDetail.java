package com.github.fund.ta.file.domain.confirm;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 理财产品份额明细 26文件
 *
 * @author suzhenyu
 * @since 2021/3/16 10:08 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Ta25FundSettleDetail extends TaEntity {
  /**
   * A 20 序号 唯一确定一条记录，不能重复 Y
   */
  private String sequenceNo;
  /**
   *A 8 交易发生日期
   */
  private String transactionDate;
  /**
   * A 8 交易确认日期
   */
  private String transactionCfmDate;
  /**
   *A 3 结算币种
   */
  private String currencyType;
  /**
   *C 1 交易所标志 指基金发行渠道0-深圳场内（含场外）1-上海场内（含场外）2-场外Y
   */
  private String exchangeFlag;
  /**
   * C 30 销售人结算法人资金帐号
   */
  private String instAccount;
  /**
   *  C 6 基金代码 Y
   */
  private String fundCode;
  /**
   * C 9 销售人代码 Y
   */
  private String distributorCode;
  /**
   *  C 6 席位代码
   */
  private String seatCode;
  /**
   *   C 9 网点号码 托管网点号码。对大集中方式的销售人，此字段与销售人代码相同。此字段为 101 表示上海场内，为 102 表示深圳场内。 N
   */
  private String branchCode;
  /**
   * A 3 业务代码
   */
  private String businessCode;
  /**
   * C 3 资金类型
   */
  private String capitalType;
  /**
   *
   */
  private String confirmedAmount;
  private String receOrPayFlag;
  private String calculateDate;
  private String payDate;
  private String detailFlag;
  private String downLoaddate;



  @Override
  public FileTypeEnum getFileType() {
    return FileTypeEnum.FILE_TYPE_25;
  }

  @Override
  public String getSortValue() {
    return sequenceNo;
  }


}
