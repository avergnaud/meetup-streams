package cas1;

import static java.lang.System.out;
import java.util.stream.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.io.*;
import java.util.*;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.*;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
public class Run1 {

static Stream<String> getStream() throws IOException {
	return Files.lines(
		Paths.get("/home/ubuntu/dev/meetup-streams/DATA.txt"),
		StandardCharsets.UTF_8);
}

static boolean myPredicate(String ligne) {
	String[] ligneTable = ligne.split(",");
	return "02102801@MAAF.FR".equals(ligneTable[2]);
}

//@Benchmark
@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void sequential() throws IOException {
	Stream<String> stream = getStream();
	Optional<String> o = stream
		.filter(ligne->myPredicate(ligne))
		.findAny();

	o.ifPresent(out::println);
}

//@Benchmark
@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void parallel() throws IOException {
	Stream<String> stream = getStream().parallel();
	Optional<String> o = stream
		.filter(ligne->myPredicate(ligne))
		.findAny();

	o.ifPresent(out::println);
}
}
