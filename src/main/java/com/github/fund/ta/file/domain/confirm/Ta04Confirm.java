package com.github.fund.ta.file.domain.confirm;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 04 交易确认数据
 * @author suzhenyu
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Ta04Confirm extends TaEntity{


    /**
     *C 24 申请单编号
     */
     private String  appSheetSerialNo;
    /**
     *A 8 交易确认日期
     */
     private String  transactionCfmDate;
    /**
     *A 3 结算币种
     */
     private String  currencyType;
    /**
     *N 16( 两 位小数)基金账户交易确认份数
     */
     private BigDecimal confirmedVol;
    /**
     *N 16( 两 位小数) 每笔交易确认金额
     */
     private BigDecimal  confirmedAmount;
    /**
     *C 6 基金代码
     */
     private String  fundCode;
    /**
     *A 1 巨额赎回处理标志
     */
     private String  largeRedemptionFlag;
    /**
     *A 8 交易发生日期
     */
     private String  transactionDate;
    /**
     *A 6 交易发生时间
     */
     private String  transactionTime;
    /**
     *A 4 交易处理返回代码
     */
     private String  returnCode;
    /**
     *C 17 投资人基金交易帐号
     */
     private String  transactionAccountID;
    /**
     *C 9 销售人代码
     */
     private String  distributorCode;
    /**
     *N 16( 两 位小数) 申请基金份数
     */
     private BigDecimal  applicationVol;
    /**
     *N 16( 两 位小数) 申请金额
     */
     private BigDecimal  applicationAmount;
    /**
     *C 3 业务代码
     */
     private String  businessCode;
    /**
     *C 12 投资人基金帐号 75
     */
     private String  tAAccountID;
    /**
     *C 20 TA 确认交易流水号
     */
     private String  tASerialNO;
    /**
     *C 1 业务过程完全结束标识
     */
     private String  businessFinishFlag;
    /**
     *N 5（四位小数）销售佣金折扣率
     */
     private BigDecimal  discountRateOfCommission;
    /**
     *C 19 投资人在销售人处用于交易的资金帐号
     */
     private String  depositAcct;
    /**
     *A 4 交易所在地区编号
     */
     private String  regionCode;
    /**
     *A 8 交易数据下传日期
     */
     private String  downLoaddate;
    /**
     *N 16（两位小数）手续费
     */
     private BigDecimal  charge;
    /**
     *N 16（两位小数）代理费
     */
     private BigDecimal  agencyFee;
    /**
     *N 7（四位小数）基金单位净值
     */
   
     private BigDecimal  nav;
    /**
     *C 9 网点号码
     */
     private String  branchCode;
    /**
     *C 24 原申请单编号
     */
     private String  originalAppSheetNo;
    /**
     *A 8 原申购日期
     */
     private String  originalSubsDate;
    /**
     *N 16（两位小数）其他费用 1
     */
     private BigDecimal  otherFee1;
    /**
     *A 1 个人/机构标志
     */
     private String  individualOrInstitution;
    /**
     *A 8 预约赎回日期
     */
     private String  redemptionDateInAdvance;
    /**
     *N 16( 两 位小数)印花税
     */
     private BigDecimal  stampDuty;
    /**
     *N 2 交易申请有效天数
     */
    private Integer validPeriod;
    /**
     *N 9（八位小数）费率
     */
     private BigDecimal  rateFee;
    /**
     *N 16（两位小数）交易后端收费总额
     */
     private BigDecimal  totalBackendLoad;
    /**
     *C 20 TA 的原确认流水号
     */
     private String  originalSerialNo;
    /**
     *C 60 摘要/说明
     */
     private String  specification;
    /**
     *A 8 定期定额申购日期
     */
     private String  dateOfPeriodicSubs;
    /**
     *C 9 对方销售人代码
     */
     private String  targetDistributorCode;
    /**
     *C 9 对方网点号
     */
     private String  targetBranchCode;
    /**
     *C 17 对方销售人处投资人基金交易帐号
     */
     private String  targetTransactionAccountID;
    /**
     *A 4 对方所在地区编号
     */
     private String  targetRegionCode;
    /**
     *A 1 转入/转出标识
     */
     private String  transferDirection;
    /**
     *A 1 默认分红方式
     */
     private String  defDividendMethod;
    /**
     *N 16（两位小数）红利比例
     */
     private BigDecimal  dividendRatio;
    /**
     *N 16（两位 基金账户利息金额 76 小数）
     */
     private BigDecimal  interest;
    /**
     *N 16（两位小数）利息产生的基金份数
     */
     private BigDecimal  volumeByInterest;
    /**
     *N 16（两位小数）利息税
     */
     private BigDecimal  interestTax;
    /**
     *N 7（四位小数）交易价格
     */
     private BigDecimal  tradingPrice;
    /**
     *A 8 冻结截止日期
     */
     private String  freezingDeadline;
    /**
     *A 1 冻结原因
     */
     private String  frozenCause;
    /**
     *N 16（两位小数）税金
     */
     private BigDecimal  tax;
    /**
     *N 7（四位小数）目标基金的单位净值
     */
     private BigDecimal  targetNAV;
    /**
     *N 7（四位小数）目标基金的价格
     */
     private BigDecimal  targetFundPrice;
    /**
     *N 16（两位小数）目标基金的确认份数
     */
     private BigDecimal  cfmVolOfTargetFund;
    /**
     *N 16（两位小数）最少收费
     */
     private BigDecimal  minFee;
    /**
     *N 16（两位小数）其他费用 2
     */
     private BigDecimal  otherFee2;
    /**
     *A 8 原申请日期
     */
     private String  originalAppDate;
    /**
     *N 16（两位小数）过户费
     */
     private BigDecimal  transferFee;
    /**
     *A 1 是否注册登记人发起业务标志
     */
     private String  fromTAFlag;
    /**
     *C 1 收费类别
     */
     private String  shareClass;
    /**
     *C 1 数据明细标志
     */
     private String  detailFlag;
    /**
     *A 1 预约赎回标志
     */
     private String  redemptionInAdvanceFlag;
    /**
     *A 1 冻结方式
     */
     private String  frozenMethod;
    /**
     *A 8 TA 的原确认日期
     */
     private String  originalCfmDate;
    /**
     *A 1 强行赎回原因
     */
     private String  redemptionReason;
    /**
     *C 6 转换时的目标基金代码
     */
     private String  codeOfTargetFund;
    /**
     *N 16（两位小数）交易确认费用合计
     */
     private BigDecimal  totalTransFee;
    /**
     *C 5 定时定额品种代码
     */
     private String  varietyCodeOfPeriodicSubs;
    /**
     *C 5 定时定额申购序号
     */
     private String  serialNoOfPeriodicSubs;
    /**
     *C 1 定期定额种类
     */
     private String  rationType;
    /**
     *C 12 对方基金账号
     */
     private String  targetTAAccountID;
    /**
     *C 18 对方 TA 代码
     */
     private String  targetRegistrarCode;
    /**
     *C 9 操作（清算）网点编号
     */
     private String  netNo;
    /**
     *C 12 TA 客户编号
     */
     private String  customerNo;
    /**
     *C 1 对方基金份额类别 77
     */
     private String  targetShareType;
    /**
     *C 20 定期定额协议号
     */
     private String  rationProtocolNo;
    /**
     *A 8 定时定额申购起始日期
     */
     private String  beginDateOfPeriodicSubs;
    /**
     *A 8 定时定额申购终止日期
     */
     private String  endDateOfPeriodicSubs;
    /**
     *N 2 定时定额申购每月发送日
     */
    private Integer sendDayOfPeriodicSubs;
    /**
     *C 12 经纪人
     */
     private String  broker;
    /**
     *C 3 促销活动代码
     */
     private String  salesPromotion;
    /**
     *C 1 受理方式
     */
     private String  acceptMethod;
    /**
     *C 1 强制赎回类型
     */
     private String  forceRedemptionType;
    /**
     *A 8 最后更新日
     */
     private String  alternationDate;
    /**
     *C 1 带走收益标志
     */
     private String  takeIncomeFlag;
    /**
     *C 40 定投目的
     */
     private String  purposeOfPeSubs;
    /**
     *N 5 定投频率
     */
    private Integer frequencyOfPeSubs;
    /**
     *C 1 定投周期单位
     */
     private String  periodSubTimeUnit;
    /**
     *N 16（两位小数）定投期数
     */
     private BigDecimal  batchNumOfPeSubs;
    /**
     *C 2 资金方式
     */
     private String  capitalMode;
    /**
     *C 2 明细资金方式
     */
     private String  detailCapticalMode;
    /**
     *N 5（4 位小数）补差费折扣率
     */
     private BigDecimal  backenloadDiscount;
    /**
     *C 6 组合编号
     */
     private String  combineNum;
    /**
     *N 16（两位小数）退款金额
     */
     private BigDecimal  refundAmount;
    /**
     *N 8(五位小数)配售比例
     */
     private BigDecimal  salePercent;
    /**
     *N 7(四位小数)实际计算折扣
     */
     private BigDecimal  managerRealRatio;
    /**
     *N 16( 两 位小数)转换费
     */
     private BigDecimal  changeFee;
    /**
     *N 16( 两 位小数)补差费
     */
     private BigDecimal  recuperateFee;
    /**
     *N 16( 两 位小数)业绩报酬
     */
     private BigDecimal  achievementPay;
    /**
     *N 16( 两 位小数)业绩补偿
     */
     private BigDecimal  achievementCompen;
    /**
     *C 1 份额强制调整标志
     */
     private String  sharesAdjustmentFlag;
    /**
     *C 20 总 TA 确认流水号
     */
     private String  generalTASerialNO;
    /**
     *N 16( 两 位小数)货币基金未付收益金额
     */
     private BigDecimal  undistributeMonetaryIncome;
    /**
     *C 1 货币基金未付收益金额正负
     */
     private String  undistributeMonetaryIncomeFlag;
    /**
     *N 16( 两 位小数)违约金
     */
     private BigDecimal  breachFee;
    /**
     *N 16( 两 位 违约金归基金资产金额78小数)
     */
     private BigDecimal  breachFeeBackToFund;
    /**
     *N 16( 两 位小数)惩罚性费用
     */
     private BigDecimal  punishFee;
    /**
     *C 8 使用的交易手段
     */
     private String  tradingMethod;
    /**
     *N 16( 两 位小数)转换代理费
     */
     private BigDecimal  changeAgencyFee;
    /**
     *N 16( 两 位小数)补差代理费
     */
     private BigDecimal  recuperateAgencyFee;
    /**
     *C 60 出错详细信息
     */
     private String  errorDetail;
    /**
     *A 1 巨额购买处理标志
     */
     private String  largeBuyFlag;
    /**
     *N 16（两位小数）认购期间利息
     */
     private BigDecimal  raiseInterest;
    /**
     *A 1 计费人
     */
     private String  feeCalculator;
    /**
     *A 8 份额注册日期
     */
     private String  shareRegisterDate;
    /**
     *N 16（两位小数）基金冻结总份数
     */
     private BigDecimal  totalFrozenVol;
    /**
     *N 16（两位小数）基金份数余额
     */
     private BigDecimal  fundVolBalance;
    /**
     *N 16（两位小数）冻结金额
     */
     private BigDecimal  frozenBalance;
    /**
     *A 8 指定认购日期
     */
     private String  futureSubscribeDate;
    /**
     *A 8 清算资金经清算人划出日期
     */
     private String  transferDateThroughClearingAgency;
    /**
     *C 3 过户原因
     */
     private String  transferReason;
    

    @Override
    public FileTypeEnum getFileType() {
        return FileTypeEnum.FILE_TYPE_04;
    }

    @Override
    public   String  getSortValue() {
        return tASerialNO;
    }

}
