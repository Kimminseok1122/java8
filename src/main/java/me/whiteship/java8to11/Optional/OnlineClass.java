package me.whiteship.java8to11.Optional;

import java.util.Optional;

public class OnlineClass {

    private Integer id;
    private String title;
    private boolean close;
    public Progress progress;

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

    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClose(boolean close) {
        this.close = close;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
