package ThreadExamples;

import java.util.concurrent.*;

public class Callable_Test {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
//        callable();

//        cachedThread();

//        daemon();

//        interrupt();

//        execute_shutdown();

        submitCancel();
    }

    private static void submitCancel() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> future = executorService.submit(() -> {
            System.out.println("run");
        });
        future.cancel(true);
    }

    private static void execute_shutdown() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
        System.out.println("Main run");
    }

    private static void interrupt() {
        MyRunnable mr = new MyRunnable();
        Thread thread = new Thread(mr);
        thread.start();
        thread.interrupt();
    }

    private static void daemon() {
        Thread thread = new Thread(new MyRunnable());
        thread.setDaemon(true);
    }

    private static void cachedThread() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }

    private static void callable() throws InterruptedException, ExecutionException {
        MyCallabel mc = new MyCallabel();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}

class MyCallabel implements Callable<Integer>{
    public Integer call(){
        return 123;
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(123);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
