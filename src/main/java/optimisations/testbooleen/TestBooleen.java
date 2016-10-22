package optimisations.testbooleen;

import static java.lang.System.out;
import java.util.stream.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.nio.charset.*;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.*;
/*
optimisation toujours valable en java 8 ?
*/

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
public class TestBooleen {

public static final long MAX = 10_000_000;

/* retourne un stream de Boolean */
private static Stream<Boolean> randomBooleans() {
  Random random = new Random();
  return Stream.generate(random::nextBoolean).limit(MAX);
}

//@Benchmark
@Warmup(iterations = 2, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void avecUnaryNot() {

  long l = randomBooleans().filter(leBooleen -> !leBooleen).count();
  out.println(l);

}//fin avecStringConcat

//@Benchmark
@Warmup(iterations = 2, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void avecBinaryNot() {

  long l = randomBooleans().filter(leBooleen -> leBooleen == false).count();
  out.println(l);

}//fin avecStringBuilder
}
