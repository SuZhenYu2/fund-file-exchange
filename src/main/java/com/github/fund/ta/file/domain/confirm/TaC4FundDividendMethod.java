package com.github.fund.ta.file.domain.confirm;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;

import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基金分红方案（C4 文件）
 *
 * @author suzhenyu
 * @since 2021/7/14 10:59 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaC4FundDividendMethod extends TaEntity{

    /**
     * A 20 序号 唯一确定一条记录，不能重复 Y
     */
    private String sequenceNO;
    /**
     *  C 6 基金代码 Y
     */
    private String fundCode;
    /**
     *  A 1 收费方式 0-前收费，1-后收费2-前后收费共用（基金代码）Y
     */
    private String shareClass;
    /**
     * A 8 权益登记日期 对分红必填 N
     */
    private String registrationDate;
    /**
     * A 8 分红日/发放日 对分红必填 N
     */
    private String dividentDate;
    /**
     *  A 8 除权日 Y
     */
    private String xRDate;
    /**
     * N 16( 两 位小数)单位基金分红金额（含税）对分红必填。举例：每千份分两元，则此处填 2。 N
     */
    private BigDecimal dividendPerUnit;
    /**
     * N 10 分红单位对分红而言，表示分红的基数。举例：每千份分多少，则分红单位就为一千。对净YJR/T 0017—201197值调整而言，表示净值归一所调整份额的基数。举例：每万份调减500份后净值归一，则分红单位为一万，除权值为500，除权值正负为‘1’。
     */
    private Integer drawBonusUnit;
    /**
     *  N 16（两位小数）除权值 表示基金净值归一所调整的份额（正负值通过“除权值正负”字段表示）N
     */
    private BigDecimal xRValue;
    /**
     *  C 1 除权值正负 0-正 1-负 N
     */
    private String xRValueFlag;
    /**
     *  C 1 除权类型 0-分红 1-净值调整 Y
     */
    private String xRType;
    /**
     *  C 60 摘要/说明 N
     */
    private String specification;
    /**
     *  C 1 全量标志 0-增量 1-全量 Y
     */
    private String wholeFlag;
    /**
     * C 1 修改方式 增量方式传递参数必填0-新增 1-修改 2-删除 N
     */
    private String modifyWay;
    /**
     * A 8 交易数据下传日期 格式为：YYYYMMDD指文件发送日期 Y
     */
    private String downLoaddate;

    @Override
    public FileTypeEnum getFileType() {
        return FileTypeEnum.FILE_TYPE_C4;
    }

    @Override
    public String getSortValue() {
        return sequenceNO;
    }
}
