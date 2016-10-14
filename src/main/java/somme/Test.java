package somme;

import static java.lang.System.out;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;

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
public class Test {

//@Benchmark
@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void benchmarkSequential() {
	Path in = Paths.get("./src/main/java/in/leipzig1m.txt");
	try(Stream<String> s = Files.lines(in)) {
	long l = s.flatMap(ligne->Arrays.stream(ligne.split(" "))).collect(Collectors.counting());
	out.println(l);
	} catch(IOException e) {out.println(e);} 
}

//@Benchmark
@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void benchmarkParallel() {
Path in = Paths.get("./src/main/java/in/leipzig1m.txt");
try(Stream<String> s = Files.lines(in)) {
	long l = s.parallel().flatMap(ligne->Arrays.stream(ligne.split(" "))).collect(Collectors.counting());
out.println(l);
} catch(IOException e) {out.println(e);} 
}
}
