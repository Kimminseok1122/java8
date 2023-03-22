package me.whiteship.java8to11.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        //stream Api이란 연속된 데이터를 처리하는 operation의 모음;

        List<String> names = new ArrayList<>();
        names.add("keesun");
        names.add("whiteship");
        names.add("toby");
        names.add("foo");

//        //stream의 결과는 또다른 Stream임 안의 데이터를 바꾸지 않음
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

//        //이런의미의 중계형 오퍼레이터가 Lazy로 알아두면 좋다
//        List<String> collect = names.stream()
//                .map(s -> {
//                    System.out.println(s);
//                    return s.toUpperCase();
//                })
//                .collect(Collectors.toList());
//
//        System.out.println("===================");
//        //이런 중계형 오퍼레이터는 위의 값이 출력되지 않는다. 종료 오퍼레이션이 와야 출력된다.
//        names.forEach(System.out::println);

        //이런 iter작업은 병렬적으로 처리하기 어렵다.
//        for (String name : names) {
//            if (name.startsWith("k")) {
//                System.out.println(name.toUpperCase());
//            }
//        }

        //Stream은 병렬적 처리가 가능하다.
        //단 병렬쳐리가 무조건 좋은것은 아님. 스레드가 만들어지고 스레드 컨텍스트 스위칭 비용 이런것이 더 나올 수 있음
        //병렬처리가 유용할때는 데이터가 정말 방대할때 클때만 유용
        List<String> collect = names.parallelStream().map(String::toUpperCase)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
