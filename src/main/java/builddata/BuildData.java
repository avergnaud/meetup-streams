package builddata;

import static java.lang.System.out;
import java.io.*;
import java.nio.file.*;
import java.util.*;

enum TYPE {A,B}

public class BuildData {
  public static void main(String... args) {

    try(BufferedReader reader = Files.newBufferedReader(
          Paths.get("/home/ubuntu/dev/meetup-streams/DATA.txt"));
        BufferedWriter writer = Files.newBufferedWriter(
          Paths.get("/home/ubuntu/dev/meetup-streams/DATA2.txt"));) {

          Random random = new Random();

          String line;
          while((line = reader.readLine()) != null) {
            TYPE type = random.nextBoolean()?TYPE.A:TYPE.B;
            String output = line + "," + type + "," + random.nextInt(10);
            writer.write(output);
            writer.newLine();
          }

    } catch(IOException e) {out.println(e);}

  }
}
