package racecondition;

import java.util.concurrent.*;
import static java.lang.System.out;

class Counter {

static int MAX = 1_000_000;

static volatile int valeur;

static void inc() {
for(int i=0;i<MAX;i++)
	valeur++;
}
}

public class Inc {
public static void main(String... args) throws InterruptedException{

ExecutorService es = null;
try {

es = Executors.newCachedThreadPool();
for(int i=0;i<10;i++) {
es.execute(Counter::inc);
}

} finally {
if(es != null) es.shutdown();
}
es.awaitTermination(1,TimeUnit.MINUTES);

out.println(Counter.valeur);

}}
/*
/home/ubuntu/dev/git/avergnaud/meetup-streams/src/main/java>java racecondition.Inc
3141652
/home/ubuntu/dev/git/avergnaud/meetup-streams/src/main/java>java racecondition.Inc
3106583
/home/ubuntu/dev/git/avergnaud/meetup-streams/src/main/java>java racecondition.Inc
3314385
/home/ubuntu/dev/git/avergnaud/meetup-streams/src/main/java>java racecondition.Inc
3167911


*/
