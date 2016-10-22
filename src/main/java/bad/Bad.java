package bad;

import java.util.stream.*;

public class Bad {
  public static void main(String... args) {
    long l = Stream.generate(()->"hello world").count();
  }
}
