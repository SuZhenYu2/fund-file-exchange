package com.github.fund.ta.file.domain.confirm;


import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 基金基础参数（C1 文件）
 *
 * @author suzhenyu
 * @since 2021/7/14 10:21 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaC1FundBasicInfo extends TaEntity {


    String  sequenceNO;// A 20 序号 唯一确定一条记录，不能重复 Y
    String  fundCode;// C 6 基金代码 Y
    String  shareClass;// A 1 收费方式 0-前收费，1-后收费-前后收费共用（基金代码）Y;//
    String  fundName;// C 40 基金名称 YJR/T 0017—2011 93
    String  fundNameAbbr;// C 20 基金简称 Y
    Double  totalFundVol;// N 16（两位小数）基金总份数 N
    String  fundType;// C 2 基金类型 01-股票型 02-债券型 03-混合型 04-货币型 Y
    String  fundTypeName;// C 30 基金类型名称 N
    String  isGuaranteedFund;// C 1 是否保本基金 Y
    String  isLOFFund;// C 1 是否 LOF 基金 Y
    String  isQDIIFund;// C 1 是否 QDII 基金 Y
    String  isETFFund;// C 1 是否 ETF 基金 Y
    Double  redeemFeeBackRatio;// N 16（两位小数）赎回费归基金资产比例 Y
    String  defDividendMethod;// A 1 默认分红方式 Y
    String  redemptionSequence;// C 1 指定赎回方式 0-先进先出 1-后进先出 Y
    Double  buyUpperAmount;// N16( 两 位小数)申购金额上限 Y
    Double  covertInUpperAmount;// N 16( 两 位小数)基金转换转入金额上限Y
    Double  periodSubUpperAmount;// N16( 两 位小数)定时定额申购金额上限Y
    Double  instAppSubsAmnt;// N 16（两位小数）法人追加认购金额 Y
    Double  instAppSubsVol;// N 16（两位小数）法人追加认购份数 Y
    Double  minAmountByInst;// N 16（两位小数）法人首次认购最低金额 Y
    Double  minVolByInst;// N 16（两位小数）法人首次认购最低份数 Y
    String  currencyType;// A 3 结算币种 具体编码依 GB/T 12406-2008N
    String  custodianCode;// C 3 托管人代码 Y
    Double  amountOfPeriodicSubs;// N 16（两位小数）定时定额申购的金额 Y
    String  dateOfPeriodicSubs;// A 8 定时定额申购日期 格式为：YYYYMMDD Y
    Double  maxRedemptionVol;// N 16（两位小数）基金最高赎回份数 Y
    Double  minAccountBalance;// N 16（两位小数）基金最低持有份数 Y
    String  iPOStartDate;// A 8 基金募集开始日期 格式为：YYYYMMDD Y
    String  iPOEndDate;// A 8 基金募集结束日期 格式为：YYYYMMDD Y
    String  fundEstablishDate;// A 8 基金成立日期 YYYYMMDD Y
    String  fundManagerCode;// C 3 基金管理人 Y
    Double  indiAppSubsVol;// N 16（两位小数）个人追加认购份数 Y
    Double  indiAppSubsAmount;// N 16（两位小数）个人追加认购金额 Y
    Double  minSubsVolByIndi;// N 16（两位小数）个人首次认购最低份数 Y
    Double  minSubsAmountByIndi;// N 16（两位小数）个人首次认购最低金额 Y
    String  registrarCode;// C 2 注册登记人代码 Y
    Double  fundSize;// N 16（两位小数）基金规模 基金的金额规模 NJR/T XX—XXXX94
    String  exchangeFlag;// C 1 交易所标志 指基金发行渠道0-深圳场内（含场外）1-上海场内（含场外）2-场外Y
    String  fundSponsor;// A 3 基金发起人 N
    Double  faceValue;// N 7（四位小数）基金面值 Y
    Double  maxSubsVolByIndi;// N 16（两位小数）个人最高认购份数 Y
    Double  maxSubsAmountByIndi;// N 16（两位小数）个人最高认购金额 Y
    Double  maxSubsVolByInst;// N 16（两位小数）法人最高认购份数 Y
    Double  maxSubsAmountByInst;// N 16（两位小数）法人最高认购金额 Y
    Double  unitSubsVolByIndi;// N 16（两位小数）个人认购份数单位 Y
    Double  unitSubsAmountByIndi;// N 16（两位小数）个人认购金额单位 Y
    Double  unitSubsVolByInst;// N 16（两位小数）法人认购份数单位 Y
    Double  unitSubsAmountByInst;// N 16（两位小数）法人认购金额单位 Y
    Double  minBidsAmountByIndi;// N 16（两位小数）个人首次申购最低金额 Y
    Double  minBidsAmountByInst;// N 16（两位小数）法人首次申购最低金额 Y
    Double  minAppBidsAmountByIndi;// N 16（两位小数）个人追加申购最低金额 Y
    Double  minAppBidsAmountByInst;// N 16（两位小数）法人追加申购最低金额 Y
    Double  minRedemptionVol;// N 16（两位小数）基金最少赎回份数 Y 211 MinInterconvertVol N 16（两位小数）最低基金转换份数 Y
    String  issueTypeByIndi;// C 1 个人发行方式 1-比例发行2-摇号3-先来先买Y
    String  issueTypeByInst;// C 1 机构发行方式 1-比例发行2-摇号3-先来先买Y
    String  subsType;// C 1 认购方式 0-金额认购1-份数认购Y
    String  collectFeeType;// C 1 交易费收取方式 0-价内费1-价外费Y
    Double  indiMaxPurchase;// N 16( 两 位小数)个人最大申购金额Y
    Double  instMaxPurchase;// N 16( 两 位小数)法人最大申购金额Y
    Double  indiDayMaxSumBuy;// N 16( 两 位小数)个人当日累计购买最大金额 Y
    Double  instDayMaxSumBuy;// N 16( 两 位小数)法人当日累计购买最大金额 YJR/T 0017—2011 95
    Double  indiDayMaxSumRedeem;// N 16( 两 位小数)个人当日累计赎回最大份额 Y
    Double  instDayMaxSumRedeem;// N 16( 两 位小数)法人当日累计赎回最大份额 Y
    Double  indiMaxRedeem;// N 16( 两 位小数)个人最大赎回份额Y
    Double  instMaxRedeem;// N 16( 两 位小数)法人最大赎回份额Y
    String  registrarName;// C 40 注册登记人名称 Y
    String  fundManagerName;// C 40 基金管理人名称 Y
    String  fundServerTel;// C 30 基金公司客服电话 Y
    String  fundInternetAddress;// C 40 基金公司网站网址 Y
    String  specification;// C 60 摘要/说明 N
    String  wholeFlag;// C 1 全量标志 0-增量 1-全量 Y
    String  modifyWay;// C 1 修改方式 增量方式传递参数必填0-新增 1-修改 2-删除 N356
    String OperateDate;// A 8 生效日期 YYYYMMDD Y
    String  downLoaddate;// A 8 交易数据下传日期 格式为：YYYYMMDD指文件发送日期Y
    String mainFundCode;//主基金代码      N
    String sideBagFlag;//侧袋标志        N
    String redeemCloseMode;//赎回封闭方式0 不封闭；1 周期封闭；2 封闭固定期限        N
    Integer closeLength;//封闭期长度        N
    String closeUnit;//封闭期单位        N

    @Override
    public FileTypeEnum getFileType() {
        return FileTypeEnum.FILE_TYPE_C1;
    }

    @Override
    public String getSortValue() {
        return sequenceNO;
    }


}
