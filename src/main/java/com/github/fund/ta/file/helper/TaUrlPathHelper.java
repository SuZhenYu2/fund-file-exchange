package com.github.fund.ta.file.helper;

import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import org.apache.commons.lang3.StringUtils;


/**
 * 返回ta的文件名和路径
 *
 * @author suzhenyu
 * @since 2021/3/16 3:43 下午
 */
public class TaUrlPathHelper {

    /**
     * 适配写出文件拆分
     *
     * @param path 路径
     * @param taCode  ta 编码
     * @param distributorCode 销售机构
     * @param date 日期
     * @param fileType 文件类型
     * @param number 序号
     * @return 文件名称
     */
    public static String getFileUri(String path, String taCode, String distributorCode, String date, FileTypeEnum fileType, String number) {
        if (FileTypeEnum.FILE_TYPE_01.equals(fileType)
                || FileTypeEnum.FILE_TYPE_03.equals(fileType)
                || FileTypeEnum.FILE_TYPE_R1.equals(fileType)
                || FileTypeEnum.FILE_TYPE_43.equals(fileType)
                || FileTypeEnum.FILE_TYPE_X1.equals(fileType)
                || FileTypeEnum.FILE_TYPE_X3.equals(fileType)) {

            if (StringUtils.isEmpty(number)) {
                return path + "/OFD_" + distributorCode + "_" + taCode + "_" + date + "_" + fileType.getType() + ".TXT";
            } else {
                return path + "/OFD_" + distributorCode + "_" + taCode + "_" + date + "_" + fileType.getType() + "_" + number + ".TXT";
            }
        }

        return path + "/OFD_" + taCode + "_" + distributorCode + "_" + date + "_" + fileType.getType() + ".TXT";
    }

    public static int compare(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return 1;
        }else if (s1.length() < s2.length()) {
            return -1;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return 1;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                return -1;
            }
        }
        return 0;
    }


}
