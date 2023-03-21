package me.whiteship.java8to11;

import java.util.function.Function;

public class Foo {

    public static void main(String[] args) {

        //자바 8 이전에는 익명 내부 클래스 anonymous inner class
        //단 두개이상일때는 아래 모양으로 써야함
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("Hello");
//                System.out.println("Hello2");
//            }
//        }
//        //Ramda형태의 표현식
//        RunSomething runSomething = () -> System.out.println("Hello");
//        runSomething.doIt();

//        //같은 값을 넣었을때 같은 결과가 나와야 함수형 프로그래밍임
//        RunSomething runSomething = (number) -> number + 10;

        //같은 값을 넣었을때 같지 않은 결과 퓨어한 함수가 아님
        //밖에있는 값은 참조만 하는것은 가능 단 baseNumber++ 같은건 안됨 final이라 가정하고 쓰는것
        //int baseNumber = 10;
        RunSomething runSomething = new RunSomething() {
            int baseNumber = 10;
            @Override
            public int doIt(int number) {
                baseNumber++;
                return number + baseNumber;
            }
        };

        //직접 클래스를 만듬
//        Plus10 plus10 = new Plus10();
//        System.out.println(plus10.apply(1));

        //위랑 같은 결과값이 나온다.
        Function<Integer, Integer> plus10_1 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        //함수가 두개 쓰인모습
        Function<Integer, Integer> multiply2AndPlus10 = plus10_1.compose(multiply2);
        Function<Integer, Integer> plus10AndMultiply2 = plus10_1.andThen(multiply2);

    }
}
