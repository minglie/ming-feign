package com.ming.feign.proxys;

import org.springframework.beans.factory.FactoryBean;

public class MyProxyFactory<T> implements FactoryBean<T> {
    private Class<T> interfaceClass;

    public Class<T> getInterfaceClass() {
        System.out.println("MyProxyFactory getInterfaceClass");
        return interfaceClass;
    }

    public void setInterfaceClass(Class<T> interfaceClass) {
        System.out.println("MyProxyFactory setInterfaceClass");
        this.interfaceClass = interfaceClass;
    }

    @Override
    public T getObject() throws Exception {
        return (T) JDKProxyCreator.createProxy(interfaceClass);
    }

    @Override
    public Class<?> getObjectType() {
        return interfaceClass;
    }

    @Override
    public boolean isSingleton() { // 单例模式
        return true;
    }
}