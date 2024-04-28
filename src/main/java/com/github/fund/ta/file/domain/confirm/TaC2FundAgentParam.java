package com.github.fund.ta.file.domain.confirm;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基金代理关系（C2 文件）
 *
 * @author suzhenyu
 * @since 2021/7/14 10:54 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaC2FundAgentParam extends TaEntity {

  /**
   * A 20 序号 唯一确定一条记录，不能重复 Y
   */
  private String sequenceNO;
  /**
   * C 6 基金代码 Y
   */
  private String fundCode;
  /**
   * A 1 收费方式 0-前收费，1-后收费2-前后收费共用（基金代码）Y
   */
  private String shareClass;
  /**
   * C 9 销售人代码 Y
   */
  private String distributorCode;
  /**
   * C 9 网点号码 托管网点号码。对大集中方式的销售人，此字段与销售人代码相同。N
   */
  private String branchCode;
  /**
   * C 1 是否允许打折 0-非 1-是 N
   */
  private String isDiscount;
  /**
   * N 16( 两 位小数)申购交收天数 举例：T 日申报申购交易，T+2 日资金划付到基金备付金户，则申购交收天数为 2 Y
   */
  private BigDecimal buyPayPeriod;
  /**
   * N 16( 两 位小数)赎回交收天数 举例：T 日申报赎回交易，T+2 日资金划付到销售人备付金户，则赎回交收天数为2 Y
   */
  private BigDecimal redemptionPayPeriod;
  /**
   * N 16( 两 位小数)基金转换交收天数 指转出基金划出资金到对方基金的时间Y
   */
  private BigDecimal conversionPayPeriod;
  /**
   * N 16( 两 位小数)认购退款交收天数 指认购未成功的金额划回到销售人账户距离比例配售确认日的天数 N
   */
  private BigDecimal subPayBackPeriod;
  /**
   * N 16( 两 位小数)分红交收天数 指分红款划到销售人账户距离权益登记日的天数 N
   */
  private BigDecimal dividendPayPeriod;
  /**
   * C 1 手续费结算方式 0-净额结算 1-全额结算 YJR/T XX—XXXX96
   */
  private String chargePayMethod;
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
    return FileTypeEnum.FILE_TYPE_C2;
  }

  @Override
  public String getSortValue() {
    return sequenceNO;
  }


}
