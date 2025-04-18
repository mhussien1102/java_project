
package shahd;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParallelMaximizer maximizer = new ParallelMaximizer();
        List<Integer> bigList = new LinkedList<>();
        
        /*Random rand = new Random();

        for (int i = 0; i < 10_000_000; i++) {
            bigList.add(rand.nextInt());
        }*/
        
        for (int i = 0; i < 10_000_000; i++) {
            bigList.add(i);
        }

        long start = System.currentTimeMillis();

        
        int max = maximizer.max(bigList, 2000);

        long end = System.currentTimeMillis();

        
        System.out.println("Maximum is: " + max);
        System.out.println("Time taken: " + (end - start) + " ms");
    }
}
