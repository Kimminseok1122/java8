package me.whiteship.java8to11.Changed_Interface;

public interface Foo {

    void printName();

    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     * 같은 스펙을 잘 남겨야함
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    //스태틱 메소드 제공가능
    static void printAnything() {
        System.out.println("Foo");
    }

    String getName();
}
