package somme;

import static java.lang.System.out;
import java.util.*;
import java.util.stream.*;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;

@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
public class Test2 {

    List<Boolean> cols;

    @Setup
    public void prepare(){
        cols= Stream
		.generate(()->Boolean.TRUE)
		.limit(10_000_000)
		.collect(Collectors.toList());
    }

//@Benchmark
@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void benchmark1() {

for(Boolean input : cols) {
	if(!input) {
		out.println("ko");
	}
}

}

//@Benchmark
@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void benchmark2() {

for(Boolean input : cols) {
	if(input == false) {
		out.println("ko");
	}
}

}
}
