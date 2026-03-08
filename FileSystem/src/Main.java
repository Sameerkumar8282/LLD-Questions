import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        ExecutorService pool = new ThreadPoolExecutor(
                2, 4, 3, TimeUnit.SECONDS,
                new SynchronousQueue<>());

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            try {

                pool.submit(() -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Task completed of " + finalI + " by " + Thread.currentThread().getName());
                });
            }catch (RejectedExecutionException e){
                System.out.println("Task rejected of " + finalI + " by " + Thread.currentThread().getName());
            }
        }

        pool.shutdown();
    }
}
