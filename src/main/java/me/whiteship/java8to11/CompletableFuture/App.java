package me.whiteship.java8to11.CompletableFuture;

public class App {
    //현재 main 쓰레드
    public static void main(String[] args) {

//        MyThread myThread = new MyThread();
//        myThread.start();
//        System.out.println("Hello :" + Thread.currentThread().getName());

        //두번째 방법은 Runnable로 구현
        //자바8 이전에는 익명클래스 자바8 부터는 람다로 가능
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread" + Thread.currentThread().getName());
//            }
//        });
//        thread.start();
//
//        System.out.println("Hello :" + Thread.currentThread().getName());

        //쓰레드에서 알아둬야할 기능 세가지
        //1.thread.sleep 자는동안 자원이 다른쓰레드에 할당되서 메인쓰레드가 먼저 일을함 우선순위는 거의 무조건 메인이 옴
//        Thread thread = new Thread(() -> {
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                //누군가 깨우면 catch로 들어오게됨
//                e.printStackTrace();
//            }
//            System.out.println("Thread: " + Thread.currentThread().getName());
//        });

        //2. 자는 쓰레드를 깨울 수 있다.
        //깨우는 방법은 thread.interrupt()
//        Thread thread = new Thread(() -> {
//            int i = 0;
//            while (true) {
//                System.out.println("Thread: " + Thread.currentThread().getName());
//                System.out.println(i);
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    System.out.println("exit!");
//                    return ;
//                }
//                i++;
//            }
//        });
//
//        thread.start();
//        thread.sleep(3000L);
//        System.out.println("Hello :" + Thread.currentThread().getName());
//
//        thread.interrupt();


//        thread.start();
//        System.out.println("Hello :" + Thread.currentThread().getName());
//        Thread.sleep(3000L);

        //3. 기다릴 쓰레드에 join을 써서 메인쓰레드가 thread가 끝날때까지 기다림
        //join도 대기이기 때문에 InterruptedExcepion을 누가 발생시키면 끝나게 됨
        Thread thread = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        thread.start();

        System.out.println("Hello :" + Thread.currentThread().getName());
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread + " is finished");

        //그리고 쓰레드가 이게 문제인 부분이 쓰레드가 조금만 늘어나도 이렇게 복잡한데 수십 수백개는 직접관리가 사실상 힘듬
    }

    //쓰레드를 만드는법 1번째 불편한방법 -> 쓰레드를 상속 받는다.
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread: " +  Thread.currentThread().getName());
        }
    }
}
