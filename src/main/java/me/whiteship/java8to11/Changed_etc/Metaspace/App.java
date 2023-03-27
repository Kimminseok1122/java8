package me.whiteship.java8to11.Changed_etc.Metaspace;

/**
 * Java에서 Garbage Collector는 Heap 메모리의 덩어리를 모니터링하며 더 이상 사용하지 않는 객체를 삭제하여 메모리를 해제합니다. 이 때 Heap 메모리는 크게 Young Generation과 Old Generation으로 나뉘어 관리됩니다.
 * <p>
 * Young Generation은 새로 생성된 객체들이 할당되는 영역으로, 대부분의 객체는 이곳에서 생성됩니다. Young Generation은 또한 세부적으로 Eden 영역, Survivor 영역 1, 2로 나뉘어집니다. 새로 생성된 객체들은 Eden 영역에 할당되고, 일정 시간이 지나면 그 중 일부는 Survivor 영역 1로 이동하며, 다시 일정 시간이 지나면 Survivor 영역 2로 이동하게 됩니다. 이 과정에서 일정 횟수 이상 살아남은 객체는 Old Generation으로 이동하게 됩니다.
 * <p>
 * Old Generation은 Young Generation보다 큰 객체들이 할당되는 영역입니다. 대부분의 객체는 Young Generation에서 수명을 다하고 삭제되지만, 일부는 계속해서 사용되고 유지됩니다. 이러한 객체들은 Old Generation에서 관리되며, Garbage Collector는 일정 주기마다 Old Generation에서 사용하지 않는 객체들을 삭제합니다.
 * <p>
 * 이러한 Young Generation과 Old Generation을 나누어 관리함으로써, Java Garbage Collector는 객체가 일시적으로 생성되고 일정 시간 이후에 삭제되는 경우에는 더 빠르게 메모리를 회수할 수 있습니다.
 */

/**
 * Java에서 Garbage Collector는 Heap 메모리를 관리합니다. Heap 메모리는 Young Generation, Old Generation 두 개의 영역으로 나뉘어지며, Young Generation 내부에서는 Eden 영역과 2개의 Survivor 영역으로 나뉘어집니다.
 * <p>
 * Young Generation 영역은 새로 생성된 객체가 저장되는 영역입니다. Eden 영역에 새로운 객체가 생성되면, 객체는 최초에는 Eden 영역에 저장되며, 일정 시간이 지나면, Young Generation 내부에서 객체들 간의 참조 관계를 분석하여 GC 대상인 객체를 찾아내고, 이를 Survivor 영역 중 하나로 이동시킵니다. 이 과정을 수행하는 것을 Minor GC 라고 합니다.
 * <p>
 * Old Generation 영역은 Young Generation 영역에서 살아남은 객체들이 이동되는 영역입니다. Young Generation에서 수행된 Minor GC가 반복되면서 객체들이 Old Generation 영역으로 이동하게 되며, Old Generation 영역에서는 Full GC를 수행하여 Garbage Collector가 제거하지 못한 객체를 제거합니다.
 * <p>
 * Minor GC는 Young Generation에서 수행되는 GC이고, Old Generation에서 수행되는 GC를 Major GC 라고 합니다. Full GC는 Heap 전체에서 수행되는 GC로, Old Generation, Young Generation 둘 다 제거하지 못한 객체를 제거합니다. Major GC와 Full GC는 Heap 전체에 대한 GC이므로 비용이 높고 실행 속도가 느립니다. 따라서 Java 애플리케이션에서는 Full GC가 발생하는 것을 최소화하기 위해 다양한 방법으로 GC 튜닝을 수행합니다.
 */
//PermGen 영역이 문제가 될 때는 Class로딩을 많이 하거나, 동적으로 Class를 많이 생성하는경우 PermGen영역이 문제가된다.
//PermGen사이즈를 늘리는것은 근본적인 해결책이 아님
// Java 8부터는 MetaSpace영역이 생겼음 Native 메모리 영역이다.
// 대부분의 상황에서 신경쓰지 않아도 되지만, MetaSpace가 필요한만큼 계속 늘어 나기 때문에 이런일이 발생하지 않나 모니터링 해야한다.
// MetaSpace의 초기사이즈와 MaxSize를 설정해주거나, 모니터링으로 적절한 값을 찾는것이 중요하다.
public class App {
}
