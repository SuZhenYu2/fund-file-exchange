package com.github.fund.ta.file.domain.confirm;

import lombok.Builder;
import lombok.Data;

/**
 * ta  context info
 *
 * @author suzhenyu
 * @since 2022/8/10 下午8:51
 */
@Data
@Builder
public class TaContextInfo {

    /**
     *  最后修改日期
     */
  private Long lastModified;
    /**
     * 文件URL
     */
  private String fileUri;

}
