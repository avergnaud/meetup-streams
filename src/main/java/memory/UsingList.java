package memory;

import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class UsingList {

  /*TODO /home/ubuntu/dev/jdk1.8.0_72/bin>./jvisualvm*/

  static Path csv = Paths.get("/home/ubuntu/dev/meetup-streams/xaa.csv");
  static String lineToFind = "588017720639226266,167.2833,40.87156,22.5547618865967,22.1021499633789,21.5839786529541,20.8711929321289,20.844841003418";

  public static void main(String... args) throws IOException {

    Console console = System.console();
    console.printf("GO?");
    if(console.readLine() != null) {
      //GO
      List<String> lignes = Files.readAllLines(csv);
      for(String ligne : lignes) {
        if(ligne.contains(lineToFind)) {
          out.println("trouvé !");
        }
      }//fin for
    }//fin if(console...)
  }
}
