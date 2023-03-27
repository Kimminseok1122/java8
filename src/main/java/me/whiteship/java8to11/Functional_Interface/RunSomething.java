package me.whiteship.java8to11.Functional_Interface;

@FunctionalInterface
//함수형 인터페이스를 정의할때는 이런 어노테이션을 선언해주면 좋음
public interface RunSomething {

    int doIt(int number);
    //abstract 생략 가능

    static void printName() {
        System.out.println("Keesun");
    }
    //public 키워드 생략가능

    default void printAge() {
        System.out.println("40");
    }
}
