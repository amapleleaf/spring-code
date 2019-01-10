package com.maple.learn.code;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.concurrent.atomic.AtomicInteger;

public class HelloWorldService implements BeanFactoryAware,BeanNameAware,BeanFactoryPostProcessor,BeanPostProcessor,InitializingBean ,ApplicationListener<ContextRefreshedEvent>,ApplicationContextAware {
    private String name;
    private AtomicInteger count = new AtomicInteger(1);
    private String getSeq(){
        return count.getAndIncrement()+"->";
    }
    public  HelloWorldService(){
        System.err.println(getSeq()+"HelloWorldService constructor");
    }
    public void initMethod(){
        System.err.println(getSeq()+"init method");
    }
    public void sayHello(){
        System.err.println(getSeq()+name+"say:hello,world");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setBeanName(String name) {
        System.err.println(getSeq()+"BeanNameAware.setBeanName:"+name);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.err.println(getSeq()+"BeanFactoryAware.setBeanFactory:"+beanFactory);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.err.println(getSeq()+"ApplicationContextAware.setApplicationContext:->"+applicationContext);
    }

    public void afterPropertiesSet() {
        System.err.println(getSeq()+"InitializingBean.afterPropertiesSet");
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("peopleService");
        beanDefinition.getPropertyValues();
        MutablePropertyValues m = beanDefinition.getPropertyValues();
        m.addPropertyValue("content", "i am ok");
        System.err.println(getSeq()+"BeanFactoryPostProcessor.postProcessBeanFactory 将peopleService的content属性修改为i am ok");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.err.println(getSeq()+"BeanPostProcessor.postProcessBeforeInitialization->"+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.err.println(getSeq()+"BeanPostProcessor.postProcessAfterInitialization->"+beanName);
        return bean;
    }

    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.err.println(getSeq()+"ApplicationListener.onApplicationEvent: Refreshed->"+event.getApplicationContext());
    }


}
