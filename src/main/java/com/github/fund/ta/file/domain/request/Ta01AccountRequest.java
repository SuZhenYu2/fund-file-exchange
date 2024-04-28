package com.github.fund.ta.file.domain.request;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.confirm.TaEntity;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 01 文件需要的数据
 *
 * @author suzhenyu
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Ta01AccountRequest  extends TaEntity {

  /**
   * C 120 通讯地址
   */
  private String address;
  /**
   * C 30 法人代表身份证件代码
   */
  private String instReprIdCode;
  /**
   * C 1 法人代表证件类型 0-身份证
   */
  private String instReprIdType;
  /**
   * C 20 法人代表姓名
   */
  private String instReprName;
  /**
   * A 24 申请单编号 同一销售机构不能重复 Y
   */
  private String appSheetSerialNo;
  /**
   * C 1 个人证件类型及机构证件类型 Y
   */
  private String certificateType;

  /**
   * C 30 投资人证件号码 Y
   */
  private String certificateNo;
  /**
   * C 120 投资人户名 Y
   */
  private String investorName;
  /**
   * A 8 交易发生日期 格式为： YYYYMMDD Y
   */
  private String transactionDate;
  /**
   * A 6 交易发生时间 格式为： HHMMSS Y
   */
  private String transactionTime;
  /**
   * A 1 个人/机构标志 0-机构， 1-个人 Y
   */
  private String individualOrInstitution;
  /**
   * A 6 投资人邮政编码
   */
  private String postCode;

  /**
   * C 30 经办人证件号码 对机构必填
   */
  private String transactorCertNo;
  /**
   * C 1 经办人证件类型 对机构必填
   */
  private String transactorCertType;
  /**
   * C 20 经办人姓名 对机构必填
   */
  private String transactorName;
  /**
   * A 17 投资人基金交易账号 投资人在销售机构内开设的用于交易的账号 Y
   */
  private String transactionAccountId;
  /**
   * C 9 销售人代码 Y
   */
  private String distributorCode;
  /**
   * A 3 业务代码 编码见表 4 Y
   */
  private String businessCode;
  /**
   * C 28 基金管理人在资金清算机构的交收账号
   */
  private String acctNoOfFmInClearingAgency;
  /**
   * C 60 基金管理人在资金清算机构的交收账户名
   */
  private String acctNameOfFmInClearingAgency;
  /**
   * A 9 基金资金清算机构代码
   */
  private String clearingAgencyCode;
  /**
   * A 8 投资人出生日期 格式为： YYYYMMDD
   */
  private String investorsBirthday;
  /**
   * C 19 投资人在销售人处用于交易的资金账号
   */
  private String depositAcct;
  /**
   * A 4 交易所在地区编号
   */
  private String regionCode;
  /**
   * C 3 投资人学历
   */
  private String educationLevel;
  /**
   * C 40 投资人 E-MAIL 地址
   */
  private String emailAddress;
  /**
   * C 24 投资人传真号码
   */
  private String faxNo;
  /**
   * C 3 投资人职业代码
   */
  private String vocationCode;
  /**
   * C 22 投资人住址电话
   */
  private String homeTelNo;
  /**
   * N 8 投资人年收入
   */
  private BigDecimal annualIncome;

  /**
   * C 24 投资人手机号码
   */
  private String mobileTelNo;
  /**
   * C 9 网点号码 托管网点号码。对大集中方式的销售人，此字段与销售人代码相同。 Y
   */
  private String branchCode;
  /**
   * C 22 投资人单位电话号码
   */
  private String officeTelNo;
  /**
   * C 12 投资人户名简称
   */
  private String accountAbbr;
  /**
   * C 8 密函编号
   */
  private String confidentialDocumentCode;
  /**
   * A 1 投资人性别 1-男， 2-女
   */
  private String sex;
  /**
   * C 10 上交所证券账号
   */
  private String shSecuritiesAccountId;
  /**
   * C 10 深交所证券账号
   */
  private String szSecuritiesAccountId;
  /**
   * C 12 投资人基金账号 账户信息修改申请时为必选项。
   */
  private String taAccountId;
  /**
   * C 22 投资人电话号码
   */
  private String telNo;
  /**
   * C 8 使用的交易手段 共 8 个字符，每个字符代表
   */
  private String tradingMethod;
  /**
   * C 1 未成年人标志 0-否， 1-是 N
   */
  private String minorFlag;
  /**
   * C 1 对账单寄送选择 1-不寄送， 2-按月 3-按季， 4-半年 5-一年
   */
  private String deliverType;
  /**
   * C 1 经办人识别方式 1-书面委托， 2-印鉴 3-密码， 4-证件
   */
  private String transactorIdType;
  /**
   * C 8 基金账户卡的凭证号
   */
  private String accountCardId;
  /**
   * A 1 多渠道开户标志 0-首次开设基金账户 1-已经其它渠道开户
   */
  private String multiAcctFlag;
  /**
   * A 17 对方销售人处投资人基金交易帐号
   */
  private String targetTransactionAccountId;
  /**
   * C 60 投资人收款银行账户户名
   */
  private String acctNameOfInvestorInClearingAgency;
  /**
   * C 28 投资人收款银行账户账号
   */
  private String acctNoOfInvestorInClearingAgency;
  /**
   * A 9 投资人收款银行账户开户行
   */
  private String clearingAgency;
  /**
   * C 8 对账单寄送方式 共 8 个字符，每个字符代表
   */
  private String deliverWay;
  /**
   * C 3 投资者国籍 采用 GB/T 2659-2000
   */
  private String nationality;
  /**
   * C 9 操作（清算）网点编号
   */
  private String netNo;
  /**
   * C 12 经纪人 客户所属的经纪人
   */
  private String broker;
  /**
   * C 40 工作单位名称
   */
  private String corpName;
  /**
   * A 8 证件有效日期
   */
  private String certValidDate;
  /**
   * A 8 机构经办人身份证件有效日期
   */
  private String instTranCertValidDate;
  /**
   * A 8 机构法人身份证件有效日期
   */
  private String instReprCertValidDate;
  /**
   * C 1 客户风险等级
   */
  private String clientRiskRate;
  /**
   * C 2 机构法人经营范围
   */
  private String instReprManageRange;
  /**
   * C 80 控股股东
   */
  private String controlHolder;
  /**
   * C 80 实际控制人
   */
  private String actualController;
  /**
   * C 1 婚姻状况
   */
  private String marriageStatus;
  /**
   * N 2 家庭人口数
   */
  private Integer familyNum;
  /**
   * N 16（两位小数）家庭资产
   */
  private BigDecimal penates;
  /**
   * C 1 媒体偏好
   */
  private String mediaHobby;
  /**
   * C 1 机构类型
   */
  private String institutionType;
  /**
   * C 20 投资人英文名
   */
  private String englishFirstName;
  /**
   * C 20 投资人英文姓
   */
  private String EnglishFamliyName;
  /**
   * C 4 行业 采用国标 GB/T 4754-2011
   */
  private String vocation;
  /**
   * C 2 企业性质
   */
  private String corpoProperty;
  /**
   * N 16（两位小数）员工人数
   */
  private BigDecimal staffNum;
  /**
   * C 2 兴趣爱好类型
   */
  private String hobbyType;
  /**
   * C 6 省/直辖市 采用国标 GB/T 2260-2007
   */
  private String province;
  /**
   * C 6 市 采用国标 GB/T 2260-2007
   */
  private String city;
  /**
   * C 6 县/区 采用国标 GB/T 2260-2007
   */
  private String county;
  /**
   * C 40 推荐人 N
   */
  private String commendPerson;
  /**
   * C 1 推荐人类型 1:内部员工
   */
  private String commendPersonType;
  /**
   * C 1 受理方式
   */
  private String acceptMethod;
  /**
   * A 1 冻结原因
   */
  private String frozenCause;
  /**
   * A 8 冻结截止日期
   */
  private String freezingDeadline;
  /**
   * A 20 TA 的原确认流水号
   */
  private String originalSerialNo;
  /**
   * A 24 原申请单编号
   */
  private String originalAppSheetNo;
  /**
   * C 60 摘要/说明
   */
  private String specification;
  //======== protocol version 22 ===========
  /**
   * 投资者产品代码
   */
  private String investorProCode;
  /**
   * 辅助身份证明文件类型
   */
  private String auxCertType;
  /**
   * 辅助身份证明文件号码
   */
  private String auxCertCode;
  /**
   * 辅助身份证明文件有效期
   */
  private String AuxCertValidDate;
  /**
   * IP地址
   */
  private String ipAddress;
  /**
   * MAC地址
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

  @Override
  public FileTypeEnum getFileType() {
    return FileTypeEnum.FILE_TYPE_01;
  }

  @Override
  public String getSortValue() {
    return accountCardId;
  }
}
