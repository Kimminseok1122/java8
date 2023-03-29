package me.whiteship.java8to11.Stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App_2 {
    public static void main(String[] args) {
        //stream Api이란 연속된 데이터를 처리하는 operation의 모음;

        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

        //stream의 결과는 또다른 Stream임 안의 데이터를 바꾸지 않음
//        Stream<String> stringStream = names.stream().map(String::toUpperCase);
//        //저 안의 데이터는 그대로 남아있음
//        names.forEach(System.out::println);

        //map같은게 중계 오퍼레이션인데 중계 오퍼레이션은 Stream을 리턴하고
        //종료 오퍼레이션은 Stream을 리턴하지 않는다.
//        names.stream()
//                .map(s -> {
//                    System.out.println(s);
//                    return s.toUpperCase();
//                });
//
//        List<String> collect = names.stream()
//                .map(s -> {
//                    System.out.println(s);
//                    return s.toUpperCase();
//                })
//                .collect(Collectors.toList());
//
//        System.out.println("===================");
//
//        //이런 중계형 오퍼레이터는 위의 값이 출력되지 않는다. 종료 오퍼레이션이 와야 출력된다.
//        //이런의미의 중계형 오퍼레이터가 Lazy로 알아두면 좋다
//        collect.forEach(System.out::println);

        //이런 for작업은 병렬적으로 처리하기 어렵다.
        for (String name : names) {
            if (name.startsWith("k")) {
                System.out.println(name.toUpperCase());
            }
        }

        //Stream은 병렬적 처리가 가능하다.
        //단 병렬쳐리가 무조건 좋은것은 아님. 스레드가 만들어지고 스레드 컨텍스트 스위칭 비용 이런것이 더 나올 수 있음
        //병렬처리가 유용할때는 데이터가 정말 방대할때 클때만 유용
        List<String> collect = names.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("===spring 으로 시작하는 수업===");
        springClasses.stream().filter(oc -> oc.getTitle().startsWith("spring"));
        //현재 OnlineClass가 지나감 근데 변경하지 않았으므로 계속 데이터 타입은 OnlineClass
        //Stream을 반환하지않는 모든것이 다 종료 Stream

        System.out.println("===close 되지 않은 수업===");
        springClasses.stream().filter(Predicate.not(OnlineClass::isClose));
        // TODO

        //메서드 참조를 쓸때 !이 안되고 Predicate.not 을 쓰면 됨

        System.out.println("===수업 이름만 모아서 스트림 만들기===");
        springClasses.stream().map(OnlineClass::getTitle);
        // TODO

        //forEach에는 String 타입이 들어온다./

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);


        System.out.println("===두 수업 목록에 들어있는 모든 수업 아이디 출력===");
        // TODO
//        for (List<OnlineClass> keesunEvent : keesunEvents) {
//            keesunEvent.stream().map(s -> s.getTitle()).forEach(System.out::println);
//        }
        //땡땡땡 여기서는 flatMap을 이용해줘야했음


        System.out.println("===10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만===");
        // TODO


        System.out.println("===자바 수업 중에 Test가 들어있는 수업 확인===");
        // TODO
//        javaClasses.stream()
//                .map(OnlineClass::getTitle)
//                .filter(s -> s.contains("Test"))
//                .forEach(System.out::println);
        //anyMatch 를 쓰면됨

        //바로 boolean이 리턴됨

        System.out.println("===스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기===");
        // TODO
//        List<String> collect = keesunEvents.stream()
//                .flatMap(Collection::stream)
//                .map(OnlineClass::getTitle)
//                .collect(Collectors.toList());

        //순서를 바꾸면 결과가 달라진다.
        //예를들어 filter보다 map을 먼저하면 뒤에 오는것들은 String타입이 되어서 결과가 바뀐다.


    }
}
