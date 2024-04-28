package com.github.fund.ta.file.mapper;

import com.github.fund.ta.file.domain.TaProtocolVersion;

/**
 * 返回协议的字段信息
 *
 * @author suzhenyu
 * @since 2021/3/16 3:44 下午
 */
public class TaField21Mapper extends TaFieldMapper {

    public TaField21Mapper() {
        super(TaProtocolVersion.VERSION_21, "tafile/field21.conf");
    }

}
