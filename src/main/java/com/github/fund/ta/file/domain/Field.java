package com.github.fund.ta.file.domain;

import cn.org.atool.fluent.mybatis.utility.MybatisUtil;
import com.github.fund.ta.file.domain.FileCommonEnum.FieldTypeEnum;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 协议所有字段数据类型定义
 *
 * @author suzhenyu
 */
@Data
public class Field implements java.io.Serializable {

  /**
   * 名称
   */
  private String name;

  private String propertyName;
  /**
   * N/A/C/TEXT
   */
  private FieldTypeEnum type;
  /**
   * 长度，小数位
   */
  private String format;
  /**
   * 备注
   */
  private String comment;


  public static String leftPadding(String str, int len, char c) throws Exception {

    byte[] chars = str.getBytes("GB18030");
    if (chars.length > len) {
      throw new Exception("数据长度超过协议长度");
    }
   int cha= len - chars.length;
    if(cha == 0){
      return str;
    }
    byte[] newChars= new byte[len];
    for(int i=len-1;i>=0;i--){
      if(i >= cha){
        newChars[i]=chars[i-cha];
      }else{
        newChars[i]= (byte) c;
      }
    }
    return new String(newChars,"GB18030");
  }

  public static String rightPadding(String str, int len, char c) throws Exception {
    byte[] chars = str.getBytes("GB18030");
    if (chars.length > len) {
      throw new Exception("数据长度超过协议长度");
    }
    if(len == chars.length){
      return str;
    }
    byte[] newChars= new byte[len];
    for(int i=0;i<len;i++){
      if(i < chars.length){
        newChars[i]=chars[i];
      }else{
        newChars[i]= (byte) c;
      }
    }
    return new String(newChars,"GB18030");
  }

  public Field(String name, FieldTypeEnum type, String format, String comment) {
    this.name = name;
    this.type = type;
    this.format = format;
    this.comment = comment;
    this.propertyName=   MybatisUtil.underlineToCamel(name, false);
  }

  public int getLength() {
    if (StringUtils.isEmpty(format)) {
      return 0;
    }
    if (FieldTypeEnum.N.equals(this.type)) {
      return Integer.valueOf(format.split("\\.")[0]);
    } else {
      return Integer.valueOf(format);
    }
  }

  public int getDecimalLength() {
    if (StringUtils.isEmpty(format)) {
      return 0;
    }
    if (FieldTypeEnum.N.equals(this.type)) {
      return Integer.valueOf(format.split("\\.")[1]);
    } else {
      return Integer.valueOf(format);
    }
  }


  @Override
  public String toString() {
    return "Field{" +
        "name='" + name + '\'' +
        ", type='" + type + '\'' +
        ", format='" + format + '\'' +
        ", comment='" + comment + '\'' +
        '}';
  }
}
