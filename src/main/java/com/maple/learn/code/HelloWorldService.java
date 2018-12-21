package com.maple.learn.code;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class HelloWorldService implements BeanFactoryAware,BeanNameAware,BeanFactoryPostProcessor,BeanPostProcessor,InitializingBean {
    private String name;
    public void sayHello(){
        System.err.println(name+"say:hello,world");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.err.println("BeanFactoryAware setBeanFactory:"+beanFactory);
    }

    public void setBeanName(String name) {
        System.err.println("BeanNameAware setBeanName:"+name);
    }

    public void afterPropertiesSet() throws Exception {
        System.err.println("InitializingBean afterPropertiesSet!");
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.err.println("BeanFactoryPostProcessor postProcessBeanFactory");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("BeanFactoryPostProcessor postProcessBeforeInitialization");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("BeanFactoryPostProcessor postProcessAfterInitialization");
        return bean;
    }
}
