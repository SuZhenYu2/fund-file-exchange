package com.github.fund.ta.file.helper;

import com.github.fund.ta.file.domain.Field;
import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.TaProtocolVersion;
import com.github.fund.ta.file.domain.confirm.TaEntity;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 解析domain
 *
 * @author suzhenyu
 * @since 2021/3/17 10:15 下午
 */
@Slf4j
public class TaEntityClassHelper {

  private static Map<String, Class<? extends TaEntity>> taEntityMap = new HashMap<>(64);

  static {
    Reflections reflections = new Reflections("com.xueqiu.fundx.core.common.tafile.domain");

    Set<Class<? extends TaEntity>> classes = reflections.getSubTypesOf(TaEntity.class);

    for (Class<? extends TaEntity> aClass : classes) {
      try {
        TaEntity bean = aClass.newInstance();
        if(bean.getFileType() == FileTypeEnum.FILE_TYPE_UNKNOWN){
          continue;
        }
        taEntityMap.put(bean.getFileType().getType(), aClass);
        java.lang.reflect.Field[] fieldList = aClass.getDeclaredFields();

        List<Field> list21 = new ArrayList<>();
        List<Field> list22 = new ArrayList<>();

        // 判断该属性是否是public final static 类型的
        // 如果想过去其它的,具体可以参考 Modifier 这个类里面的修饰符解码

        Arrays.stream(fieldList).filter(field -> !field.getDeclaringClass().equals(TaEntity.class))
            .filter(field -> !Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(
                field.getModifiers()))
            .forEach(
                field -> {
                  Field field21 = TaProtocolVersion.VERSION_21.getMapperField(field.getName());
                  Field field22 = TaProtocolVersion.VERSION_22.getMapperField(field.getName());
                  if (Objects.isNull(field21) && Objects.isNull(field22)) {
                    throw new RuntimeException(aClass.getSimpleName() + "不存在的字段" + field.getName());
                  }
                  if (Objects.nonNull(field21)) {
                    list21.add(field21);
                  }
                  if (Objects.nonNull(field22)) {
                    list22.add(field22);
                  }
                }
            );
        TaProtocolVersion.VERSION_21.getMapField().put(aClass, list21);
        TaProtocolVersion.VERSION_22.getMapField().put(aClass, list22);

      } catch (InstantiationException e) {
        log.error(e.getMessage(), e);
      } catch (IllegalAccessException e) {
        log.error(e.getMessage(), e);
      }

    }

  }

  public static Map<String, Class<? extends TaEntity>> getTaEntityMap() {

    return taEntityMap;
  }


  public static Class<? extends TaEntity> getTaEntity(FileTypeEnum fileType) {
    return getTaEntityMap().get(fileType.getType());
  }

}
