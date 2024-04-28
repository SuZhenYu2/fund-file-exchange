package com.github.fund.ta.file.domain.confirm;


import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * todo 备注
 *
 * @author suzhenyu
 * @since 2021/3/16 9:48 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TaFundInformationDisclosure extends TaEntity{


    /**
     * 管理人代码
     */
    private String administratorCode;

    /**
     * 基金代码
     */
    private String fdCode;

    /**
     * 基金名称
     */
    private String fdName;

    /**
     * 信息披露文件名称
     */
    private String informationDisclosureFileName;


    @Override
    public FileTypeEnum getFileType() {
        return FileTypeEnum.FILE_TYPE_UNKNOWN;
    }

    @Override
    public String getSortValue() {
        return fdCode;
    }

}
