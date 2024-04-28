package com.github.fund.ta.file.domain.request;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.confirm.TaEntity;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * R1，非居民报税申请文件
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaR1Request extends TaEntity {

  /**
   * A 24 申请单编号
   */
  private String appSheetSerialNo;
  /**
   * A	8	交易发生日期		Y
   */
  private String transactionDate;
  /**
   * A	6	交易发生时间		Y
   */
  private String transactionTime;
  /**
   * C	9	销售人代码		Y
   */
  private String distributorCode;
  /**
   * C	9	网点号码		Y
   */
  private String branchCode;
  /**
   * A	12	投资人基金帐号		Y
   */
  private String taAccountId;
  /**
   * A	1	个人/机构标志	0-机构，1-个人，2-产品	Y
   */
  private String individualOrInstitution;
  /**
   * A 8 原申请日期
   */
  private String originalAppDate;
  /**
   * A 24 原申请单编号
   */
  private String originalAppSheetNo;
  /**
   * C	1	调查规则	"填写实际采取的尽职调查方式。0：新开账户 1：存量账户"	Y
   */
  private String surveyMethod;
  /**
   * C	1	取得投资人声明标识	"0：否  1：是"	Y
   */
  private String getInvestCerFlag;
  /**
   * C	1	非居民标识	"0：仅为中国税收居民1：仅为非居民2：同为中国和其它国税收居民3:不配合客户"	Y
   */
  private String nonResiFlag;
  /**
   * C	100	中文姓名	开户证件有中文名称的必填。	N
   */
  private String chineseName;
  /**
   * C	100	英文姓2	"个人投资者必填。身份证件只有中文的，填写拼音。如果账户持有人的法定姓名是一个单名，不区分姓和名，则在“英文姓”中填写该单名，“英文名”中填写“NFN”。"	N
   */
  private String englishFamliyName2;
  /**
   * C	100	英文名2	"个人投资者必填。身份证件只有中文的，填写拼音。"	N
   */
  private String englishFirstName2;
  /**
   * C	200	英文全称	"机构投资者必填。投资人英文全称，只有中文名没有官方英文名的，填写拼音。"	N
   */
  private String englishName;
  /**
   * A	1	投资人性别	个人投资者必填。	N
   */
  private String sex;
  /**
   * C	3	地址类型	"机构投资者必填。对机构，后面的“现居国家”及各“现居地址”字段，应同属于办公地址（或注册地址）。0：办公地址  1：注册地址"	N
   */
  private String addressType;
  /**
   * C	3	现居国家	"采用ISO 3166两位字母。对机构填写办公（或注册）所在国家。"	Y
   */
  private String livingCountry;
  /**
   * C	300	现居地址	"中文地址，自由格式，地址位于境内的必填。对机构填写办公地址（或注册地址）。若个人投资者无现居地址，可填邮寄地址。"	N
   */
  private String livingAddress;
  /**
   * C300现居地址2"中文地址，固定格式：省|市|县|邮编。其中的“省、市、县”填写每年12月民政部发布的最新“中华人民共和国县以上行政区划代码”(六位数字)。填写时“省、市”为必需项。对机构填写办公地址（或注册地址）。若个人投资者无现居地址，可填邮寄地址。; N
   */
  private String livingAddress2;
  /**
   * C	300	现居地址3	"英文地址,自由格式，中国境内地址可填写拼音。对机构填写办公地址（或注册地址）。若个人投资者无现居地址，可填邮寄地址。"	Y
   */
  private String livingAddress3;
  /**
   * C300现居地址4"英文地址，固定格式：城市|街道|楼号|房门号|楼层|区|邮箱|邮编|行政区划。新开账户必填。填写时“城市”为必需项。城市：境内地址填写直辖市、地级市或县级市拼音，境外地址填写英文。行政区划：境内地址填写省/自治区/ 直辖市的拼音，境外地址填写相应行政区划。对机构填写办公地址（或注册地址）。若个人投资者无现居地址，可填邮寄地址。;//" N
   */
  private String livingAddress4;
  /**
   * C	8	出生日期	"格式YYYYMMDD新开个人账户必填。"	N
   */
  private String birthDate;
  /**
   * C	3	出生国家	"采用ISO 3166两位字母。新开个人账户，若有国家代码则必填。"	N
   */
  private String birthCountry;
  /**
   * C	200	出生国英文名称	新开个人账户，出生国家若无代码则此字段必填。	N
   */
  private String birthCountryEngName;
  /**
   * C	200	出生城市	中国境内城市填写拼音，境外城市填写英文名称。	N
   */
  private String birthCity;
  /**
   * C	2	注册地国家代码	"采用ISO 3166两位字母。对个人表示国籍，对机构表示注册地国家。"	N
   */
  private String regRegionCode;
  /**
   * C	3	税收居民国	采用ISO 3166两位字母。	Y
   */
  private String taxCountry;
  /**
   * C	200	纳税人识别号	若有则必填	N
   */
  private String taxId;
  /**
   * C	60	摘要/说明	若未提供纳税识别号此字段必填。填写‘0’表示‘居民国不发放纳税人识别号’；否则填写无法提供纳税识别号码原因。	N
   */
  private String specification;
  /**
   * C	1	消极非金融机构标识	"1:居民消极非金融机构2:非居民消极非金融机构3:其它机构投资者为机构必填"	N
   */
  private String passiveNonFinFlag;
  /**
   * C	1	存在非居民控制人标识	"0：否  1：是投资者若为消极非金融机构必填。"	N
   */
  private String haveNonResConFlag;
  /**
   * C	100	中文姓名2	"控制人中文姓名。控制人若有中文姓名则必填"	N
   */
  private String chineseName2;
  /**
   * C	100	英文姓3	"控制人英文姓。身份证件只有中文的，填写拼音。若有控制人则此字段必填。"	N
   */
  private String englishFamliyName3;
  /**
   * C	100	英文名3	"控制人英文名。身份证件只有中文的，填写拼音。若有控制人则此字段必填。"	N
   */
  private String englishFirstName3;
  /**
   * C6控制人类型"001：法人控制人-所有权；002：法人控制人-其他；003：法人控制人-高管人员；004：信托-委托人；005：信托-受托人；006：信托-监察人；007：信托-受益人；008：信托-其他控制人；009：其他;-等同于委托人；010：其他-等同于受托人；011：其他-等同于监察人；012：其他-等同于受益人；013：其他-等同于其他控制人。" N
   */
  private String controllerType;
  /**
   * C	1	控制人非居民标识	若有控制人则此字段必填。	N
   */
  private String conNonResiFlag;
  /**
   * N	7（四位小数）	控制人持股比例	填写小数，比如0.6	N
   */
  private BigDecimal conShareRatio;
  /**
   * C	3	现居国家2	"控制人现居国家采用ISO 3166两位字母。"	N
   */
  private String livingCountry2;
  /**
   * C	300	现居地址5	"控制人现居地址中文地址，自由格式，地址位于境内的必填。"	N
   */
  private String livingAddress5;
  /**
   * C	300	现居地址6	中文地址，固定格式。	N
   */
  private String livingAddress6;
  /**
   * C	300	现居地址7	"控制人现居地址。英文地址,自由格式。若有控制人则此字段必填。"	N
   */
  private String livingAddress7;
  /**
   * C	300	现居地址8	"控制人现居地址。英文地址，固定格式。新开账户，若有控制人则此字段必填。"	N
   */
  private String livingAddress8;
  /**
   * C	2	国籍2	"控制人国籍采用ISO 3166两位字母。"	N
   */
  private String regRegionCode2;
  /**
   * C	8	出生日期2	"控制人出生日期。新开账户，若有控制人此字段必填。"	N
   */
  private String birthDate2;
  /**
   * C	3	出生国家2	"控制人出生国家。新开账户，若有控制人且控制人有出生国家代码则必填。采用ISO 3166两位字母。"	N
   */
  private String birthCountry2;
  /**
   * C	200	出生国英文名称2	"控制人出生国英文名称。新开账户，控制人出生国家若无代码则此字段必填。"	N
   */
  private String birthCouEngName2;
  /**
   * C	120	出生城市2	"控制人出生城市。中国境内城市填写拼音，境外城市填写英文名称。"	N
   */
  private String birthCity2;
  /**
   * C	3	税收居民国2	"控制人税收居民国。采用ISO 3166两位字母。若有控制人此字段必填。"	N
   */
  private String taxCountry2;
  /**
   * C	200	纳税人识别号2	控制人纳税人识别号。若有则必填。	N
   */
  private String taxId2;
  /**
   * C	60	摘要/说明2	若有控制人但未提供控制人纳税识别号则此字段必填。填写‘0’表示‘控制人居民国不发放纳税人识别号’；否则填写无法提供纳税识别号码原因。	N
   */
  private String specification2;
  /**
   * A	20	TA确认流水号		Y
   */
  private String taSerialNo;
  /**
   * C	1	增删标志	0-作废，1-新增	Y
   */
  private String addFlag;
  /**
   * C	20	预留字段1		N
   */
  private String reservedField1;
  /**
   * C	20	预留字段2		N
   */
  private String reservedField2;
  /**
   * C	30	预留字段3		N
   */
  private String reservedField3;
  /**
   * N	16(两位小数)	预留字段4		N
   */
  private BigDecimal reservedField4;
  /**
   * N	16(两位小数)	预留字段5		N
   */
  private BigDecimal reservedField5;
  /**
   * C	300	预留字段6		N
   */
  private String reservedField6;

  @Override
  public FileTypeEnum getFileType() {
    return FileTypeEnum.FILE_TYPE_R1;
  }

  @Override
  public String getSortValue() {
    return appSheetSerialNo;
  }
}
