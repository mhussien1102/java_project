
package shahd;

import java.util.LinkedList;

public class ParallelMaximizerWorker extends Thread {
    private LinkedList<Integer> list;
    private int partialMax = Integer.MIN_VALUE;

    public ParallelMaximizerWorker(LinkedList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            int number;
            synchronized (list) {
                if (list.isEmpty()) break;
                number = list.removeFirst();
            }
            partialMax = Math.max(partialMax, number);
        }
    }

    public int getPartialMax() {
        return partialMax;
    }
}
