package com.github.fund.ta.file.domain;

import com.github.fund.ta.file.io.TaFileHeader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Getter;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;

/**
 * @author suzhenyu
 * @date 2022/11/8
 */
public class FileCommonEnum {

  private static final Map<String, FileTypeEnum> FILE_TYPE_ENUM_MAP = Arrays.stream(
          FileTypeEnum.values())
      .collect(
          Collectors.toMap(fileTypeEnum -> fileTypeEnum.getType(), fileTypeEnum -> fileTypeEnum));


  private static final Map<String, FieldTypeEnum> FIELD_TYPE_ENUM_MAP = Arrays.stream(
          FieldTypeEnum.values())
      .collect(
          Collectors.toMap(fieldTypeEnum -> fieldTypeEnum.getType(),
              fieldTypeEnum -> fieldTypeEnum));


  private static final Map<String, OFDCFTypeEnum> OFDCF_TYPE_ENUM_MAP = Arrays.stream(
          OFDCFTypeEnum.values())
      .collect(
          Collectors.toMap(ofdcfTypeEnum -> ofdcfTypeEnum.getType(), fileTypeEnum -> fileTypeEnum));


  public enum BusinessCodeEnum {
    /**
     *
     */
    BUSINESS_CODE_120("120", ""),
    /**
     *
     */
    BUSINESS_CODE_130("130", ""),
    /**
     *
     */
    BUSINESS_CODE_122("122", ""),
    /**
     *
     */
    BUSINESS_CODE_126("126", ""),
    /**
     *
     */
    BUSINESS_CODE_127("127", ""),
    /**
     *
     */
    BUSINESS_CODE_128("128", ""),
    /**
     *
     */
    BUSINESS_CODE_139("139", ""),
    /**
     *
     */
    BUSINESS_CODE_124("124", ""),
    /**
     *
     */
    BUSINESS_CODE_153("153", ""),
    /**
     *
     */
    BUSINESS_CODE_253("253", ""),
    /**
     *
     */
    BUSINESS_CODE_198("198", ""),
    /**
     *
     */
    BUSINESS_CODE_129("129", ""),
    /**
     *
     */
    BUSINESS_CODE_136("136", ""),
    /**
     *
     */
    BUSINESS_CODE_142("142", ""),
    /**
     *
     */
    BUSINESS_CODE_143("143", ""),
    /**
     *
     */
    BUSINESS_CODE_144("144", ""),
    /**
     *
     */
    BUSINESS_CODE_145("145", ""),
    /**
     *
     */
    BUSINESS_CODE_149("149", ""),
    /**
     *
     */
    BUSINESS_CODE_150("150", ""),
    /**
     *
     */
    BUSINESS_CODE_131("131", ""),
    /**
     *
     */
    BUSINESS_CODE_132("132", ""),
    /**
     *
     */
    BUSINESS_CODE_234("234", ""),
    /**
     *
     */
    BUSINESS_CODE_135("135", ""),
    /**
     *
     */
    BUSINESS_CODE_134("134", ""),
    /**
     *
     */
    BUSINESS_CODE_133("133", "");
    @Getter
    private String code;
    @Getter
    private String desc;

    BusinessCodeEnum(String code, String desc) {
      this.code = code;
      this.desc = desc;

    }

  }


  /**
   * 数据交换文件类型
   */
  public enum FileTypeEnum {
    /**
     * 账户申请
     */
    FILE_TYPE_01("01", "账户申请"),
    /**
     * 账户确认
     */
    FILE_TYPE_02("02", "账户确认"),
    /**
     * 交易申请数据与业务
     */
    FILE_TYPE_03("03", "交易申请数据与业务"),
    /**
     * 交易确认数据与业务
     */
    FILE_TYPE_04("04", "交易确认数据与业务"),
    /**
     * 基金账户对账
     */
    FILE_TYPE_05("05", "基金账户对账"),
    /**
     * 基金分红
     */
    FILE_TYPE_06("06", "基金分红"),
    /**
     * 基金动态信息
     */
    FILE_TYPE_07("07", "基金动态信息"),
    /**
     * 公告
     */
    FILE_TYPE_08("08", "公告"),
    /**
     * 红利汇总
     */
    FILE_TYPE_09("09", "红利汇总"),
    /**
     * 日交割汇总
     */
    FILE_TYPE_10("10", "日交割汇总"),
    /**
     * 业务申请汇总（ TA 发送）
     */
    FILE_TYPE_11("11", "业务申请汇总（ TA 发送）"),
    /**
     * 业务确认汇总
     */
    FILE_TYPE_12("12", "业务确认汇总"),
    /**
     * 业务申请汇总（代理人发送）
     */
    FILE_TYPE_13("13", "业务申请汇总（代理人发送）"),
    /**
     * 参与人及结算席位文件
     */
    FILE_TYPE_21("21", "参与人及结算席位文件"),
    /**
     * 其它类申请
     */
    FILE_TYPE_23("23", "其它类申请"),
    /**
     * 其它类确认
     */
    FILE_TYPE_24("24", "其它类确认"),
    /**
     * 资金清算
     */
    FILE_TYPE_25("25", "资金清算"),
    /**
     * 理财产品份额明细
     */
    FILE_TYPE_26("26", "理财产品份额明细"),
    /**
     * T 日过户申请
     */
    FILE_TYPE_33("33", "T 日过户申请"),
    /**
     * T 日过户确认
     */
    FILE_TYPE_34("34", "T 日过户确认"),
    /**
     * T 日过户对账
     */
    FILE_TYPE_35("35", "T 日过户对账"),
    /**
     * 电子合同申请
     */
    FILE_TYPE_43("43", "电子合同申请"),
    /**
     * 电子合同确认
     */
    FILE_TYPE_44("44", "电子合同确认"),
    /**
     * 非居民涉税信息
     */

