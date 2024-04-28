package com.github.fund.ta.file.domain;

import com.github.fund.ta.file.domain.confirm.TaEntity;
import com.github.fund.ta.file.mapper.TaField21Mapper;
import com.github.fund.ta.file.mapper.TaField22Mapper;
import com.github.fund.ta.file.mapper.TaFieldMapper;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * 协议版本版本
 *
 * @author suzhenyu
 */
public enum TaProtocolVersion {

  /**
   * 21 协议
   */
  VERSION_21("21", new TaField21Mapper()) {
    @Override
    public List<Field> getFields(Class<? extends TaEntity> clazz) {
      return this.getMapField().get(clazz);

    }
  },
  /**
   * 22 协议
   */
  VERSION_22("22", new TaField22Mapper()) {
    @Override
    public List<Field> getFields(Class<? extends TaEntity> clazz) {
      return this.getMapField().get(clazz);
    }

  },
  UNKNOWN("", null) {
    @Override
    public List<Field> getFields(Class<? extends TaEntity> clazz) {
      throw new RuntimeException("un_support ");
    }

  };
  @Getter
  private final String value;

  private final TaFieldMapper taFieldMapper;
  @Getter
  private final Map<Class<? extends TaEntity>, List<Field>> mapField = new ConcurrentHashMap<>(8);


  TaProtocolVersion(String value,
      TaFieldMapper taFieldMapper) {
    this.value = value;
    this.taFieldMapper = taFieldMapper;
  }

  /**
   * 获取类的所有字段
   *
   * @param clazz 类
   * @return
   */
  public abstract List<Field> getFields(Class<? extends TaEntity> clazz);

  /**
   * 根据字段名返回字段信息
   *
   * @param fieldName
   * @return
   */
  public Field getMapperField(String fieldName) {
    if (this.equals(UNKNOWN)) {
      throw new RuntimeException("未知协议不支持解析");
    }
    return taFieldMapper
        .getMapperField(StringUtils.upperCase(fieldName));
  }

  private static final Map<String, TaProtocolVersion> TA_PROTOCOL_VERSION_MAP = Arrays.stream(
          TaProtocolVersion.values())
      .collect(
          Collectors.toMap(TaProtocolVersion::getValue, fileTypeEnum -> fileTypeEnum));


  public static TaProtocolVersion getTaProtocolVersionByCode(String code) {

    return TA_PROTOCOL_VERSION_MAP.getOrDefault(StringUtils.trim(code), UNKNOWN);
  }


}
