package com.github.fund.ta.file.domain.confirm;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 06 分红确认
 *
 * @author suzhenyu
 * @since 2021/3/16 9:46 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Ta06Dividend extends TaEntity {

  /**
   * N 16（两位小数）红利/红利再投资基数 登记日基金持有人的基金份数 Y
   */
  private BigDecimal basisforCalculatingDividend;
  /**
   * A 8 交易确认日期 格式为：YYYYMMDD Y
   */
  private String transactionCfmDate;
  /**
   * A 3 结算币种 具体编码依 GB/T 12406-2008 中 3 位数字 Y
   */
  private String currencyType;
  /**
   * N 16（两位小数）基金账户红利再投资基金份数投资人实得红股，含被续冻的红股 Y
   */
  private BigDecimal volOfDividendforReinvestment;
  /**
   * A 8 分红日/发放日 Y
   */
  private String dividentDate;
  /**
   * N 16（两位小数）基金账户红利资金 红利总金额,含冻结红利及再投资的红利 Y
   */
  private BigDecimal dividendAmount;
  /**
   * A 8 除权日 Y
   */
  private String xRDate;
  /**
   * N 16（两位小数）每笔交易确认金额 实发红利资金，不含冻结红利及再投资的红利 Y
   */
  private BigDecimal confirmedAmount;
  /**
   * C 6 基金代码 Y
   */
  private String fundCode;
  /**
   * A 8 权益登记日期 格式为：YYYYMMDD Y
   */
  private String registrationDate;
  /**
   * A 4 交易处理返回代码 取值见附录 B Y
   */
  private String returnCode;
  /**
   * C 17 投资人基金交易账号 投资人在销售机构内开设的用于交易的账号 Y
   */
  private String transactionAccountID;
  /**
   * C 9 销售人代码 Y
   */
  private String distributorCode;
  /**
   * C 3 业务代码 编码见表 4 Y
   */
  private String businessCode;
  /**
   * C 12 投资人基金账号 Y
   */
  private String tAAccountID;
  /**
   * N 16( 两 位小数)单位基金分红金额（含税）举例：每千份分两元，则此处填 2。 Y
   */
  private BigDecimal dividendPerUnit;
  /**
   * A 1 默认分红方式 0-红利转投，1-现金分红投资人本次分红的方式 Y
   */
  private String defDividendMethod;
  /**
   * C 19 投资人在销售人处用于交易的资金账号 N
   */
  private String depositAcct;
  /**
   * A 4 交易所在地区编号 N
   */
  private String regionCode;
  /**
   * A 8 交易数据下传日期 指发送日期 Y
   */
  private String downLoaddate;
  /**
   * N 16（两位小数）手续费 Y
   */
  private BigDecimal charge;
  /**
   * N 16（两位 代理费 Y 80小数）
   */
  private BigDecimal agencyFee;
  /**
   * N 16（两位小数）基金冻结总份数 N
   */
  private BigDecimal totalFrozenVol;
  /**
   * N 7（四位小数）基金单位净值 N
   */
  private BigDecimal nav;
  /**
   * C 9 网点号码 托管网点号码。对大集中方式的销售人，此字段与销售人代码相同。Y
   */
  private String branchCode;
  /**
   * N 16（两位小数）其他费用 1 N
   */
  private BigDecimal otherFee1;
  /**
   * N 16（两位小数）其他费用 2 N
   */
  private BigDecimal otherFee2;
  /**
   * A 1 个人/机构标志 0-机构，1-个人，2-产品 N
   */
  private String individualOrInstitution;
  /**
   * N 16（两位小数）红利比例 N
   */
  private BigDecimal dividendRatio;
  /**
   * N 16（两位小数）印花税 N
   */
  private BigDecimal stampDuty;
  /**
   * N 16（两位小数）冻结金额 N
   */
  private BigDecimal frozenBalance;
  /**
   * N 16（两位小数）过户费 Y
   */
  private BigDecimal transferFee;
  /**
   * A 1 收费方式 0-前收费，1-后收费 Y
   */
  private String shareClass;
  /**
   * A 1 计费人 0-TA 计费 1-基金计费 N
   */
  private String feeCalculator;
  /**
   * N 10 分红单位 举例：每千份分多少，则分红单位就为一千 Y
   */
  private Integer drawBonusUnit;
  /**
   * N 16(两位小数)冻结再投资份额 N
   */
  private BigDecimal frozenSharesforReinvest;
  /**
   * C 1 分红类型0-普通分红，1-质押基金分红，2-货币基金收益结转，3-保本基金赔付，4-产品到 期处理 Y
   */
  private String dividendType;
  /**
   * C 24 原申请单编号 对质押基金分红为 Y 项，表示原质押业务的申请单编号 N
   */
  private String originalAppSheetNo;
  /**
   * N 16( 两 位小数)业绩报酬 Y
   */
  private BigDecimal achievementPay;
  /**
   * N 16( 两 位小数)业绩补偿 Y
   */
  private BigDecimal achievementCompen;
  /**
   * C 20 TA 确认交易流水号 N
   */
  private String tASerialNO;


  @Override
  public FileTypeEnum getFileType() {
    return FileTypeEnum.FILE_TYPE_06;
  }

  @Override
  public String getSortValue() {
    return tASerialNO;
  }


}