    FILE_TYPE_R1("R1", "非居民涉税信息"),
    /**
     * 非居民涉税信息
     */
    FILE_TYPE_R2("R2", "非居民涉税信息"),
    /**
     * 基金基础参数
     */

    FILE_TYPE_C1("C1", "基金基础参数"),
    /**
     * 基金代理关系
     */
    FILE_TYPE_C2("C2", "基金代理关系"),
    /**
     * 基金转换关系
     */
    FILE_TYPE_C3("C3", "基金转换关系"),
    /**
     * 基金分红方案
     */
    FILE_TYPE_C4("C4", "基金分红方案"),
    /**
     * 基金费率
     */
    FILE_TYPE_C5("C5", "基金费率"),
    /**
     * 理财产品可赎回日期文件
     */
    FILE_TYPE_C6("C6", "理财产品可赎回日期文件"),
    /**
     * 个人反洗钱申请
     */

    FILE_TYPE_X1("X1", "个人反洗钱申请"),
    /**
     * 个人反洗钱确认
     */
    FILE_TYPE_X2("X2", "个人反洗钱确认"),
    /**
     * 机构反洗钱申请
     */
    FILE_TYPE_X3("X3", "机构反洗钱申请"),
    /**
     * 机构反洗钱确认
     */
    FILE_TYPE_X4("X4", "机构反洗钱确认"),
    FILE_TYPE_UNKNOWN("", "未知");

    @Getter
    private String type;
    @Getter
    private String desc;

    FileTypeEnum(String type, String desc) {
      this.type = type;
      this.desc = desc;
    }


    public static FileTypeEnum getFileTypeEnumByType(String type) {
      type = StringUtils.trim(type);
      FileTypeEnum fileTypeEnum = FILE_TYPE_ENUM_MAP.get(type);
      if (Objects.isNull(fileTypeEnum)) {
        fileTypeEnum = FILE_TYPE_UNKNOWN;

      }

      return fileTypeEnum;
    }


  }


  public enum OFDCFTypeEnum implements FileProtocol {
    /**
     * 索引文件
     */
    IDX("OFDCFIDX", "索引文件") {
      @Override
      public TaFileHeader getTaFileHeader(LineIterator reader) {

        return null;
      }

    },
    /**
     * 数据文件
     */
    DATA("OFDCFDAT", "数据文件") {
      @Override
      public TaFileHeader getTaFileHeader(LineIterator reader) throws IOException {
        //        OFDCFDAT 文件数据格式
//        21       协议版本
//        05        创建方
//        001        接收方
//        20210714    日期
//        002         文件序号
//        04            文件类型
//        05        发送人
//        001        接收人
//        121         字段数量

        String version = reader.nextLine();
        String creator = reader.nextLine();
        String receiver = reader.nextLine();
        String date = reader.nextLine();
        String documentNo = reader.nextLine();
        String fileType = reader.nextLine();
        String sender = reader.nextLine();
        String recipient = reader.nextLine();
        String filedNo = reader.nextLine();

        TaFileHeader taFileHeader = TaFileHeader.builder()
            .taProtocolVersion(TaProtocolVersion.getTaProtocolVersionByCode(version))
            .documentNo(StringUtils.isEmpty(documentNo) ? null : Integer.valueOf(StringUtils.trim(documentNo)))
            .date(date)
            .creator(creator)
            .receiver(receiver)
            .sender(sender)
            .recipient(recipient)
            .filedCount(Integer.parseInt(StringUtils.trim(filedNo)))
            .fileTypeEnum(FileTypeEnum.getFileTypeEnumByType(fileType)).build();

//        开始读取字段
        String tempString;

        List<Field> filedList = new ArrayList<>();
        int count = 0;
        while ((tempString = reader.nextLine()) != null) {
          Field field = taFileHeader.getTaProtocolVersion()
              .getMapperField(StringUtils.trim(tempString));
          filedList.add(field);
          count++;
          if (count == taFileHeader.getFiledCount()) {
            break;
          }

        }
        taFileHeader.setFields(filedList);
        String total = reader.nextLine();
        taFileHeader.setTotal(Long.parseLong(total));
        return taFileHeader;
      }

    },

