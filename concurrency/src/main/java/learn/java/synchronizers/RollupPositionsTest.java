package learn.java.synchronizers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class RollupPositionsTest {

    public static void main(String[] args){
        //make instances of synchronizers to help for position logic
        Set<Position> syncPosSet = new HashSet<>();
        Lock syncPosLock = new ReentrantLock();
        Condition syncPosWaitCond = syncPosLock.newCondition();
        Condition syncPosSignalCond = syncPosLock.newCondition();

        //give those sync instances to rollup workers
        RollUpPositionWorker rollUpPosition1 = new RollUpPositionWorker(syncPosSet, syncPosLock, syncPosWaitCond, syncPosSignalCond);
        RollUpPositionWorker rollUpPosition2 = new RollUpPositionWorker(syncPosSet, syncPosLock, syncPosWaitCond, syncPosSignalCond);

        //simulate multiple sources triggering rollup
        ExecutorService es1 = Executors.newFixedThreadPool(5);
        ExecutorService es2 = Executors.newFixedThreadPool(5);
        ExecutorService es3 = Executors.newFixedThreadPool(5);

        //each source trigger rollup for pair Position{p=1, d=1}, Position{p=2, d=2} etc.
        //conflict will be for Position{p=2, d=2} and Position{p=5, d=5}
        IntStream.range(1, 3).forEach(ele->{
            es1.execute(()->rollUpPosition1.rollup(new Position(ele, ele)));
        });

        IntStream.range(2, 6).forEach(ele->{
            es2.execute(()->rollUpPosition2.rollup(new Position(ele, ele)));
        });
        IntStream.range(5, 6).forEach(ele->{
            es3.execute(()->rollUpPosition2.rollup(new Position(ele, ele)));
        });

        es1.shutdown();
        es2.shutdown();
        es3.shutdown();

    }

    /**
     *
     */
    static class RollUpPositionWorker {
        private Set<Position> syncPosSet;
        private Lock syncPosLock;
        private Condition syncPosWaitCond;
        private Condition syncPosSignalCond;

        public void rollup(Position pos) {
            checkAndWait(pos);

            System.out.printf("%s - rolling up\n", pos);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clearAndSignal(pos);
        }

        private void checkAndWait(Position pos) {
            syncPosLock.lock();
            while (syncPosSet.contains(pos)) {
                System.out.printf("%s - waiting\n", pos);
                try {
                    syncPosWaitCond.await(1000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //tell others rollup starting on pos
            syncPosSet.add(pos);
            syncPosLock.unlock();
        }

        private void clearAndSignal(Position pos) {
            syncPosLock.lock();
            //remove once rollup done on pos
            syncPosSet.remove(pos);
            syncPosSignalCond.signalAll();
            syncPosLock.unlock();
        }

        public RollUpPositionWorker(Set<Position> syncPosSet, Lock syncPosLock, Condition syncPosWaitCond, Condition syncPosSignalCond) {
            this.syncPosSet = syncPosSet;
            this.syncPosLock = syncPosLock;
            this.syncPosWaitCond = syncPosWaitCond;
            this.syncPosSignalCond = syncPosSignalCond;
        }
    }

    /**
     * domain class
     */
    static class Position {
        private int p;
        private int d;

        public Position(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return p == position.p &&
                    d == position.d;
        }

        @Override
        public int hashCode() {

            return Objects.hash(p, d);
        }

        @Override
        public String toString() {
            return "Position{" +
                    "p=" + p +
                    ", d=" + d +
                    '}';
        }
    }
}
