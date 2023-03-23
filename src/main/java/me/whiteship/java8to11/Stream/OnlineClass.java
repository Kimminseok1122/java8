package me.whiteship.java8to11.Stream;

public class OnlineClass {

    private int id;
    private String title;
    private boolean close;

    public OnlineClass(int id, String title, boolean close) {
        this.id = id;
        this.title = title;
        this.close = close;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClose() {
        return close;
    }
}
