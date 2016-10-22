package optimisations.concatenationavecstreams;

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
"Concaténer des chaînes de caractères est très simple en utilisant l’opérateur ‘+’ ( String.concat() ),
malheureusement il peut poser quelques problèmes en terme de performances [3].
Un objet de type String étant immuable, une nouvelle instance sera créée à chaque concaténation.

L’utilisation de l’opérateur ‘+’ doit donc être limitée à la concaténation de 2 ou 3 opérandes.
Dans tous les autres cas, il est conseillé d’utiliser un StringBuilder et ses méthodes append()."
*/

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
public class Concatenation {

public static final long MAX = 10_000;

private static final Path dickens = Paths.get("/home/ubuntu/dev/meetup-streams/dickens.txt");

//@Benchmark
@Warmup(iterations = 2, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void avecStringConcat() {

  try(Stream<String> streamDeMots = Files.lines(dickens)
        .flatMap(ligne -> Arrays.stream(ligne.split(" ")))
        .limit(MAX)) {

          streamDeMots.reduce("",
            String::concat,
            String::concat);







  } catch(IOException e) {out.println(e);}
}//fin avecStringConcat


//@Benchmark
@Warmup(iterations = 2, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public void avecStringBuilder() {

  try(Stream<String> streamDeMots = Files.lines(dickens)
        .flatMap(ligne -> Arrays.stream(ligne.split(" ")))
        .limit(MAX)) {

        streamDeMots.collect(StringBuilder::new,
            StringBuilder::append,
            StringBuilder::append);







  } catch(IOException e) {out.println(e);}
}//fin avecStringBuilder
}
