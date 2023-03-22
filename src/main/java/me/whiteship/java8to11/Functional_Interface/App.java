package me.whiteship.java8to11.Functional_Interface;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        //지금까지 한것은 아래처럼 Lamda Expression으로 직접 구현한것
        Function<Integer, String> intToString = (i) -> "number";

        //스태틱 메소드 레퍼런스 사용방법
        UnaryOperator<String> hi = Greeting::hi;

        //인스턴스 메소드 레퍼런스 사용방법
        Greeting greeting = new Greeting();
        UnaryOperator<String> hi_1 = greeting::hello;

        //생성자는 입력값이 없고 Greeting이라는 결과를 가져오는것
        //이것 자체로는 아무것도 아닌것임
        Supplier<Greeting> newGreeting = Greeting::new;
        //이렇게 써야 Greeting을 온전히 가져올 수 있음
        Greeting greeting1 = newGreeting.get();

        Function<String, Greeting> runnable = Greeting::new;

        //Supplier랑 레퍼런스는 같지만 서로 다른 생성자를 참조함
        Function<String, Greeting> keesunGreeting = Greeting::new;
        Greeting keesun = keesunGreeting.apply("keesun");
        System.out.println(keesun.getName());

        //불특정 다수 Arrays.sort에서 new Compare형태의 익명클래스를 쓸수도 있지만
        //자바8 부터는 함수형 인터페이스로 바뀌어서 람다 사용가능
        //람다를 사용가능하다는것은 메소드 reference도 사용가능
        //임의객체의 인스턴스 메소드를 참조한것
        String[] names = {"keesun", "whiteship", "toby"};
        Arrays.sort(names,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }
}
