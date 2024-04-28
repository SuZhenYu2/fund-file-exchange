package com.github.fund.ta.file.generator;

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
public class DefaultTaFileGeneratorFactory {

  @SuppressWarnings("rawtypes")
  private final Map<FileTypeEnum, TaFileGenerator> taFileGeneratorHashMap = new HashMap<>();


  @SuppressWarnings("rawtypes")
  public <T extends TaEntity> TaFileGenerator<T> newTaFileGenerator(FileTypeEnum fileType) {

    // get parser from map
    if (!taFileGeneratorHashMap.containsKey(fileType)) {
      synchronized (DefaultTaFileGeneratorFactory.class) {
        if (!taFileGeneratorHashMap.containsKey(fileType)) {
          taFileGeneratorHashMap.put(fileType, new TaFileGeneratorImpl(fileType));
        }
      }
    }

    return taFileGeneratorHashMap.get(fileType);
  }

  private final static DefaultTaFileGeneratorFactory factory = new DefaultTaFileGeneratorFactory();

  public static DefaultTaFileGeneratorFactory newInstance() {

    return factory;
  }


}
