package me.whiteship.java8to11.Changed_etc.annotation;

import java.util.Arrays;

@Chicken("양념")
@Chicken("마늘간장")
public class App {
    public static void main(String[] args) {
        //List<@Chicken String> names = Arrays.asList("keesun");
        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> {
            System.out.println(c.value());
        });

        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });
        //어노테이션을 가져오는 방법 두가지
    }

    /**
     * TypeVariable은 제네릭에서 사용되는 타입 변수를 의미합니다. 제네릭은 다양한 타입의 객체를 다루기 위해 사용되는 기능으로, 코드의 재사용성과 타입 안정성을 높일 수 있습니다.
     * <p>
     * 제네릭을 사용하면 클래스나 메서드에서 사용하는 타입을 선언할 수 있는데, 이때 타입 파라미터(type parameter)라는 것을 사용합니다. 이 타입 파라미터를 사용하여 클래스나 메서드를 작성하면, 해당 클래스나 메서드를 사용하는 곳에서 실제 타입을 전달하여 사용할 수 있습니다.
     * <p>
     * 예를 들어, 다음과 같이 제네릭을 사용하는 클래스를 작성할 수 있습니다.
     *
     * @param <T>
     */
    static class FellsLikeChicken<@Chicken("") T> {

        public static <@Chicken("") C> void print(@Chicken("") C c) {

        }
        /**
         * Type Parameter는 Generics(제네릭)에서 타입 안정성을 보장하기 위해 사용하는 개념입니다. 예를 들어, 위의 코드에서 <C>는 Type Parameter로, 메서드의 파라미터로 전달되는 객체의 타입을 지정하는 역할을 합니다. 이렇게 Type Parameter를 사용하면 컴파일러가 타입 안정성을 체크하고 컴파일 타임에 타입 에러를 확인할 수 있습니다. 또한, 제네릭을 사용하면 타입 변환에 따른 오류를 줄일 수 있어 코드의 가독성과 안정성을 높일 수 있습니다.
         */
    }
}
