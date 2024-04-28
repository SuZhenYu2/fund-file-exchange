package com.github.fund.ta.file.parser;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.confirm.TaEntity;

/**
 * ta file parser factory
 *
 * @author suzhenyu
 * @since 2021/3/17 9:38 下午
 */
public interface TaFileParserFactory {

    /**
     * newTaFileParser
     * @param fileType 文件类型
     * @param <T> 范型
     * @return 解析实体
     */
    <T extends TaEntity> TaFileParser<T> newTaFileParser(FileTypeEnum fileType);

}
