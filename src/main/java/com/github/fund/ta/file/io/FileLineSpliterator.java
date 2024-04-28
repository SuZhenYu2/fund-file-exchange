package com.github.fund.ta.file.io;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Spliterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;

/**
 * @author suzhenyu
 * @date 2021/10/22
 */
@Slf4j
public class FileLineSpliterator<T>  implements Spliterator<T>{
    @Getter
    private static long LOOP_PULL_TIMEOUT_MILLISECONDS = 100;

    private final LineIterator reader;
    private final Long start;
    @Getter
    private final AtomicInteger atomicInteger;
    @Getter
    private final AtomicLong dataCount;
    private final LinkedBlockingQueue<Optional<String>> linkedBlockingQueue = new LinkedBlockingQueue<>(600);
    private static final ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("file-io-runner-%d").build();
    private static final ExecutorService newFixedThreadPool = new ThreadPoolExecutor(5,20,200L,TimeUnit.MILLISECONDS
        ,new LinkedBlockingQueue<>(100),namedThreadFactory, new CallerRunsPolicy());

    @Getter
    private volatile Boolean COMPLETED_FLAG = false;
    @Getter
    private volatile Exception  throwException;
    @Getter
    private volatile Boolean CLOSED_FLAG = false;

    public FileLineSpliterator(LineIterator reader, String endStr,AtomicLong dataCount) {

        this.reader = reader;
        start =System.currentTimeMillis();
        this.dataCount =dataCount;
        atomicInteger = new AtomicInteger(0);
        newFixedThreadPool.submit(()->{
            try(LineIterator lineIterator=reader){
                while (lineIterator.hasNext()&& !CLOSED_FLAG){
                    String str = lineIterator.nextLine();
                    if(StringUtils.equals(str,endStr)){
                        break;
                    }
                    linkedBlockingQueue.put(Optional.of(str));
                }
                COMPLETED_FLAG=true;
            }catch (Exception e){
                throwException = e;
                log.error(e.getMessage(),e);
            }

        });


    }


    @SneakyThrows
    @Override
    public boolean tryAdvance(Consumer action) {
        return FileLineSpliteratorParr.getData(action, linkedBlockingQueue, this);

    }

    @Override
    public Spliterator<T> trySplit() {
        if(atomicInteger.incrementAndGet()>20){
            return null;
        }
        return new FileLineSpliteratorParr<>(linkedBlockingQueue,this);
    }


    /**
     * stream
     *
     * @return
     */
    public Stream<T> stream() {
        Stream<T> stream = StreamSupport.stream(this, false);
        return getStream(stream);

    }
    /**
     * stream
     *
     * @return
     */
    public Stream<T> parallelStream() {
        Stream<T> stream = StreamSupport.stream(this, true);
        return getStream(stream);

    }

    private Stream<T> getStream(Stream<T> stream) {
        return stream.onClose(() -> {
            try {
                if(COMPLETED_FLAG){
                    log.info("closed dataCount {}", dataCount.get());
                    IOUtils.close(reader);
                }else{
                    log.info("closed  dataCount {}" ,dataCount.get());
                }
              log.info("一共解析{} 行数据,耗时{}", dataCount, System.currentTimeMillis() - start);


            } catch (IOException e) {
              log.error("关闭文件异常 {}", e.getMessage(), e);
            }
        });
    }





    @Override
    public long estimateSize() {
        return Long.MAX_VALUE;
    }

    @Override
    public int characteristics() {
        return Spliterator.ORDERED;
    }

}

    