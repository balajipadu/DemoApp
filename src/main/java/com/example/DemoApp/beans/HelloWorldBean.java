package com.example.DemoApp.beans;

public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String helloWorldBean) {
        this.message = helloWorldBean;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
