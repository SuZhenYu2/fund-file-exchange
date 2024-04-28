package com.github.fund.ta.file.domain.confirm;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 账户类确认 对应02文件
 *
 * @author suzhenyu
 * @since 2021/3/16 9:48 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Ta02FundAccountConfirm extends TaEntity {

  /**
   * C 24 申请单编号
   */
  private String appSheetSerialNo;
  /**
   * A 8 交易确认日期
   */
  private String transactionCfmDate;
  /**
   * A 4 交易处理返回代码
   */
  private String returnCode;
  /**
   * C 17 投资人基金交易帐号
   */
  private String transactionAccountID;
  /**
   * C 9 销售人代码
   */
  private String distributorCode;
  /**
   * C 3 业务代码
   */
  private String businessCode;
  /**
   * A 12 投资人基金帐号
   */
  private String tAAccountID;
  /**
   * A 1 多渠道开户标志
   */
  private String multiAcctFlag;
  /**
   * C 20 TA 确认交易流水号
   */
  private String tASerialNO;
  /**
   * A 8 交易发生日期
   */
  private String transactionDate;
  /**
   * A 6 交易发生时间
   */
  private String transactionTime;
  /**
   * C 9 网点号码
   */
  private String branchCode;
  /**
   * A 1 是否注册登记人发起业务标志
   */
  private String fromTAFlag;
  /**
   * C 3 个人证件类型及机构证件型
   */
  private String certificateType;
  /**
   * C 40 投资人证件号码
   */
  private String certificateNo;
  /**
   * C 300 投资人户名
   */
  private String investorName;
  /**
   * A 1 个人/机构标志
   */
  private String individualOrInstitution;
  /**
   * C 60 投资人户名简称
   */
  private String accountAbbr;
  /**
   * C 8 基金账户卡的凭证号
   */
  private String accountCardID;
  /**
   * A 4 交易所在地区编号 72
   */
  private String regionCode;
  /**
   * C 17 对方销售人处投资人基金交易帐号
   */
  private String targetTransactionAccountID;
  /**
   * C 9 操作（清算）网点编号
   */
  private String netNo;
  /**
   * C 60 摘要/说明
   */
  private String specification;
  /**
   * C 12 TA 客户编号
   */
  private String customerNo;
  /**
   * A 1 冻结原因
   */
  private String frozenCause;
  /**
   * A 8 冻结截止日期
   */
  private String freezingDeadline;
  /**
   * C 60 出错详细信息
   */
  private String errorDetail;

  @Override
  public FileTypeEnum getFileType() {
    return FileTypeEnum.FILE_TYPE_02;
  }

  @Override
  public  String getSortValue() {
    return tASerialNO;
  }


}
