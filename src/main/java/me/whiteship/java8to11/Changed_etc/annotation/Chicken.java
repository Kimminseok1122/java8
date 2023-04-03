package me.whiteship.java8to11.Changed_etc.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Retention은 어노테이션의 보존 정책을 지정하는 데 사용 즉, 어노테이션 정보를 언제까지 유지할 것인지 결정한다
//RetentionPolicy 열거형으로 다음 세 가지 값을 가짐
//SOURCE: 소스 파일에서만 유지되며, 클래스 파일에는 포함되지 않는다. 즉, 컴파일러가 소스 코드를 컴파일할 때만 필요한 정보를 포함하는데 사용된다.
//CLASS: 클래스 파일에는 포함되지만, 런타임 시에는 사용할 수 없다. 즉, 리플렉션을 사용해 클래스 파일에서 어노테이션 정보를 읽을 수 있지만, 프로그램이 런타임 시에 이 정보를 사용할 수는 없다.
//RUNTIME: 클래스 파일에 포함되며, 런타임 시에도 사용할 수 있다. 즉, 프로그램이 런타임 시에 어노테이션 정보를 사용할 수 있다.
@Target(ElementType.TYPE_USE)
//@Target은 어노테이션이 적용될 대상을 지정하는 데 사용한다. 만약 @Target을 생략하면 기본적으로 모든 대상에 적용된다.
//@Target 애너테이션은 어떤 요소(Element)에 애너테이션을 적용할 수 있는지를 지정하는데 사용한다. 다음과 같이 8가지 상수를 정의한다.
//CONSTRUCTOR: 생성자에 적용할 수 있다.
//FIELD: 필드 또는 변수에 적용할 수 있다.
//LOCAL_VARIABLE: 로컬 변수에 적용할 수 있다.
//METHOD: 메서드에 적용할 수 있다.
//PACKAGE: 패키지에 적용할 수 있다.
//PARAMETER: 매개변수에 적용할 수 있다.
//TYPE: 클래스, 인터페이스, 열거형 등 타입에 적용할 수 있다.
//TYPE_PARAMETER: 제네릭 타입 매개변수에 적용할 수 있다.
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    String value();
}
