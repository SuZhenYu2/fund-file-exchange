package com.github.fund.ta.file.io;

import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author suzhenyu
 * @date 2021/10/22
 */
@Slf4j
public class FileLineSpliteratorParr<T> implements Spliterator<T> {

  private final LinkedBlockingQueue<Optional<String>> linkedBlockingQueue;
  private final FileLineSpliterator<T> fileLineSpliterator;


  public FileLineSpliteratorParr(LinkedBlockingQueue<Optional<String>> linkedBlockingQueue,
      FileLineSpliterator<T> fileLineSpliterator) {
    this.linkedBlockingQueue = linkedBlockingQueue;
    this.fileLineSpliterator = fileLineSpliterator;

  }


  @SneakyThrows
  @Override
  public boolean tryAdvance(Consumer action) {
    return getData(action, linkedBlockingQueue, fileLineSpliterator);

  }

  public static <T> boolean getData(Consumer<String> action,
      LinkedBlockingQueue<Optional<String>> linkedBlockingQueue,
      FileLineSpliterator<T> fileLineSpliterator)
      throws InterruptedException {
    while (true) {
      Optional<String> data = linkedBlockingQueue.poll(
          FileLineSpliterator.getLOOP_PULL_TIMEOUT_MILLISECONDS(), TimeUnit.MILLISECONDS);
      if (Objects.isNull(data)) {
        if (fileLineSpliterator.getCOMPLETED_FLAG()) {
          return false;
        } else {
          continue;
        }
      }
      if (data.isPresent()) {
        fileLineSpliterator.getDataCount().incrementAndGet();
        action.accept(data.get());
      } else {
        action.accept(null);
      }
      return true;
    }
  }

  @Override
  public Spliterator trySplit() {
    return null;
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

    