package me.whiteship.java8to11.Functional_Interface;

import java.util.function.*;

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

        //리턴이 없고 파라미터를 받기만하는것
        Consumer<Integer> printT = (i) -> System.out.println(i);
        //리턴받을 값의 타입을 정하는것 입력은 x
        Supplier<Integer> get10 = () -> 10;
        //True or False를 리턴해주는것, and Or 조합 가능
        Predicate<String> startsWithKeesun = (s) -> s.startsWith("keesun");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;
        //Function의 특수한 케이스 입력갑과 리턴값이 같을때 사용, Function을 상속받아 메소드 사용가능
        UnaryOperator<Integer> plus10_2 = (i) -> i + 10;

        //람다 표현식은 (인자) -> (바디)로 구성되어있다.
        //인자가 없을때는 ()으로
        //바디가 한줄이면 {} 생략가능
        Supplier<Integer> get10_test = () -> 10;
        //BiFunction<Integer,Integer,Integer>의 축약버전
        //(a,b)안에 타입도 선언가능하지만 컴파일러가 추론가능하기때문에 생략가능
        BinaryOperator<Integer>sum = (a, b) -> a + b;
        //변수 캡쳐
        Foo foo = new Foo();
        foo.run();
    }

    private void run() {

        //로컬 variable 자바8부터는 final키워드 생략가능한 경우가 있음
        //이 변수가 사실상 final일 경우(이 변수가 어디서도 변경되지 않는경우) 생략가능
        //effective final일때 참조가능
        int baseNumber = 10;

        //메소드 내부에 정의한 로컬클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); // 11이 찍힘 내부 Scope이 외부 Scope을 가림
            }
        }

        //익명클래스
        //로컬과 익명클래스는 shadowing이슈가 있음
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber); // 파라미터를 baseNumber로 바꾸면 바깥baseNumber를 참조하지 않음 파라미터를 그대로 씀
            }
        };

        //람다표현식
        //람다표현식은 run()메서드와 같은 scope를 가진다. 따라서 ()에 baseNumber를 쓸수 없다.
        //후에 baseNumber++ 된다면 컴파일 에러가 남
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }
}
