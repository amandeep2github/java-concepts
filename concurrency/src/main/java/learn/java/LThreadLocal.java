package learn.java;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LThreadLocal {
    public static final int N_THREADS = 5;
    public static AtomicInteger ai = new AtomicInteger(0);
    public static ExecutorService exs = Executors.newFixedThreadPool(N_THREADS);
    public static void main(String[] args) throws InterruptedException {
        threadLocal();
        //inheritableThreadLocal();
    }

    public static void threadLocal() throws InterruptedException {
        ThreadLocal<String> tl = new ThreadLocal();
        CountDownLatch cdl = new CountDownLatch(N_THREADS);
        tl.set("Hello guys");
        System.out.printf("message %s thread %s\n", tl.get(), Thread.currentThread().getName());
        IntStream.rangeClosed(1, N_THREADS).forEach(ele->{
            exs.execute(()-> {System.out.printf("message %s thread %s\n", tl.get(), Thread.currentThread().getName());});
            System.out.println(ai.incrementAndGet());
            cdl.countDown();
        });
        cdl.await();
        System.out.println("### ---------- ###");
        System.out.println(ai.get());

    }

    public static void inheritableThreadLocal() throws InterruptedException {
        System.out.println("inheritableThreadLocal");
        ThreadLocal<String> tl = new InheritableThreadLocal<>();
        CountDownLatch cdl = new CountDownLatch(N_THREADS);
        tl.set("Hello guys");
        System.out.printf("message %s thread %s\n", tl.get(), Thread.currentThread().getName());
        IntStream.rangeClosed(1, N_THREADS).forEach(ele->{
            exs.execute(()-> {System.out.printf("message %s thread %s\n", tl.get(), Thread.currentThread().getName());});
            cdl.countDown();
        });
        cdl.await();
        System.out.println("### ---------- ###");

    }
}
