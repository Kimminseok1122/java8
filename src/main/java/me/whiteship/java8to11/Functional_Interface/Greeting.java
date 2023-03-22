package me.whiteship.java8to11.Functional_Interface;

public class Greeting {

    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String hello(String name) {
        return "hello" + name;
    }

    public static String hi(String name) {
        return "hi" + name;
    }
}
