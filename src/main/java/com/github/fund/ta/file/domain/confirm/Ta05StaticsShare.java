package com.github.fund.ta.file.domain.confirm;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 份额信息
 *
 * @author suzhenyu
 * @since 2021/3/16 10:08 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class Ta05StaticsShare extends TaEntity {

  //以下05标准文件的参数
    /**
   * N 16（两位小数）持有人可用基金份数 Y
   */
  private BigDecimal availableVol;
  /**
   * N 16（两位小数）基金总份数（含冻结） Y
   */
  private BigDecimal totalVolOfDistributorInTA;
  /**
   * A 8 交易确认日期 格式为：YYYYMMDD Y
   */
  private String transactionCfmDate;
  /**
   * C 6 基金代码 Y
   */
  private String fundCode;
  /**
   * C 17 投资人基金交易账号 投资人在销售机构内开设的用于交易的账号 Y
   */
  private String transactionAccountID;
  /**
   * C 9 销售人代码 Y
   */
  private String distributorCode;
  /**
   * C 12 投资人基金账号 Y
   */
  private String tAAccountID;
  /**
   * N 16（两位小数）基金冻结总份数 仅包括账户类和交易类冻结业务及派生继续冻结的份额 N
   */
  private BigDecimal totalFrozenVol;
  /**
   * C 9 网点号码 Y
   */
  private String branchCode;
  /**
   * C 20 TA 确认交易流水号 N
   */
  private String tASerialNO;
  /**
   * N 16（两位小数）交易后端收费总额 N
   */
  private BigDecimal totalBackendLoad;
  /**
   * N#16.2#交易后端收费总份数
   */
  private BigDecimal totalBackendLoadVol;
  /**
   * A 1 收费方式 0-前收费，1-后收费 Y
   */
  private String shareClass;
  /**
   * A 1 明细标志 0-非明细，1-明细非明细指针对基金账户的对账，明细指针对基金账户具体过户日或 TA 确认流水号的对账 Y
   */
  private String detailFlag;
  /**
   * A 1 账户状态 0-正常，1-冻结，2-挂失 N
   */
  private String accountStatus;
  /**
   * A 8 份额注册日期 明细标志为 1 时必填 N
   */
  private String shareRegisterDate;
  /**
   * 16( 两 位小数)货币基金未付收益金额 对货币基金，明细标志为 0 时必填 N
   */
  private BigDecimal undistributeMonetaryIncome;
  /**
   * C 1 货币基金未付收益金额正负0-正 1-负 对货币基金，明细标志为 0 时必填 N
   */
  private String undistributeMonetaryIncomeFlag;
  /**
   * N 16( 两 位小数)剩余保本金额 N
   */
  private BigDecimal guaranteedAmount;
  /**
   * C 1 份额原始来源 0-认购 1-申购 2-定期定额申购 3-分红明细标志为 1 时必填 N
   */
  private String sourceType;
  /**
   * A 1 默认分红方式 0-红利转投，1-现金分红 N
   */
  private String defDividendMethod;
  /**
   * N#16.2#新增收益
   */
  private String newIncome;
  /**
   * C#1#新增收益正负
   */
  private String newIncomeFlag;
  /**
   * C 1 全量标志 0-增量 1-全量 Y
   */
  private String wholeFlag;


  @Override
  public FileTypeEnum getFileType() {
    return FileTypeEnum.FILE_TYPE_05;
  }

  @Override
  public String getSortValue() {
    return tASerialNO;
  }

  public boolean isDetail() {
    return getDetailFlag().equals(Detail_Flag_DETAIL);
  }


}
