package simple;

import static java.lang.System.out;

import java.util.stream.IntStream;
import java.util.function.*;
import java.util.*;

public class RappelLambda {
  public static void main(String... args) {

List<Integer> liste = new ArrayList<>();
for(int i=0;i<10;i++) {
  liste.add(i);
}

/*---------------------------------------------------------------------------------------*/out.println();
    for(Integer i : liste) {
      out.print(i);
    }

/*---------------------------------------------------------------------------------------*/out.println();
    Consumer<Integer> integerConsumer = new Consumer<Integer>() {
      public void accept(Integer j) {
        out.print(j);
      }
    };
    for(Integer i : liste) {
      integerConsumer.accept(i);
    }

/*---------------------------------------------------------------------------------------*/out.println();
    integerConsumer = (Integer j) -> {out.print(j);};
    for(Integer i : liste) {
      integerConsumer.accept(i);
    }

/*---------------------------------------------------------------------------------------*/out.println();
    integerConsumer = j -> out.print(j);
    for(Integer i : liste) {
      integerConsumer.accept(i);
    }

/*---------------------------------------------------------------------------------------*/out.println();
    integerConsumer = j -> out.print(j);
    liste.stream()
      .forEach(integerConsumer);

/*
http://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html#forEach-java.util.function.Consumer-
*/
/*---------------------------------------------------------------------------------------*/out.println();
    liste.stream()
      .forEach(j -> out.print(j));

/*---------------------------------------------------------------------------------------*/out.println();
    liste.forEach(j -> out.print(j));

/*---------------------------------------------------------------------------------------*/out.println();
    liste.forEach(out::print);

/*---------------------------------------------------------------------------------------*/out.println();
    liste = new ArrayList<>();
    for(int i=0;i<10;i++) {
      liste.add(i);
    }
    for(Integer i : liste) {
      out.print(i);
    }

/*---------------------------------------------------------------------------------------*/out.println();
    IntStream.range(0,10)
      .forEach(out::print);

out.println();
  }
}
