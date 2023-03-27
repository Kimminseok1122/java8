package me.whiteship.java8to11.Changed_etc.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)
//어노테이션을 중복해서 사용가능
//단 Container 어노테이션은 반드시 감싸는 어노테이션보다 범위가 넓거나 같아야함
//Chicken을 배열로 가지고 있으면 됨

/*
Annotation(애노테이션)은 자바 코드에 메타데이터(metadata)를 추가하는 방법 중 하나입니다. 즉, 프로그램 코드에 대한 데이터로, 컴파일러나 런타임에서 해석될 수 있습니다.

자바에서는 다양한 내장 Annotation을 제공하고 있으며, 사용자가 직접 Annotation을 정의하여 사용할 수도 있습니다. Annotation을 이용하면 다음과 같은 일을 할 수 있습니다.

컴파일러에게 코드 작성에 대한 정보를 제공하여 코드 분석이나 검증을 할 수 있도록 합니다.
런타임 환경에서 코드가 동작하는 방식을 제어합니다.
코드 분석 도구를 이용하여 문제점을 발견하거나 리팩토링하는데 도움을 줍니다

@Retention은 어노테이션의 보존 정책을 지정하는 데 사용됩니다. 즉, 어노테이션 정보를 언제까지 유지할 것인지 결정합니다. RetentionPolicy 열거형으로 세 가지 값을 가집니다.

SOURCE: 소스 파일에서만 유지되며, 클래스 파일에는 포함되지 않습니다. 즉, 컴파일러가 소스 코드를 컴파일할 때만 필요한 정보를 포함하는데 사용됩니다.
CLASS: 클래스 파일에는 포함되지만, 런타임 시에는 사용할 수 없습니다. 즉, 리플렉션을 사용해 클래스 파일에서 어노테이션 정보를 읽을 수 있지만, 프로그램이 런타임 시에 이 정보를 사용할 수는 없습니다.
RUNTIME: 클래스 파일에 포함되며, 런타임 시에도 사용할 수 있습니다. 즉, 프로그램이 런타임 시에 어노테이션 정보를 사용할 수 있습니다.
@Target은 어노테이션이 적용될 대상을 지정하는 데 사용됩니다. ElementType 열거형으로 여러 가지 값을 가질 수 있으며, 각 값은 어노테이션이 적용될 수 있는 대상을 의미합니다. 예를 들어, TYPE은 클래스, 인터페이스, 열거형을 의미하며, FIELD는 필드를 의미합니다. 여러 개의 값이 콤마로 구분될 수 있으며, 이 경우 어노테이션은 모든 대상에 적용됩니다. 만약 @Target을 생략하면 기본적으로 모든 대상에 적용됩니다.
@Target 애너테이션은 어떤 요소(Element)에 애너테이션을 적용할 수 있는지를 지정하는데 사용됩니다. ElementType 열거형 상수를 사용하여 적용할 수 있는 요소의 유형을 지정합니다. ElementType은 다음과 같이 8가지 상수를 정의합니다.

CONSTRUCTOR: 생성자에 적용할 수 있습니다.
FIELD: 필드 또는 변수에 적용할 수 있습니다.
LOCAL_VARIABLE: 로컬 변수에 적용할 수 있습니다.
METHOD: 메서드에 적용할 수 있습니다.
PACKAGE: 패키지에 적용할 수 있습니다.
PARAMETER: 매개변수에 적용할 수 있습니다.
TYPE: 클래스, 인터페이스, 열거형 등 타입에 적용할 수 있습니다.
TYPE_PARAMETER: 제네릭 타입 매개변수에 적용할 수 있습니다.
따라서, @Target(ElementType.TYPE)은 애너테이션을 클래스, 인터페이스, 열거형 등의 타입에만 적용할 수 있도록 지정합니다.
 */
public @interface Chicken {
    String value();
}
