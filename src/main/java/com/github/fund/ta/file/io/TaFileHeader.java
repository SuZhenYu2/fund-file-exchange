package com.github.fund.ta.file.io;

import com.github.fund.ta.file.domain.Field;
import com.github.fund.ta.file.domain.FileCommonEnum;
import com.github.fund.ta.file.domain.FileCommonEnum.FileTypeEnum;
import com.github.fund.ta.file.domain.FileCommonEnum.OFDCFTypeEnum;
import com.github.fund.ta.file.domain.TaProtocolVersion;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 *         21       协议版本
 *         05        创建方
 *         001        接收方
 *         20210714    日期
 *         002         文件序号
 *         04            文件类型
 *         05        发送人
 *         001        接收人
 *         121         字段数量
 * @author suzhenyu
 * @date 2022/11/3
 */
@Data
@Builder
public class TaFileHeader {

  private List<Field> fields;

  private String fileUri;
  /**
   * 字段数量
   */
  private Integer filedCount;
  /**
   * 文件序号
   */
  @Builder.Default
  private Integer documentNo= 1;
  /**
   * 创建者
   */
  private String creator ;
  /**
   * 接受方
   */
  private String receiver ;
  /**
   * 日期
   */
  private String date ;
  /**
   * 文件类型
   */
  private FileTypeEnum fileTypeEnum ;
  /**
   * 发送人
   */
  private  String sender ;
  /**
   * 接收人
   */
  private  String recipient ;
  /**
   * 协议版本
   */
  @Builder.Default
  private TaProtocolVersion taProtocolVersion = TaProtocolVersion.VERSION_22;
  /**
   * 类型
   */
  @Builder.Default
  private FileCommonEnum.OFDCFTypeEnum ofdcfTypeEnum= OFDCFTypeEnum.DATA;
  /**
   * total
   */
  private Long total;



}
