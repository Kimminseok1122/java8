package me.whiteship.java8to11.Changed_Interface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

//        //for 보다 더 간결한 느낌
//        name.forEach(System.out::println);
//
//        //이것과 똑같은 기능
//        for (String s : name) {
//            System.out.println(name);
//        }

        //itertor과 같은느낌인 spliterator
        //Stream의 원리
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
//        while(spliterator.tryAdvance(System.out::println));
//        System.out.println("================================");
//        while(spliterator1.tryAdvance(System.out::println));

        //Stream
//        name.stream().map(String::toUpperCase)
//                .filter(s -> s.startsWith("K"))
//                .collect(Collectors.toSet());

        //조건에 따른 제거
//        name.removeIf(s -> s.startsWith("k"));
//        name.forEach(System.out::println);

        //비교
//        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
//        name.sort(compareToIgnoreCase.reversed().thenComparing(~~));

        //이렇게 Default메서드를 사용가능
        Foo foo = new DefaultFoo("keesun");
        foo.printName();
        foo.printNameUpperCase();

    }
}
