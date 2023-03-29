package me.whiteship.java8to11.Changed_Interface;

public interface Foo {

    //추상 메소드
    void printName();

    //어떤 구현체는 getName()이 null을 리턴할 수 있음 따라서 문서화를 잘 해야함.

    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    //스태틱 메소드 제공가능
    static void printAnything() {
        System.out.println("Foo");
    }

    String getName();

    //상수
    int testConstant = 100;

    //private 정적 메소드
    private static void addedJava9() {
        System.out.println("It added in Java9");
    }

    //private 인스턴스 메소드
    private void addedJava9_1() {

    }

    //Object에서 제공하는 toString은 재정의 불가능
//    default String toString() {
//        return "";
//    };
}
