package me.whiteship.java8to11.CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> keesun = () -> {
            Thread.sleep(1000L);
            return "Keesun";
        };

        //가장 빠른 작업물을 가져오는것 이때, invokeAny는 Blocking call이기 때문에 반환값이 Future가 아니다.
        String result = executorService.invokeAny(Arrays.asList(hello, java, keesun));

        System.out.println("result = " + result);

        executorService.shutdown();
    }
}
