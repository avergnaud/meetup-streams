package cas1;

import static java.lang.System.out;
import java.util.stream.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.io.*;
import java.util.*;

public class TMP {

public static void main(String... args) throws IOException {

try (BufferedReader br = Files.newBufferedReader(Paths.get("/home/ubuntu/dev/meetup-streams/comptes-utf8.txt"));
	BufferedWriter bw = Files.newBufferedWriter(Paths.get("/home/ubuntu/dev/meetup-streams/DATA.txt"));) {

String line = null;
while((line = br.readLine()) != null) {

String[] tmp = line.split(",");
String toWrite = tmp[0].trim()+","+tmp[1].trim()+","+tmp[2].trim()+","+tmp[3].trim();
bw.write(toWrite);
bw.newLine();

}

}

}}
