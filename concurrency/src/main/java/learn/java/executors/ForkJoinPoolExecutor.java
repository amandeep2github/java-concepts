package learn.java.executors;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ForkJoinPoolExecutor {
    private static final Logger LOGGER = Logger.getLogger(ForkJoinPoolExecutor.class.getName());

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        InputStream stream = ForkJoinPoolExecutor.class.getClassLoader().
                getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ForkJoinPool pool = new ForkJoinPool(4);
        Task task = new Task();
        List<String> listInt = createList();
        //all threads from ForkJoinPool
        ForkJoinTask<?> output = pool.submit(()-> listInt.parallelStream().forEach(str ->
            LOGGER.info(Thread.currentThread() +" - " +str)
        ));
        //main thread also used
        listInt.parallelStream().forEach(str ->{
            LOGGER.info(Thread.currentThread() +" - " +str);
        });
        output.get();
        LOGGER.info("done");
    }

    private static List<String> createList() {
        List<String> listInt = new ArrayList<>();
        listInt.add("1");
        listInt.add("2");
        listInt.add("3");
        listInt.add("4");
        return listInt;
    }
}
class Task implements Callable<String> {
    public String call() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return "Task Completed";
    }
}

