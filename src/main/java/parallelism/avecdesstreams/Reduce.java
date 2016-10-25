package parallelism.avecdesstreams;

import static java.lang.System.out;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.*;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
public class Reduce {

	static int MAX = 10_000_000;

	@Benchmark
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	public void sequentiel() {
		Random rnd = new Random();
		IntStream.generate(()->rnd.nextInt(10))
			.limit(MAX)
			.sum();
	}

	/*
ne fonctionne pas avec jmh ?
	java -jar target/benchmarks.jar -Djava.util.concurrent.ForkJoinPool.common.parallelism=1 */
	@Benchmark
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	public void parallel() {
    /*
ne fonctionne pas avec jmh ? */
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","1");
		ThreadLocalRandom tRnd = ThreadLocalRandom.current();
		IntStream.generate(()->tRnd.nextInt(10))
			.limit(MAX)
			.parallel()
			.sum();
	}

}
