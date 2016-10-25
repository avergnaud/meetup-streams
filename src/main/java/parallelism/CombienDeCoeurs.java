package parallelism;

public class CombienDeCoeurs {
  public static void main(String... args) {
    System.out.println("combien de coeurs ? " +
      Runtime.getRuntime().availableProcessors());
  }
}
