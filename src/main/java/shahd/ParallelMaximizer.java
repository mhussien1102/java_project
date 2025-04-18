
package shahd;

import java.util.LinkedList;
import java.util.List;

public class ParallelMaximizer {

    public int max(List<Integer> inputList, int numThreads) throws InterruptedException {
        LinkedList<Integer> list = new LinkedList<>(inputList);
        List<ParallelMaximizerWorker> workers = new LinkedList<>();

        
        for (int i = 0; i < numThreads; i++) {
            ParallelMaximizerWorker worker = new ParallelMaximizerWorker(list);
            workers.add(worker);
            worker.start();
        }

        for (ParallelMaximizerWorker worker : workers) {
            worker.join();
        }

        LinkedList<Integer> partialMaxList = new LinkedList<>();
        for (ParallelMaximizerWorker worker : workers) {
            partialMaxList.add(worker.getPartialMax());
        }

        // المرحلة الثانية - 100 worker
        List<ParallelMaximizerWorker> secondPhaseWorkers = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            ParallelMaximizerWorker worker = new ParallelMaximizerWorker(partialMaxList);
            secondPhaseWorkers.add(worker);
            worker.start();
        }

        for (ParallelMaximizerWorker worker : secondPhaseWorkers) {
            worker.join();
        }

        int finalMax = Integer.MIN_VALUE;
        for (ParallelMaximizerWorker worker : secondPhaseWorkers) {
            finalMax = Math.max(finalMax, worker.getPartialMax());
        }

        return finalMax;
    }
}
