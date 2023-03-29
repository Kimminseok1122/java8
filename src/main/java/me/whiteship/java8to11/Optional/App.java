package me.whiteship.java8to11.Optional;

import java.time.Duration;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        //따라서 빈값이 전달될 수 있는곳에 Optional이라는것으로 감싸서 전달
        //Optional이라는 박스안에 담겨서 전달 해당 박스는 빈값일 수 도 있고 아닐수도 있음
        //.of 안의 값이 null이면 NPE발생함 .ofNullable을 쓰자.
        //Optional은 리턴값으로만 쓰는것을 권장한다.
        //만약 파라미터로 쓴다면 Optional이 제공해주는 값 체크 메서드를 통해 체크를 해야하는데
        //호출하는 쪽에서 의도적으로 파라미터에 null을 넣어줄 수 있다.
        //그렇게 된다면 null에 메서드를 쓰면 그 자체로 NPE이므로 더 복잡해진다. ex)추가적으로 NPE체크 로직이 드가야한다.
        //Map에 Key타입으로 Optional으로 써도 안된다. Map은 Key가 null이면 안된다는 특성을 깨뜨리게 된다.
        //인스턴스 필드 타입으로 써도 안좋다.
        //Primitive용 Optional은 따로 있음 그냥 Optional.of에 넣을 순 있지만, 넣을때 Boxing unBoxing이 일어난다.
        //결과적으로 성능 저하를 일으킴
//        Optional.of(10);
//        OptionalInt.of(10);
//        //null을 리턴하지 말고 차라리 Optional.empty()를 리턴
//        Optional.empty();
        //Collection, Map, Stream, Array, Optional은 Optional로 감싸지 말것 이미 null 체크 메커니즘을 보유하고있음
    }
}
