package com.github.fund.ta.file.parser;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.confirm.TaEntity;

/**
 * 文件解析器
 *
 * @param <T>
 * @author suzhenyu
 */
public interface TaFileParser<T extends TaEntity> {

  /**
   * 返回文件类型
   *
   * @return
   */
  FileTypeEnum getFileType();

  /**
   * parse
   *
   * @param taFileParseRequest 文件请求参数
   * @return TaFileParseResponse
   */
  TaFileParseResponse parse(TaFileParseRequest taFileParseRequest);

}
