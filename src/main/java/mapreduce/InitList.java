package mapreduce;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;
import java.nio.charset.StandardCharsets;
import static java.lang.System.out;

public class InitList {

  public static Client clientFromLigne(String ligne) {
    String [] strings = ligne.split(",") ;

      return new Client(
        strings[0].trim(),
        strings[1].trim(),
        strings[2].trim(),
        strings[3].trim(),
        Type.valueOf(strings[4].trim()),
        Long.parseLong(strings[5].trim())
      );
  }

    static long montantFromLigne(String ligne) {
      String [] strings = ligne.split(",") ;

        return Long.parseLong(strings[5].trim());
    }

  public static List<Client> getClients() {

    List<Client> clients = null;

    Path path = Paths.get("/home/ubuntu/dev/meetup-streams/DATA3.txt");
    try(Stream<String> lignes = Files.lines(path,StandardCharsets.UTF_8);) {

      return lignes.map(string->InitList.clientFromLigne(string))
                      .filter(client -> Type.A.equals(client.getType()))
                      .collect(Collectors.toList());

    } catch(IOException e) {
      System.out.println(e);
      return null;
    }
  }
}