    UNKNOWN("", "未知") {
      @Override
      public TaFileHeader getTaFileHeader(LineIterator reader) {
        throw new RuntimeException("未知协议文件");
      }

    };
    @Getter
    private String type;
    @Getter
    private String desc;


    OFDCFTypeEnum(String type, String desc) {
      this.type = type;
      this.desc = desc;
    }

    public static OFDCFTypeEnum getOFDCFTypeEnumByType(String type) {

      OFDCFTypeEnum ofdcfTypeEnum = OFDCF_TYPE_ENUM_MAP.get(type);
      if (Objects.isNull(ofdcfTypeEnum)) {
        ofdcfTypeEnum = UNKNOWN;
      }

      return ofdcfTypeEnum;
    }


  }

  public interface FileProtocol {


    /**
     * getTaFileHeader
     *
     * @param reader buffer
     * @return TaFileHeader
     * @throws IOException io异常
     */

    TaFileHeader getTaFileHeader(LineIterator reader) throws IOException;


  }

  /**
   * 字段类型
   */
  public enum FieldTypeEnum implements FiledValue {
    /**
     * 数字左补零右对齐
     */
    N("N", "数字左补零右对齐") {
      @Override
      public String getValue(String orgValue,
          Field field) {
        if (field.getDecimalLength() > 0) {
          orgValue =
              (orgValue.substring(0, field.getLength() - field.getDecimalLength()))
                  + "."
                  + orgValue.substring(field.getLength() - field.getDecimalLength(),
                  field.getLength());
          return new BigDecimal(orgValue).setScale(field.getDecimalLength()).toPlainString();
        }

        return orgValue;
      }

      @Override
      public String getWriteValue(Object value, Field field) throws Exception {
        if (Objects.isNull(value)) {
          value = "0";
        }
        String tempValue = String.valueOf(value);
        if (field.getDecimalLength() > 0) {

          BigDecimal decimal = new BigDecimal(tempValue);
          String temp = decimal.setScale(field.getDecimalLength(),
              RoundingMode.HALF_UP).toPlainString();
          temp = temp.replace(".", "");
          return Field.leftPadding(temp, field.getLength(), '0');
        }
        if (StringUtils.contains(tempValue, ".")) {
          throw new RuntimeException(" 数字未设置精度不能有小数点存在");

        }
        return Field.leftPadding(tempValue, field.getLength(), '0');
      }
    },
    /**
     * 字符右补空格左对齐
     */
    C("C", "字符右补空格左对齐") {
      @Override
      public String getValue(String orgValue,
          Field field) {
        return orgValue;
      }

      @Override
      public String getWriteValue(Object value, Field field) throws Exception {
        if (value == null) {
          value = "";
        }
        return Field.rightPadding(String.valueOf(value), field.getLength(), ' ');
      }
    },
    /**
     * 数字字符型，限于 0—9 右补空格左对齐
     */
    A("A", "数字字符型，限于 0—9 右补空格左对齐") {
      @Override
      public String getValue(String orgValue,
          Field field) {
        return orgValue;
      }

      @Override
      public String getWriteValue(Object value, Field field) throws Exception {
        if (value == null) {
          value = "";
        }
        return Field.rightPadding(String.valueOf(value), field.getLength(), ' ');
      }
    },
    /**
     * 文本类型
     */
    TEXT("TEXT", "文本类型") {
      @Override
      public String getValue(String orgValue,
          Field field) {
        return null;
      }

      @Override
      public String getWriteValue(Object value, Field field) throws Exception {
        if (value == null) {
          value = "";
        }
        return Field.rightPadding(String.valueOf(value), field.getLength(), ' ');
      }
    },
    UNKNOWN("", "未知类型") {
      @Override
      public String getValue(String orgValue,
          Field field) {
        return null;
      }

      @Override
      public String getWriteValue(Object value, Field field) {
        return null;
      }
    };
    @Getter
    private String type;
    @Getter
    private String desc;

    FieldTypeEnum(String type, String desc) {
      this.type = type;
      this.desc = desc;
    }


    public static FieldTypeEnum getFieldTypeEnumByType(String value) {
      return FIELD_TYPE_ENUM_MAP.getOrDefault(value, UNKNOWN);
    }
  }

  public interface FiledValue {


    /**
     * getValue
     *
     * @param orgValue String
     * @param field
     * @return String
     */
    String getValue(String orgValue, Field field);


    /**
     * getWriteValue
     *
     * @param value 值
     * @param field 字段
     * @return 写入值
     * @throws Exception
     */
    String getWriteValue(Object value, Field field) throws Exception;


  }


}
