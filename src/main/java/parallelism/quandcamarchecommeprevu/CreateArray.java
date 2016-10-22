package quandcamarchecommeprevu;

import static java.lang.System.out;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

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
public class CreateArray {

	//@Benchmark
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	public void avecSetAll() {
		int size = 20_000_000;
		int[] array = new int[size];
		Random rnd = new Random();
		Arrays.setAll(array, i-> rnd.nextInt(10));
	}

	//@Benchmark
	@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
	public void avecParallelSetAll() {
    out.println("combien de coeurs ? " + Runtime.getRuntime().availableProcessors());
    //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","2");
		int size = 20_000_000;
		int[] array = new int[size];
		ThreadLocalRandom tRnd = ThreadLocalRandom.current();
		Arrays.parallelSetAll(array, i-> tRnd.nextInt(10));
	}

}
