package com.github.fund.ta.file.domain.confirm;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 反洗钱确认表
 *
 * @author suzhenyu
 * @since 2021/3/16 10:07 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaX2Confirm extends TaEntity {

  /**
   * C 24 申请单编号 Y
   */
  private String appSheetSerialNo;
  /**
   * A 8 交易发生日期 Y
   */
  private String transactionDate;
  /**
   * A 8 交易确认日期 Y
   */
  private String transactionCfmDate;
  /**
   * C 20 TA 确认交易流水号 Y
   */
  private String tASerialNO;
  /**
   * A 4 交易处理返回代码 需补充数据字典 Y
   */
  private String returnCode;
  /**
   * C 60 出错详细信息 N
   */
  private String errorDetail;
  /**
   * C 20 预留字段 1 N
   */
  private String reservedField1;
  /**
   * C 20 预留字段 2 N
   */
  private String reservedField2;
  /**
   * C 30 预留字段 3 N
   */
  private String reservedField3;

  @Override
  public FileTypeEnum getFileType() {
    return FileTypeEnum.FILE_TYPE_X2;
  }

  @Override
  public String getSortValue() {
    return tASerialNO;
  }
}
