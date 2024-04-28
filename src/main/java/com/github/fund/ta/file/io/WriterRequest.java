package com.github.fund.ta.file.io;

import com.github.fund.ta.file.domain.TaProtocolVersion;
import lombok.Builder;
import lombok.Data;

import java.io.OutputStream;
import java.util.Map;
import java.util.stream.Stream;


/**
 * read request
 *
 * @author suzhenyu
 * @since 2021/3/17 9:57 下午
 */
@Data
@Builder
public class WriterRequest {

    private OutputStream outputStream;
    @Builder.Default
    private boolean overFlag = false;
    private TaProtocolVersion protocolVersion;
    @Builder.Default
    private String charsetName = "GB18030";
    @Builder.Default
    private String fileEndStr = "OFDCFEND";

    private TaFileHeader taFileHeader;

    private Stream<Map<String, ?>> fileStream;

}
