package mapreduce;

import mapreduce.InitList;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
import java.nio.charset.StandardCharsets;
import static java.lang.System.out;

public class MapReduce1 {

  static Path path = Paths.get("/home/ubuntu/dev/meetup-streams/DATA3.txt");

  public static void main(String... args) {

    try(Stream<String> lignes = Files.lines(path,StandardCharsets.UTF_8);) {

      Long l = lignes.map(string->InitList.clientFromLigne(string))
                     .filter((Client client) -> Type.A.equals(client.getType()))
                     .reduce(0L,
                        (somme,client) -> somme + client.getMontant(),
                        (somme1,somme2) -> somme1 + somme2);

      out.println(l);

    } catch(IOException e) {
      System.out.println(e);
    }

  }
}
