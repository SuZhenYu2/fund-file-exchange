package com.github.fund.ta.file.domain.confirm;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基金费率（C5 文件）
 *
 * @author suzhenyu
 * @since 2021/7/14 11:17 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaC5FundFeeRate extends TaEntity {

    String sequenceNO;// A 20 序号 唯一确定一条记录，不能重复 Y
    String fundCode;// C 6 基金代码 Y
    String shareClass;// A 1 收费方式 0-前收费，1-后收费表明基金是前收费或后收费基金Y
    String codeOfTargetFund;// A 6 转换时的目标基金代码 基金转换业务必填 N
    String targetShareType;// C 1 对方基金份额类别 基金转换业务必填 NJR/T XX—XXXX980-前收费 1-后收费
    String distributorCode;// C 9 销售人代码 Y
    String branchCode;// C 9 网点号码 托管网点号码。对大集中方式的销售人，此字段与销售人代码相同。此字段为 101 表示上海场内，为 102 表示深圳场内。 N
    String businessCode;// A 3 业务代码 120 为认购，122 为申购，124为赎回，163 为定额赎回，142 为强制赎回，126 为转托管，136 为基金转换，139为定时定额申购，143 为分红，130 为认购结果，191为 ETF 基金申购，194 为 ETF基金赎回，172为月费，173为销售服务费，174 为尾随佣金。Y
    String capitalType;// C 3 资金类型 表示费用的类型002- 手续费 003- 代理费004-印花税 005-认购成功利息 006-利息税 007-过户费 008-其他费用 009-现金红利 010-红利所得税 011-认购退款金额 012-认购退款利息 013-现金分红手续费 015-后收手续费 016-补差 费 017- 销 售 服 务 费018-尾随佣金 020-转换代理费 021-补差代理费 022-惩罚性费用Y
    String individualOrInstitution;// A 1 个人/机构标志 0-机构，1-个人，2-全部 Y
    String getFeeRateMethod;// C 1 取费率方式 1-按金额 2-按天数 3-按份额 4-不分段 Y
    Double volLowerLimit;// N 16（两位小数）份额下限 按份额分段计费时必填 N
    Double volUpperLimit;// N 16（两位小数）份额上限 按份额分段计费时必填 N
    Double amountLowerLimit;// N 16（两位小数）金额下限 按金额分段计费时必填 N
    Double amountUpperLimit;// N 16（两位小数）金额上限 按金额分段计费时必填 N
    Integer daysLowerLimit;// N 5 天数下限 按持有天数分段计费时必填 N
    Integer daysUpperLimit;// N 5 天数上限 按持有天数分段计费时必填 N
    Double maxFee;// N 16（两位小数）最高费用 有最高费用限制时必填，否则填全 9 NJR/T 0017—2011 99
    Double minFee;// N 10（两位小数）最少收费 有最低费用限制时必填，否则填 0 N
    Double rateFee;// N 9（八位小数）费率 如果是相对费率，此处填 0。 Y
    String feeRateFlag;// C 1 费率标志 0-绝对费率 1-相对费率 Y
    Double compareProportion;// N 16（八位小数）相对比例 相对费率必填。费率针对指定费率的比例，即费率/指定费率 N
    String compareCapitalType;// C 3 相对资金类型 相对费率必填。值域参考 CapitalType。 N
    String wholeFlag;// C 1 全量标志 0-增量 1-全量 Y
    String modifyWay;// C 1 修改方式 增量方式传递参数必填0-新增 1-修改 2-删除 N
    String operateDate;// A 8 生效日期 YYYYMMDD Y
    String downLoaddate;// A 8 交易数据下传日期 格式为：YYYYMMDD指文件发送日期Y

    @Override
    public FileTypeEnum getFileType() {
        return FileTypeEnum.FILE_TYPE_C5;
    }

    @Override
    public String getSortValue() {
        return sequenceNO;
    }
}
