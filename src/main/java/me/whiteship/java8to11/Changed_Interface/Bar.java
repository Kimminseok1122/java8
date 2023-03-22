package me.whiteship.java8to11.Changed_Interface;

public interface Bar{

    //default 메소드를 제공하고싶지 않을때는 추상메서드로 선언해주자
//    @Override
//    void printNameUpperCase();
    default void printNameUpperCase() {
        System.out.println("BAR");
    }

}
