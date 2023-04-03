package me.whiteship.java8to11.Changed_etc.annotation;


import java.util.Arrays;

@Chicken("양념")
@Chicken("마늘간장")
public class App {
    public static void main(String[] args) {

        //배열로 받는 방법
        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> System.out.println(c.value()));

        //컨테이너로 받는 방법
        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(ct -> ct.value());
    }
}
