package memory;

import static java.lang.System.out;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;

public class UsingStream {

  /*TODO /home/ubuntu/dev/jdk1.8.0_72/bin>./jvisualvm*/

    static Path csv = Paths.get("/home/ubuntu/dev/meetup-streams/xaa.csv");
    static String lineToFind = "588017720639226266,167.2833,40.87156,22.5547618865967,22.1021499633789,21.5839786529541,20.8711929321289,20.844841003418";

  public static void main(String... args) throws IOException {

    Console console = System.console();
    console.printf("GO?");
    if(console.readLine() != null) {
      //GO
      Stream<String> lignes = Files.lines(csv);
      lignes.filter((String ligne)->{return ligne.contains(lineToFind);})
            .findFirst()
            .ifPresent((ligne)->out.println(ligne));


    }//fin if(console...)
  }
}
