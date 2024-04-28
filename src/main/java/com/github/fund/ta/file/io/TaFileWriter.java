package com.github.fund.ta.file.io;

import com.github.fund.ta.file.domain.Field;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicLong;

import static java.nio.file.Files.newOutputStream;

/**
 * @author suzhenyu
 * @date 2022/12/4
 */
@Slf4j
public class TaFileWriter {

    public static Long writer(WriterRequest writerRequest) throws Exception {
        File file = createNewFile("/tmp/gen/"+writerRequest.getTaFileHeader().getFileUri() + ".tmp", true);
        Long lines;
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(newOutputStream(file.toPath()),
                        writerRequest.getCharsetName()));
        ) {
            lines = writerLineData(writerRequest, writer);
            writerEndStr(writerRequest, writer);
            writerRequest.getTaFileHeader().setTotal(lines);
        } catch (Exception e) {
            log.error("生成文件失败：" + e.getMessage(), e);
            throw e;
        }
        try (
             FileInputStream is = new FileInputStream(file);
             FileChannel inChannel = is.getChannel();
             OutputStream outputStream = writerRequest.getOutputStream();
             BufferedWriter writerHeader = new BufferedWriter(
                     new OutputStreamWriter(outputStream,
                             writerRequest.getCharsetName())
             )
        ) {
            writerHeader(writerRequest, writerHeader);
            writerHeader.flush();
            long position = 0;
            long size = inChannel.size();
            while (0 < size) {
                long count = inChannel.transferTo(position, inChannel.size(),
                        Channels.newChannel(outputStream));
                if (count > 0) {
                    position += count;
                    size -= count;
                }
            }
        } catch (Exception e) {
            log.error("生成文件失败：" + e.getMessage(), e);
            throw e;
        }

        try {
            file.delete();
        } catch (Exception ignored) {
        }
        return lines;

    }

    public static File createNewFile(String fileUri, boolean flag) throws IOException {
        File file = new File(fileUri);
        if (!file.exists()) {
            File dir = new File(file.getParent());
            if (!dir.exists()) {
                dir.mkdirs();
            }
            file.createNewFile();
        } else {
            if (!flag) {
                throw new RuntimeException("文件已存在");
            } else {
                if (file.delete()) {
                    file.createNewFile();
                }
            }
        }
        return file;
    }

    private static void writerEndStr(WriterRequest writerRequest,
                              BufferedWriter writer) throws IOException {
        writer.write(writerRequest.getFileEndStr());
    }

    private static Long writerLineData(WriterRequest writerRequest,
                                BufferedWriter writer) {

        AtomicLong atomicLong = new AtomicLong(0);
        writerRequest.getFileStream().forEach(
                f -> {
                    try {
                        for (Field field : writerRequest.getTaFileHeader().getFields()
                        ) {
                            Object orgValue = null;
                            try {
                                orgValue = f.get(field.getPropertyName());
                                String temp = field.getType().getWriteValue(orgValue, field);
                                writer.write(temp);
                            } catch (Exception e) {
                                throw new Exception(field.getName() + ":" + orgValue + "   " + e.getMessage(), e);
                            }
                        }
                        atomicLong.incrementAndGet();
                        writer.newLine();
                    } catch (Exception e) {

                        throw new RuntimeException(e);
                    }

                }
        );

        return atomicLong.get();
    }

    private static void writerTotalNo(WriterRequest writerRequest,
                               BufferedWriter writer) throws Exception {
        writer.write(
                Field.leftPadding(writerRequest.getTaFileHeader().getTotal() + "", 8, '0'));
        writer.newLine();
    }

    private static void writerFields(WriterRequest writerRequest,
                              BufferedWriter writer) throws IOException {
        writer.write(writerRequest.getTaFileHeader().getFields().size() + "");
        writer.newLine();
        for (Field field : writerRequest.getTaFileHeader().getFields()
        ) {
            writer.write(field.getName());
            writer.newLine();
        }


    }

    private static void writerHeader(WriterRequest writerRequest,
                              BufferedWriter writer) throws Exception {

        //        OFDCFDAT 文件数据格式
//        21       协议版本
//        05        创建方
//        001        接收方
//        20210714    日期
//        002         文件序号
//        04            文件类型
//        05        发送人
//        001        接收人
//        121         字段数量
        // 协议版本
        writerFormatType(writerRequest, writer);

        writer.write(writerRequest.getTaFileHeader().getTaProtocolVersion().getValue());
        writer.newLine();
        writer.write(writerRequest.getTaFileHeader().getCreator());
        writer.newLine();
        writer.write(writerRequest.getTaFileHeader().getReceiver());
        writer.newLine();
        writer.write(writerRequest.getTaFileHeader().getDate());
        writer.newLine();
        writer.write(Field.rightPadding(writerRequest.getTaFileHeader().getDocumentNo() + "", 3, '0'));
        writer.newLine();
        writer.write(writerRequest.getTaFileHeader().getFileTypeEnum().getType());
        writer.newLine();
        writer.write(writerRequest.getTaFileHeader().getSender());
        writer.newLine();
        writer.write(writerRequest.getTaFileHeader().getRecipient());
        writer.newLine();
        writerFields(writerRequest, writer);
        writerTotalNo(writerRequest, writer);
    }

    private static void writerFormatType(WriterRequest writerRequest,
                                  BufferedWriter writer) throws IOException {
        writer.write(writerRequest.getTaFileHeader().getOfdcfTypeEnum().getType());
        writer.newLine();
    }
}
