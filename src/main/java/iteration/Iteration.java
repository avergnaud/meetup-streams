package iteration;

import static java.lang.System.out;
import java.util.*;

/* exemple de code "déclaratif" */
public class Iteration {
  public static void main(String... args) {

    List<String> pizzas = Arrays.asList("CANNIBALE","HYPNOTIKA","BACON","CHICKENITA","INDIENNE");

    //itération externe
    for(String p : pizzas) {
      out.println(p);
    }

    //itération interne
    pizzas.forEach(out::println);
  }
}
