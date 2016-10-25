package mapreduce;

import mapreduce.InitList;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
import java.nio.charset.StandardCharsets;
import static java.lang.System.out;

public class MapReduce2 {

  static Path path = Paths.get("/home/ubuntu/dev/meetup-streams/DATA3.txt");

  public static void main(String... args) {

    try(Stream<String> lignes = Files.lines(path,StandardCharsets.UTF_8);) {

      long l = lignes.map(string->InitList.clientFromLigne(string))
                     .filter(client -> Type.A.equals(client.getType()))
                     .mapToLong(client -> client.getMontant())
                     .sum();

      out.println(l);

    } catch(IOException e) {
      System.out.println(e);
    }

  }
}
