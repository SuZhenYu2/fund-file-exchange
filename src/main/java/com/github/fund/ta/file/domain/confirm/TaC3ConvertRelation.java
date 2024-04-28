package com.github.fund.ta.file.domain.confirm;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基金转换关系（C3文件）
 *
 * @author suzhenyu
 * @since 2021/7/14 10:13 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaC3ConvertRelation extends TaEntity {

  /**
   * A 20 序号 唯一确定一条记录，不能重复 Y
   */
  private String sequenceNO;
  /**
   * C 6 基金代码 转出基金代码 Y
   */
  private String fundCode;
  /**
   * A 1 收费方式 0-前收费，1-后收费2-前后收费共用（基金代码）Y
   */
  private String shareClass;
  /**
   * N 16（两位小数）份额下限 基金转出最低份额 Y
   */
  private BigDecimal volLowerLimit;
  /**
   * N 16（两位小数）份额上限 基金转出最高份额 Y
   */
  private BigDecimal volUpperLimit;
  /**
   * N 5 天数下限 转出基金最小持有天数 Y
   */
  private Integer daysLowerLimit;
  /**
   * A 6 转换时的目标基金代码 Y
   */
  private String codeOfTargetFund;
  /**
   * C 1 对方基金份额类别 0-前收费 1-后收费 Y
   */
  private String targetShareType;
  /**
   * A 1 个人/机构标志 0-机构，1-个人，2-产品 Y
   */
  private String individualOrInstitution;
  /**
   * C 2 注册登记人代码 跨 TA 基金转换时必填 N
   */
  private String registrarCode;
  /**
   * C 2 对方 TA 代码 跨TA基金转换时必填 N
   */
  private String targetRegistrarCode;
  /**
   * C 1 全量标志 0-增量 1-全量 Y
   */
  private String wholeFlag;
  /**
   * C 1 修改方式 增量方式传递参数必填 0-新增 1-修改 2-删除 N
   */
  private String modifyWay;
  /**
   * A 8 生效日期 YYYYMMDD Y
   */
  private String operateDate;
  /**
   * A 8 交易数据下传日期 格式为：YYYYMMDD指文件发送日期Y
   */
  private String downLoaddate;

  @Override
  public FileTypeEnum getFileType() {
    return FileTypeEnum.FILE_TYPE_C3;
  }

  @Override
  public String getSortValue() {
    return sequenceNO;
  }
}
