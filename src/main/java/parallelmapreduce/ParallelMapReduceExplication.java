package parallelmapreduce;

import mapreduce.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
import java.nio.charset.StandardCharsets;
import static java.lang.System.out;

public class ParallelMapReduceExplication {

  static Path path = Paths.get("/home/ubuntu/dev/meetup-streams/DATA3.txt");

  public static void main(String... args) {

    //2 threads
    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","1");

    try(Stream<String> lignes = Files.lines(path,StandardCharsets.UTF_8);) {

      Long l = lignes
        .limit(10)
        .peek(ligne -> out.println("ligne: " + ligne))
        .parallel()
        .map(string->InitList.clientFromLigne(string))
        .filter(client -> Type.A.equals(client.getType()))
        .reduce(0L,
            (somme,client) ->
              {out.println(Thread.currentThread().getName() + " accumulates " + somme + " + " + client.getMontant());
              return somme + client.getMontant();},
            (somme1,somme2) ->
              {out.println(Thread.currentThread().getName() + " combines " + somme1 + " + " + somme2);
              return somme1 + somme2;});

      out.println(l);

    } catch(IOException e) {
      System.out.println(e);
    }

  }
}
