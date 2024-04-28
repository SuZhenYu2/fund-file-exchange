package com.github.fund.ta.file.domain.confirm;

import static com.github.fund.ta.file.helper.TaUrlPathHelper.compare;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * ta文件交互的domain， 字段首字母，小写
 * <p>
 * C 字符型 A 数字字符型，限于 0—9 N 数值型，其长度不包含小数点，可参与数值计算 TEXT 不定长文本
 *
 * @author suzhenyu
 */
@Data
public abstract class TaEntity implements Serializable, Comparable<TaEntity> {

  /**
   * 明细
   */
  public final static String Detail_Flag_DETAIL = "1";
  /**
   * Detail_Flag_NON_DETAIL
   */
  public final static String Detail_Flag_NON_DETAIL = "0";


  /**
   * getFileType
   *
   * @return
   */
  public abstract FileTypeEnum getFileType();

  /**
   * 获取排序字段
   *
   * @return
   */
  public abstract String getSortValue();

  private String registrarCode;

  private TaContextInfo taContextInfo;

  @Override
  public int compareTo(TaEntity o) {
    return compare(this.getSortValue(), o.getSortValue());
  }

}
