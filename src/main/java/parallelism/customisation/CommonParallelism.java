package parallelism.customisation;

import java.util.stream.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CommonParallelism {
  public static void main(String... args) {
    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","0");
		ThreadLocalRandom tRnd = ThreadLocalRandom.current();
		LongStream.generate(()->tRnd.nextLong(10))
			.limit(1_000_000_000)
			.parallel()
			.sum();
  }
}
