package me.whiteship.java8to11.CompletableFuture;

import java.util.concurrent.*;

public class App2 {
    public static void main(String[] args) {

//        //쓰레드를 하나만 쓰는 Executor
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//        //가장 고전적인 방법
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread " + Thread.currentThread().getName() );
//            }
//        });
//
//
//        //이렇게 써도 됨
//        executorService.submit(() -> {
//            System.out.println("Thread " + Thread.currentThread().getName());
//        });
//
//        //ExecutorService는 작업이 끝난 후 다음 작업이 들어올 때까지 계속 대기하기 때문에 종료 문법이 필요
//        //greceFul shutdown으로써 하던 작업을 마치고 종료하는것
//        executorService.shutdown();
//
//        //하는 작업에 관계없이 종료하는것
//        executorService.shutdownNow();


        //일정 스케쥴에 따라 쓰레드를 실행시키고 싶을떄
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        //3초후 getRunnable("Hello") 실행
        executorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);

        //1초후 2초에 한번 getRunnable("Hello") 실행
        executorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);


    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
