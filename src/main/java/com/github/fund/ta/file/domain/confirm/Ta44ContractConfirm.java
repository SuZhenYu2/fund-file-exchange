package com.github.fund.ta.file.domain.confirm;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @program: fundx
 * @description: 签约电子合同确认
 * @author: shenty
 * @create: 2018-08-09 16:02
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class Ta44ContractConfirm extends TaEntity{

    String fundCode; //C 6 基金代码 Y
    String taAccountId; //C 12 投资人基金账号 N
    String transactionAccountId;//A 17 投资人基金交易账号 Y
    String businessCode; // A 3 业务代码 401:合同签订 402:合同补 正 403:合同撤销 Y
    String contractType; //C 1 合同类型 1-电子签名合同 2-纸质合同 Y
    String serialNo; //C 26 流水号 产品代码(6 位)+合同类型 (1 位)+销售机构代码(3 位)+日期(8 位)+顺序号 (8 位) Y
    String version; //C 3 合同版本号，从 001 开始增 长 Y
    String signType; //C 1 签署类型 1-新签合同，2-补签合同 Y
    String secondStatus; //C 1 第二用途状态管理人合同核对状态,0-待 核对 1-核对通过 2-未通过
    String thirdStatus; //C1第三用途状态托管人合同核对状态，0-待 核对 1-核对通过 2-未通过
    String distributorCode; //C 9 销售人代码 Y
    String fundManagerCode; //C 3 基金管理人
    String custodianCode;//C 3 托管人代码
    String investorName; //C 120 投资人户名 Y
    String individualOrInstitution; //A 1 个人/机构标志 机构0 个人1 Y
    String certificateType; // C 1 个人证件类型及机构证件类型 Y
    String certificateNo; //C 30 投资人证件号码 Y
    String transactionDate; //A 8 交易发生日期 Y
    String transactionTime; //A 6 交易发生时间 Y
    String acceptMethod; //C 1 受理方式 Y
    String acceptPlace; //C 40 受理地点 受理方式为柜台，填写柜 台号;受理方式为网上，填 客户端 IP 地址 Y
    String netNo;//C 9 投资人实际申报交易的操作 网点编号，柜台受理时必填 N
    String notes;//C 64 附加信息 N
    String secondNotes;//C 64 第二用途信息管理人附加信息，客户不可见。
    String thirdNotes;// C 64 第三用途信息托管人附加信息，客户不可见。
    String alternationDate; //A 8 最后更新日 Y
    String secondDate; //C 8 第二用途日期管理人最后修改日期
    String thirdDate; //C 8 第三用途日期托管人最后修改日期
    String signRiskNotice; //C 1 客户:0-未签署风险揭示书; 1-已签署电子风险揭示书; 2-已签署纸质风险揭示书 N
    String riskMatching; //C 1 1-客户风险匹配; 2-客户风险不匹配且已签署 风险责任承诺 N
    String clientRiskRate; //C 1 客户风险等级 N
    String cardNo; //C 32 客户银行卡号或券商端资金账号 N
    String telNo; //C 22 投资人电话号码 N
    String mobileTelNo; //C 24 投资人手机号码 N
    String emailAddress; //C 40 投资人 E-MAIL 地址 N
    String postCode; //A 6 投资人邮政编码 N
    String address; //C 120 通讯地址 N
    String reservedField1; //C 20 预留字段 1 N
    String reservedField2; //C 20 预留字段 2 N
    String reservedField3; //C 30 预留字段 3 N
    Double reservedField4; //N 16 预留字段 4 N
    Double reservedField5; //N 16 预留字段 5 N


    @Override
    public FileTypeEnum getFileType() {
        return FileTypeEnum.FILE_TYPE_44;
    }

    @Override
    public String getSortValue() {
        return fundCode;
    }


}
