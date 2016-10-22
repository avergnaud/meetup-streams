package memory;

import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class UsingList {

  /*TODO /home/ubuntu/dev/jdk1.8.0_72/bin>./jvisualvm*/

  static Path storexml = Paths.get("/home/ubuntu/dev/maaf/store.xml");
  static String lineToFind = "<generated.Agence stamp=\"e_151682\" id=\"d_65926\" op=\"update\" codeRegionMaaf=\"96 %\" mdate=\"1467387662231\"  />";

  public static void main(String... args) throws IOException {

    Console console = System.console();
    console.printf("GO?");
    if(console.readLine() != null) {
      //GO
      List<String> lignes = Files.readAllLines(storexml);
      for(String ligne : lignes) {
        if(ligne.contains(lineToFind)) {
          out.println("trouvé !");
        }
      }//fin for
    }//fin if(console...)
  }
}
