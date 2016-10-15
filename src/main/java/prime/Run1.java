package prime;

import static java.lang.System.out;
import java.util.stream.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.*;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
public class Run1 {

public static final long MAX = 1_000_000;

private boolean isPrime(long n) {
    return n > 1 && LongStream.rangeClosed(2, (long) Math.sqrt(n))
				.noneMatch(divisor -> n % divisor == 0);
}

@Benchmark
@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void sequential() {
	long l = LongStream.range(1, MAX)
		.filter(this::isPrime)
		.count();
	out.println("sequential stream result: " + l + " primes before " + MAX);
}

@Benchmark
@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void parallel() {
	long l = LongStream.range(1, MAX)
		.parallel()
		.filter(this::isPrime)
		.count();
	out.println("parallel stream result: " + l + " primes before " + MAX);
}
}
