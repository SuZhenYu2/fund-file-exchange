package com.github.fund.ta.file.domain.request;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.confirm.TaEntity;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * X3，机构反洗钱申请
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TX3Request extends TaEntity {

  /**
   * 法人信息
   * 格式：名称|个人/机构标志|证件类型|证件号码|证件有效期|电话号码|电子邮箱。
   */

  private String instRepr;

  /**
   * 控制人
   * 名称|个人/机构标志|证件类型| 证件号码|证件有效期|电话号码|电子 邮箱|#END#
   * 可以有多个
   */
  private String controlHolder;

  /**
   * 实际控制人
   * 名称|个人/机构标志|证件类型| 证件号码|证件有效期|电话号码|电子 邮箱|#END#
   * 可以有多个
   */
  private String actualController;

  /**
   * 经办人
   * 名称|个人/机构标志|证件类型| 证件号码|证件有效期|电话号码|电子 邮箱|#END#|
   * 可以有多个
   */
  private String transactor;

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
   * c 9 销售人代码 y
   */
  private String distributorCode;

  /**
   * a 8 投资人出生日期 格式为： yyyymmdd
   */
  private String investorsBirthday;

  /**
   * c 9 网点号码 托管网点号码。对大集中方式的销售人，此字段与销售人代码相同。 y
   */
  private String branchCode;

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
   * c 4 行业 采用国标 g_b/_t 4754-2011
   */
  private String vocation;

  /**
   * a 24 原申请单编号
   */
  private String originalAppSheetNo;

  /**
   * c 60 摘要/说明
   */
  private String specification;

  /**
   * 投资者产品代码
   */
  private String investorProCode;

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
   * 增删标志 0-作废，1-新增
   */
  private String addFlag;

  /**
   * 注册资本 对产品投资者，指资产管理人注册资本。单位:元
   */
  private BigDecimal regCapital;

  /**
   * 对机构投资者，指营业执照载明的经营 范围。对产品投资者，填写资产管理人 经营范围
   */
  private String manageRange;

  /**
   * 对机构投资者，指注册资本币种;对产品投资者，指资产管理人注册资本币种。具体编码采用 gb/t 12406-2008中3位数字
   */
  private String currencyType;

  /**
   * 组织机构代码
   */
  private String orgNo;

  /**
   * 税务登记证号码
   */
  private String taxNo;

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
   * 洗钱风险等级
   */
  private String launMoneyRiskRate;

  /**
   * 受益所有人
   */
  private String beneOwner;

  /**
   * 基金简称，产品投资者必填 指产品简称
   */
  private String fundNameAbbr;

  /**
   * 到期日
   */
  private String fundEndDate;

  /**
   * 资产管理人
   */
  private String assetManager;

  /**
   * 托管人名称
   */
  private String custodianName;

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

  /**
   * 托管人代码 产品投资者若有托管人则必填 填写托管人的三位销售代码。若无销售代码则填写组织机构代码或社会信用代码
   */
  private String custodianCode;

  public TX3Request() {
  }

  @Override
  public FileTypeEnum getFileType() {
    return FileTypeEnum.FILE_TYPE_X3;
  }

  @Override
  public String getSortValue() {
    return appSheetSerialNo;
  }
}
