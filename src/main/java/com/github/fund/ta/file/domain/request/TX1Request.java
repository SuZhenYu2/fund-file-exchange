package com.github.fund.ta.file.domain.request;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.confirm.TaEntity;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * X1，个人反洗钱申请
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TX1Request extends TaEntity {

  /**
   * a 24 申请单编号 同一销售机构不能重复 y
   */
  private String appSheetSerialNo;

  /**
   * c 1 个人证件类型及机构证件类型 y
   */
  private String certificateType;

  /**
   * c 30 投资人证件号码 y
   */
  private String certificateNo;

  /**
   * c 120 投资人户名 y
   */
  private String investorName;

  /**
   * a 8 交易发生日期 格式为： yyyymmdd y
   */
  private String transactionDate;

  /**
   * a 6 交易发生时间 格式为： hhmmss y
   */
  private String transactionTime;

  /**
   * a 1 个人/机构标志 0-机构， 1-个人 y
   */
  private String individualOrInstitution;

  /**
   * a 6 投资人邮政编码
   */
  private String postCode;

  /**
   * c 9 销售人代码 y
   */
  private String distributorCode;

  /**
   * a 8 投资人出生日期 格式为： yyyymmdd
   */
  private String investorsBirthday;

  /**
   * c 40 投资人 e-mail 地址
   */
  private String emailAddress;

  /**
   * c 24 投资人传真号码
   */
  private String faxNo;

  /**
   * c 3 投资人职业代码
   */
  private String vocationCode;

  /**
   * c 22 投资人住址电话
   */
  private String homeTelNo;

  /**
   * n 8 投资人年收入
   */
  private BigDecimal annualIncome;

  /**
   * c 24 投资人手机号码
   */
  private String mobileTelNo;

  /**
   * c 9 网点号码 托管网点号码。对大集中方式的销售人，此字段与销售人代码相同。 y
   */
  private String branchCode;

  /**
   * c 22 投资人单位电话号码
   */
  private String officeTelNo;

  /**
   * c 12 投资人户名简称
   */
  private String accountAbbr;

  /**
   * a 1 投资人性别 1-男， 2-女
   */
  private String sex;

  /**
   * c 12 投资人基金账号 账户信息修改申请时为必选项。
   */
  private String taAccountId;

  /**
   * c 60 投资人收款银行账户户名
   */
  private String acctNameOfInvestorInClearingAgency;

  /**
   * c 28 投资人收款银行账户账号
   */
  private String acctNoOfInvestorInClearingAgency;

  /**
   * a 9 投资人收款银行账户开户行
   */
  private String clearingAgency;

  /**
   * c 3 投资者国籍 采用 gb/t 2659-2000
   */
  private String nationality;

  /**
   * c 40 工作单位名称
   */
  private String corpName;

  /**
   * a 24 原申请单编号
   */
  private String originalAppSheetNo;

  /**
   * c 60 摘要/说明
   */
  private String specification;

  /**
   * ip地址
   */
  private String ipAddress;

  /**
   * mac地址
   */
  private String macAddress;

  /**
   * 国际移动设备识别码
   */
  private String imei;

  /**
   * 通用唯一识别码
   */
  private String uuid;

  /**
   * 特定自然人标识 0-否 1-外国政要 2-外国政要的特定关系人 3-国际组织高管 4-国际组织高管的 特定关系人 a-其他 默认0
   */
  private String specialPersonFlag;

  /**
   * 增删标志 0-作废，1-新增
   */
  private String addFlag;

  /**
   * 原申请日期，新开基金账户的申请日期（确认失败重发）
   */
  private String originalAppDate;

  /**
   * 现居国家或地区和现居地址和注册地国家代码和现居地址2至少必填 其中一套。采用iso 3166两位字母。填写住所地国家或地区
   */
  private String livingCountry;

  /**
   * 填写住所地
   */
  private String livingAddress;

  /**
   * 现居地址2
   */
  private String livingAddress2;

  /**
   * 关联人
   */
  private String relatedPerson;

  /**
   * 洗钱风险等级
   */
  private String launMoneyRiskRate;

  /**
   * 预留字段1
   */
  private String reservedField1;

  /**
   * 预留字段2
   */
  private String reservedField2;

  /**
   * 预留字段3
   */
  private String reservedField3;

  /**
   * 预留字段4
   */
  private BigDecimal reservedField4;

  /**
   * 预留字段5
   */
  private BigDecimal reservedField5;

  /**
   * 预留字段1
   */
  private String reservedField6;

  /**
   * 注册地国家或地区 代码
   */
  private String regRegionCode;

  /**
   * 证件有效日期 证件到期日。长期有效填写 99991231。
   */
  private String certValidDate;

  public TX1Request() {
  }

  @Override
  public FileTypeEnum getFileType() {
    return FileTypeEnum.FILE_TYPE_X1;
  }

  @Override
  public String getSortValue() {
    return appSheetSerialNo;
  }
}
