package optimisations.conversion;

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
http://blog.soat.fr/2012/11/java-performances-33-optimisation-de-code/
"Si vous souhaitez convertir une chaîne de caractère en primitif, il est préférable
d’utiliser la méthode parseX() des classes
Integer, Long, Float, Double et Boolean, où X est le nom de la classe, au lieu de la
méthode valueOf(), qui retourne une nouvelle instance.

Bien évidemment, si vous souhaitez obtenir un objet, vous devrez utiliser valueOf().
Néanmoins, il est bon de garder à l’esprit qu’une telle conversion est couteuse."
*/

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
public class Conversion {

public static final long MAX = 10_000_000;

/* retourne un stream "0","1","2",..."MAX" */
private static Stream<String> streamOfStrings() {
  return Stream.iterate(0,i->i+1)
                .map(i->""+i)
                .limit(MAX);
}

//@Benchmark
@Warmup(iterations = 2, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void avecValueOf() {

  streamOfStrings().forEach(string->{Integer.valueOf(string).intValue();});

}//fin avecStringConcat

//@Benchmark
@Warmup(iterations = 2, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void avecParseInt() {

  streamOfStrings().forEach(string->{Integer.parseInt(string);});

}//fin avecStringBuilder
}
