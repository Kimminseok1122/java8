package me.whiteship.java8to11.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App2 {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        //'spring'으로 시작하는것이 있을 수 도 있고 없을 수도 있으니 Optional
        boolean present = optional.isPresent();
        //spring.isEmpty(); 자바 11 부터 이것도 제공
        //get()으로 꺼낼 수 있다. 이때 값이 있으면 괜찮은데 없으면 NoSuchelementException이 발생할 수 도 있다.
        //앞으로 나오는 메소드로 처리하고 get으로는 처리하지 않는것을 권장한다.
        //OnlineClass onlineClass = optional.get();
        //ifPresent를 써서 처리
        optional.ifPresent(oc -> System.out.println(oc.getTitle()));
        //onlineClass로 받고싶을때는 OnlineClass의 인스턴스를 넘겨줌
        //createNewClass는 조건에 상관없이 무조건 실행됨
        OnlineClass onlineClass = optional.orElse(createNewClass());
        //따라서 조건에 맞게 가져오고싶으면 다음과 같은걸 쓰자
        //해당 메소드는 Lazy한 계산을 하므로 무조건 호출되지 않음
        OnlineClass onlineClass1 = optional.orElseGet(App2::createNewClass);
        System.out.println(onlineClass1.getTitle());
        //뭔가를 만들어 줄 수 없는 상황일때는 orElseThrow
        //기본적으로 RuntimException이 던져지며 필요시 Supplier를 파라미터로 받는 메서드 사용
        OnlineClass onlineClass2 = optional.orElseThrow();
        //filter는 있다는 가정 하에 동작함 없을때는 아무것도 실행 x
        //filter기 때문에 Optional로 반환됨
        Optional<OnlineClass> onlineClass3 = optional.filter(oc -> oc.getId() > 10);
        //map도 사용가능 그때 담고있는 타입에 따라 다르게 나옴
        Optional<Integer> integer = optional.map(OnlineClass::getId);
        //Optional을 담고 있는것을 반환할때는 상당히 복잡하게 됨 이럴때는 flatMap을 사용
        Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = optional.flatMap(OnlineClass::getProgress);
        Progress progress2 = progress1.orElseThrow();
        //Stream의 flaMap과는 다름 Stream은 인풋이 하나이지만 아웃풋이 여러개인 상황에서 쓰임
    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10,"New Class", false);
    }
}
