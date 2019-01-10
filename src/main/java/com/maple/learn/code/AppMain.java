package com.maple.learn.code;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.err.println("===============================================");
        HelloWorldService helloWorldService =  applicationContext.getBean("helloWorldService",HelloWorldService.class);
        helloWorldService.sayHello();

        PeopleService peopleService =  applicationContext.getBean("peopleService",PeopleService.class);
        peopleService.say();

    }
}
