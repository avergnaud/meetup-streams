package memory;

import static java.lang.System.out;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;

public class UsingStream {

  /*TODO /home/ubuntu/dev/jdk1.8.0_72/bin>./jvisualvm*/

  static Path storexml = Paths.get("/home/ubuntu/dev/maaf/store.xml");
  static String lineToFind = "<generated.Agence stamp=\"e_151682\" id=\"d_65926\" op=\"update\" codeRegionMaaf=\"96 %\" mdate=\"1467387662231\"  />";

  public static void main(String... args) throws IOException {

    Console console = System.console();
    console.printf("GO?");
    if(console.readLine() != null) {
      //GO
      Stream<String> lignes = Files.lines(storexml);
      lignes.filter(ligne->ligne.contains(lineToFind))
        .findFirst()
        .ifPresent((ligne)->out.println(ligne));


    }//fin if(console...)
  }
}
