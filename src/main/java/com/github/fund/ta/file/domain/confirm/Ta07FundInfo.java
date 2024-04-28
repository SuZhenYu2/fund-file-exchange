package com.github.fund.ta.file.domain.confirm;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 基金信息
 *
 * @author suzhenyu
 * @since 2021/3/16 9:48 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Ta07FundInfo extends TaEntity {

  /**
   * C 300 基金名称 Y
   */
  private String fundName;
  /**
   * N 16（两位小数）基金总份数 Y
   */
  private BigDecimal totalFundVol;
  /**
   * C 6 基金代码 Y 81
   */
  private String fundCode;
  /**
   * C 1 基金状态 0-可申购赎回，1-发行4-停止申购赎回5-停止申购，6-停止赎回8-基金终止，9-基金封闭Y
   */
  private String fundStatus;
  /**
   * N 7（四位小数）基金单位净值 Y
   */
  private BigDecimal nav;
  /**
   * A 8 基金净值日期 格式为：YYYYMMDD对 ETF、QDII 基金的申购或赎回净值，此字段的含义为该申购或赎回净值适用的交易申请的日期。Y
   */
  private String updateDate;
  /**
   * C 1 净值类型0-普通净值 1-申购净值 2-赎回净值对 ETF、QDII 基金可同时下发 3 条净值记录，通过此字段区分基金单位净值及基金净值日期的含义。 Y
   */
  private String netValueType;
  /**
   * N 7（四位小数）累计基金单位净值 Y
   */
  private BigDecimal accumulativeNAV;
  /**
   * C 1 基金转换状态 0-可转入，可转出1-只可转入2-只可转出3-不可转换 Y
   */
  private String convertStatus;
  /**
   * C 1 定期定额状态0-允许定期定额业务1-仅允许定投业务2-仅允许定赎业务3-禁止定期定额业务 Y
   */
  private String periodicStatus;
  /**
   * C 1 转托管状态 0-允许所有转托管1-仅允许场外转托管2-仅允许跨市场转托管 3-禁止所有转托管 Y
   */
  private String transferAgencyStatus;
  /**
   * N 16（两位小数）基金规模 基金的金额规模 Y
   */
  private BigDecimal fundSize;
  /**
   * A 3 结算币种 具体编码依 GB/T 12406-2008 中 3 位数字 Y
   */
  private String currencyType;
  /**
   * C 1 公告标志 0-公告 1-不公告 Y
   */
  private String announcFlag;
  /**
   * A 1 默认分红方式
   */
  private String defDividendMethod;
  /**
   * N 16（两位 小数）法人追加认购金额 N 3
   */
  private BigDecimal instAppSubsAmnt;
  /**
   * N 16（两位 小数）法人追加认购份数
   */
  private BigDecimal instAppSubsVol;
  /**
   * N 16（两位小数）法人首次认购最低金额 N
   */
  private BigDecimal minAmountByInst;
  /**
   * N 16（两位小数）法人首次认购最低份数 N
   */
  private BigDecimal minVolByInst;


  /**
   * C 18 托管人代码 N
   */
  private String custodianCode;
  /**
   * N 16（两位小数）定时定额申购的金额 N
   */
  private BigDecimal amountOfPeriodicSubs;
  /**
   * A 8 定时定额申购日期 格式为：YYYYMMDD N
   */
  private String dateOfPeriodicSubs;
  /**
   * N 16（两位小数）基金最高赎回份数 N
   */
  private BigDecimal maxRedemptionVol;
  /**
   * N 16（两位小数）基金最低持有份数 N 82
   */
  private BigDecimal minAccountBalance;
  /**
   * A 8 基金募集开始日期 格式为：YYYYMMDD N
   */
  private String iPOStartDate;
  /**
   * A 8 基金募集结束日期 格式为：YYYYMMDD N
   */
  private String iPOEndDate;
  /**
   * C 18 基金管理人 N
   */
  private String fundManagerCode;
  /**
   * N 16（两位小数）个人追加认购份数 N
   */
  private BigDecimal indiAppSubsVol;
  /**
   * N 16（两位小数）个人追加认购金额 N
   */
  private BigDecimal indiAppSubsAmount;
  /**
   * N 16（两位小数）个人首次认购最低份数 N
   */
  private BigDecimal minSubsVolByIndi;
  /**
   * N 16（两位小数）个人首次认购最低金额 N
   */
  private BigDecimal minSubsAmountByIndi;
  /**
   * C 18 注册登记人代码 N
   */
  private String registrarCode;
  /**
   * C 18 基金发起人 N
   */
  private String fundSponsor;
  /**
   * N 7（四位小数）交易价格 N
   */
  private BigDecimal tradingPrice;
  /**
   * N 7（四位小数）基金面值 N
   */
  private BigDecimal faceValue;
  /**
   * A 8 分红日/发放日 N
   */
  private String dividentDate;
  /**
   * A 8 权益登记日期 格式为：YYYYMMDD N
   */
  private String registrationDate;
  /**
   * A 8 除权日 表示最近一次除权日期 N
   */
  private String xRDate;
  /**
   * 下一开放期结束日
   */
  private BigDecimal maxSubsVolByIndi;
  /**
   * N 16（两位小数）个人最高认购金额 N
   */
  private BigDecimal maxSubsAmountByIndi;
  /**
   * N 16（两位小数）法人最高认购份数 N
   */
  private BigDecimal maxSubsVolByInst;
  /**
   * N 16（两位小数）法人最高认购金额 N
   */
  private BigDecimal maxSubsAmountByInst;
  /**
   * N 16（两位小数）个人认购份数单位 表示级差含义 N
   */
  private BigDecimal unitSubsVolByIndi;
  /**
   * N 16（两位小数）个人认购金额单位 表示级差含义 N
   */
  private BigDecimal unitSubsAmountByIndi;
  /**
   * N 16（两位小数）法人认购份数单位 表示级差含义 N
   */
  private BigDecimal unitSubsVolByInst;
  /**
   * N 16（两位小数）法人认购金额单位 表示级差含义 N
   */
  private BigDecimal unitSubsAmountByInst;
  /**
   * N 16（两位小数）个人首次申购最低金额 N
   */
  private BigDecimal minBidsAmountByIndi;
  /**
   * N 16（两位小数）法人首次申购最低金额 N
   */
  private BigDecimal minBidsAmountByInst;
  /**
   * N 16（两位小数）个人追加申购最低金额 N
   */
  private BigDecimal minAppBidsAmountByIndi;
  /**
   * N 16（两位小数）法人追加申购最低金额 N
   */
  private BigDecimal minAppBidsAmountByInst;
  /**
   * N 16（两位小数）基金最少赎回份数 N
   */
  private BigDecimal minRedemptionVol;
  /**
   * N 16（两位小数）最低基金转换份数 N
   */
  private BigDecimal minInterconvertVol;
  /**
   * C 1 个人发行方式 1-比例发行2-摇号 3-先来先买 N
   */
  private String issueTypeByIndi;
  /**
   * C 1 机构发行方式 1-比例发行2-摇号3-先来先买 N
   */
  private String issueTypeByInst;
  /**
   * C 1 认购方式 0-金额认购1-份数认购 N
   */
  private String subsType;
  /**
   * C 1 交易费收取方式 0-价内费 1-价外费 N 83
   */
  private String collectFeeType;
  /**
   * A 8 下一开放日 N
   */
  private String nextTradeDate;
  /**
   * N 7（两位小数）产品价值线数值 N
   */
  private BigDecimal valueLine;
  /**
   * N 8(五位小数)累计单位分红 N
   */
  private BigDecimal totalDivident;
  /**
   * N 8(五位小数) 货币基金万份收益 货币基金必填 N
   */
  private BigDecimal fundIncome;
  /**
   * C 1 货币基金万份收益正负0-正 1-负货币基金必填 N
   */
  private String fundIncomeFlag;
  /**
   * N 8(五位小数)货币基金七日年化收益率 货币基金必填 N
   */
  private BigDecimal yield;
  /**
   * C 1货币基金七日年化收益率正负0-正 1-负货币基金必填 N
   */
  private String yieldFlag;
  /**
   * N 7(四位小数) 保本净值 N
   */
  private BigDecimal guaranteedNAV;
  /**
   * N8(五位小数) 货币基金年收益率 最近一年来的收益率 N
   */
  private BigDecimal fundYearIncomeRate;
  /**
   * C 1 货币基金年收益率正负 N
   */
  private String fundYearIncomeRateFlag;
  /**
   * N 16( 两 位小数)个人最大申购金额 N
   */
  private BigDecimal indiMaxPurchase;
  /**
   * N 16( 两 位小数)法人最大申购金额 N
   */
  private BigDecimal instMaxPurchase;
  /**
   * N 16( 两 位小数)个人当日累计购买最大金额 N
   */
  private BigDecimal indiDayMaxSumBuy;
  /**
   * N 16( 两 位小数)法人当日累计购买最大金额 N
   */
  private BigDecimal instDayMaxSumBuy;
  /**
   * N 16( 两 位小数)个人当日累计赎回最大份额 N
   */
  private BigDecimal indiDayMaxSumRedeem;
  /**
   * N 16( 两 位小数)法人当日累计赎回最大份额 N
   */
  private BigDecimal instDayMaxSumRedeem;
  /**
   * N 16( 两 位小数)个人最大赎回份额 N
   */
  private BigDecimal indiMaxRedeem;
  /**
   * N 16( 两 位小数) 法人最大赎回份额 N
   */
  private BigDecimal instMaxRedeem;
  /**
   * C 1 基金当日总收益正负 货币基金必填 N
   */
  private String fundDayIncomeFlag;
  /**
   * N 16( 两 位小数)基金当日总收益 货币基金必填 N
   */
  private BigDecimal fundDayIncome;
  /**
   * C 1 允许违约赎回标志 0-允许，1-不允许 N
   */
  private String allowBreachRedempt;
  /**
   * C 2 基金类型 N
   */
  private String fundType;
  /**
   * C 30 基金类型名称 N
   */
  private String fundTypeName;
  /**
   * C 100 注册登记人名称 N
   */
  private String registrarName;
  /**
   * C 100 基金管理人名称 N
   */
  private String fundManagerName;
  /**
   * C 30 基金公司客服电话 N 84
   */
  private String fundServerTel;
  /**
   * C 200 基金公司网站网址 N
   */
  private String fundInternetAddress;
  /**
   * 主基金代码
   */
  private String mainFundCode;
  /**
   * 侧袋标志
   */
  private String sideBagFlag;
  /**
   * 下一开放期结束日
   */
  private String nextTradeEndDate;

  private final static String FLAG_1 = "1";

  public BigDecimal getFundIncome() {
    if (FLAG_1.equals(getFundIncomeFlag())) {
      fundIncome = fundIncome.multiply(BigDecimal.valueOf(-1));
    }
    return fundIncome;
  }

  public BigDecimal getYield() {
    if (FLAG_1.equals(getYieldFlag())) {
      yield = yield.multiply(BigDecimal.valueOf(-1));
    }
    return yield;
  }

  public BigDecimal getFundYearIncomeRate() {
    if (FLAG_1.equals(getFundYearIncomeRateFlag())) {
      fundYearIncomeRate = fundYearIncomeRate.multiply(BigDecimal.valueOf(-1));
    }
    return fundYearIncomeRate;
  }

  public BigDecimal getFundDayIncome() {
    if (FLAG_1.equals(getFundDayIncomeFlag())) {
      fundDayIncome = fundDayIncome.multiply(BigDecimal.valueOf(-1));
    }
    return fundDayIncome;
  }

  @Override
  public FileTypeEnum getFileType() {
    return FileTypeEnum.FILE_TYPE_07;
  }

  @Override
  public String getSortValue() {
    return fundCode;
  }


}
