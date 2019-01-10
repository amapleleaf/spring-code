package com.maple.learn.code;

public class PeopleService{
    private String content="";
    public PeopleService(){
        System.err.println("PeopleService constructor");
    }
    public void say(){
        System.err.println("PeopleService say:["+content+"]");
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
