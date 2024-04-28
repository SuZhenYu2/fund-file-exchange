package com.github.fund.ta.file.mapper;

import com.github.fund.ta.file.domain.Field;
import com.github.fund.ta.file.domain.FileCommonEnum.FieldTypeEnum;
import com.github.fund.ta.file.domain.TaProtocolVersion;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


/**
 * 返回协议的字段信息
 *
 * @author suzhenyu
 * @since 2021/3/16 3:44 下午
 */
@Slf4j
public abstract class TaFieldMapper {


  private final TaProtocolVersion taProtocolVersion;

  @Getter
  private final String configureFile;

  public TaFieldMapper(TaProtocolVersion taProtocolVersion, String configureFile) {
    this.taProtocolVersion = taProtocolVersion;
    this.configureFile = configureFile;
  }

  /**
   * 返回协议版本号
   *
   * @return 协议版本
   */
  public TaProtocolVersion getProtocolVersion() {
    return taProtocolVersion;
  }

  /**
   * 根据字段名返回字段信息
   *
   * @param fieldName 字段名称
   * @return 字段描述
   */
  public Field getMapperField(String fieldName) {
    return getFieldMap(getConfigureFile()).get(fieldName);
  }

  private volatile Map<String, Field> singleFiledMap;

  public Map<String, Field> getFieldMap(String configureFile) {
    if (singleFiledMap == null) {
      synchronized (TaFieldMapper.class) {
        if (singleFiledMap == null) {
          singleFiledMap = parserConfigureFile(configureFile);
        }
      }
    }
    return singleFiledMap;
  }


  protected static Map<String, Field> parserConfigureFile(String configureFile) {
    Map<String, Field> fieldMapper = new HashMap<>(128);
    Properties properties = new Properties();
    String path = Objects.requireNonNull(TaFieldMapper.class.getClassLoader().getResource("")).getPath();
    try (FileInputStream is = new FileInputStream(path+"/"+configureFile);
        InputStreamReader inputStreamReader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
      properties.load(inputStreamReader);
      Enumeration<?> enumeration = properties.propertyNames();
      while (enumeration.hasMoreElements()) {
        String propertyName = (String) enumeration.nextElement();
        String value = properties.getProperty(propertyName);
        String[] values = value.split("#");

        fieldMapper.put(propertyName.toUpperCase(),
            new Field(propertyName, FieldTypeEnum.getFieldTypeEnumByType(values[0]), values[1],
                values[2]));
      }
    } catch (Exception e) {
      log.error("文件协议解析器初始化失败{}", configureFile, e);
    }
    return fieldMapper;
  }

}
