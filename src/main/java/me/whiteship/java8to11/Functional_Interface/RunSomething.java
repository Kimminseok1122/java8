package me.whiteship.java8to11.Functional_Interface;

@FunctionalInterface
//함수형 인터페이스를 정의할때는 이런 어노테이션을 선언해주면 좋음
public interface RunSomething {

    int doIt(int number);

    //abstract 생략 가능
    //추상메서드는 한개만 존재해야함
    //다른 메서드는 중요하지않음

    static void printName() {
        System.out.println("Keesun");
    }

    //public 키워드 생략가능

    default void printAge() {
        System.out.println("40");
    }

}
