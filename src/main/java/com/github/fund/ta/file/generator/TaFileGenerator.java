package com.github.fund.ta.file.generator;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.confirm.TaEntity;
import java.io.IOException;

/**
 * 文件解析器
 *
 * @param <T>
 * @author suzhenyu
 */
public interface TaFileGenerator<T extends TaEntity> {

  /**
   * 返回文件类型
   *
   * @return
   */
  FileTypeEnum getFileType();

 
  /**
   * taFileGeneratorRequest*
   * @param taFileGeneratorRequest
   * @return
   * @throws IOException
   */
  TaFileGeneratorResponse generator(TaFileGeneratorRequest taFileGeneratorRequest)
      throws IOException;

}
