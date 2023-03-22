package me.whiteship.java8to11.Changed_Interface;

public class DefaultFoo implements Foo, Bar{

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    //default메소드는 재 정의 가능 단, Object에서 제공하는 default메소드는 재정의 불가능
    //충돌하는 default메소드에는 직접 override해야함
    @Override
    public void printNameUpperCase() {
        System.out.println("ㅋㅋ");
    }

    //공통으로 제공해주면 좋은 기능이 갑자기 생기면
    //모든 인터페이스를 상속받은 클래스가 다시 구현해야함
    //Collection에서는 removeIf를 default 메서드로 갖고있음
    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
