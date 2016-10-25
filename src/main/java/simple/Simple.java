package simple;

import static java.lang.System.out;

import java.util.stream.IntStream;

public class Simple {
  public static void main(String... args) {

    /*external iteration*/
    for(int i=0;i<10;i++) {
      out.print(i);
    }

out.println();

    /*internal iteration*/
    IntStream.range(0,10)
      .forEach(i -> out.print(i));

out.println();

  }
}
