package com.github.fund.ta.file.parser;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.confirm.TaEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * default factory implements
 *
 * @author suzhenyu
 * @since 2021/3/17 9:46 下午
 */
public class DefaultTaFileParserFactory implements TaFileParserFactory {

   private final Map<FileTypeEnum, TaFileParser> taFileParserMap = new HashMap<>();

    @Override
    public <T extends TaEntity> TaFileParser<T> newTaFileParser(FileTypeEnum fileType) {

        // get parser from map
        if (!taFileParserMap.containsKey(fileType)) {
            synchronized (DefaultTaFileParserFactory.class) {
                if (!taFileParserMap.containsKey(fileType)) {
                    taFileParserMap.put(fileType, new TaFileParserImpl<>(fileType));
                }
            }
        }

        return taFileParserMap.get(fileType);
    }

    private final static DefaultTaFileParserFactory factory=new DefaultTaFileParserFactory();

    public static DefaultTaFileParserFactory newInstance(){


        return factory;
    }


}
