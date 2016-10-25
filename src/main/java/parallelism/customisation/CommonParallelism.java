package parallelism.customisation;

import java.util.stream.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


// 10 - (3 - 2)
// (10 - 3) - 2

public class CommonParallelism {
  public static void main(String... args) {

    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","1");

		ThreadLocalRandom tRnd = ThreadLocalRandom.current();
		LongStream.generate(()->tRnd.nextLong(10))
			.limit(1_000_000_000)
			.parallel()
			.sum();
  }
}
