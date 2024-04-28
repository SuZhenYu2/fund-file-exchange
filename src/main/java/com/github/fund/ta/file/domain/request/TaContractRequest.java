package com.github.fund.ta.file.domain.request;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.confirm.TaEntity;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 43，私募电子合同签约请求
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaContractRequest extends TaEntity {

  /**
   * C 6 基金代码 Y
   */
  private String fundCode;
  /**
   * C 12 投资人基金账号 N
   */
  private String taAccountId;
  /**
   * A 17 投资人基金交易账号 Y
   */
  private String transactionAccountId;
  /**
   * A 3 业务代码 401:合同签订 402:合同补 正 403:合同撤销 Y
   */
  private String businessCode;
  /**
   * C 1 合同类型 1-电子签名合同 2-纸质合同 Y
   */
  private String contractType;
  /**
   * C 26 流水号 产品代码(6 位)+合同类型 (1 位)+销售机构代码(3 位)+日期(8 位)+顺序号 (8 位) Y
   */
  private String serialNo;
  /**
   * C 3 合同版本号，从 001 开始增 长 Y
   */
  private String version;
  /**
   * C 1 签署类型 1-新签合同，2-补签合同 Y
   */
  private String signType;
  /**
   * C 9 销售人代码 Y
   */
  private String distributorCode;
  /**
   * C 120 投资人户名 Y
   */
  private String investorName;
  /**
   * A 1 个人/机构标志 机构0 个人1 Y
   */
  private String individualOrInstitution;
  /**
   * C 1 个人证件类型及机构证件类型 Y
   */
  private String certificateType;
  /**
   * C 30 投资人证件号码 Y
   */
  private String certificateNo;
  /**
   * A 8 交易发生日期 Y
   */
  private String transactionDate;
  /**
   * A 6 交易发生时间 Y
   */
  private String transactionTime;
  /**
   * C 1 受理方式 Y
   */
  private String acceptMethod;
  /**
   * C 40 受理地点 受理方式为柜台，填写柜 台号;受理方式为网上，填 客户端 IP 地址 Y
   */
  private String acceptPlace;
  /**
   * C 9 投资人实际申报交易的操作 网点编号，柜台受理时必填 N
   */
  private String netNo;
  /**
   * C 64 附加信息 N
   */
  private String notes;
  /**
   * C 1 客户:0-未签署风险揭示书; 1-已签署电子风险揭示书; 2-已签署纸质风险揭示书 N
   */
  private String signRiskNotice;
  /**
   * C 1 1-客户风险匹配; 2-客户风险不匹配且已签署 风险责任承诺 N
   */
  private String riskMatching;
  /**
   * C 1 客户风险等级 N
   */
  private String clientRiskRate;
  /**
   * A 8 最后更新日 Y
   */
  private String alternationDate;
  /**
   * C 32 客户银行卡号或券商端资金账号 N
   */
  private String cardNo;
  /**
   * C 22 投资人电话号码 N
   */
  private String telNo;
  /**
   * C 24 投资人手机号码 N
   */
  private String mobileTelNo;
  /**
   * C 40 投资人 E-MAIL 地址 N
   */
  private String emailAddress;
  /**
   * A 6 投资人邮政编码 N
   */
  private String postCode;
  /**
   * C 120 通讯地址 N
   */
  private String address;
  /**
   * C 20 预留字段 1 N
   */
  private String reservedField1;
  /**
   * C 20 预留字段 2 N
   */
  private String reservedField2;
  /**
   * C 20 预留字段 3 N
   */
  private String reservedField3;
  /**
   * C 20 预留字段 4 N
   */
  private BigDecimal reservedField4;
  /**
   * C 20 预留字段 5 N
   */
  private BigDecimal reservedField5;

  @Override
  public FileTypeEnum getFileType() {
    return FileTypeEnum.FILE_TYPE_43;
  }

  @Override
  public String getSortValue() {
    return serialNo;
  }
}
