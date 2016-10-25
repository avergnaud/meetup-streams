package parallelmapreduce;

import mapreduce.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
import java.nio.charset.StandardCharsets;
import static java.lang.System.out;

public class ParallelMapReduce1 {

  static Path path = Paths.get("/home/ubuntu/dev/meetup-streams/DATA3.txt");

  public static void main(String... args) {

    try(Stream<String> lignes = Files.lines(path,StandardCharsets.UTF_8);) {

      Long l = lignes.parallel()
                     .map(string->InitList.clientFromLigne(string))
                     .filter(client -> Type.A.equals(client.getType()))
                     .reduce(0L,
                        (somme,client) -> somme + client.getMontant(),
                        (somme1,somme2) -> somme1 + somme2);
      out.println(l);

    } catch(IOException e) {
      System.out.println(e);
    }

  }
}
