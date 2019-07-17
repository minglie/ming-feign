package com.ming.feign.proxys;


import com.ming.feign.ApiServer;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class MyRegistryBean implements ApplicationContextAware, BeanDefinitionRegistryPostProcessor {
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap();
    ApplicationContext ctx;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        String beanName = (String) ctx.getBeansWithAnnotation(SpringBootApplication.class).keySet().toArray()[0];
        Object beanName1 = ctx.getBeansWithAnnotation(SpringBootApplication.class).get(beanName);
        String packagename = beanName1.getClass().getPackage().getName();
        ResolverUtil<Class<?>> resolverUtil = new ResolverUtil();
        ResolverUtil<Class<?>> com = resolverUtil.findAnnotated(ApiServer.class, packagename);
        Set<Class<? extends Class<?>>> classes = com.getClasses();
        for (Class cz : classes) {
            Class<?> cls = cz;
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(cls);
            GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
            definition.getPropertyValues().add("interfaceClass", definition.getBeanClassName());
            definition.setBeanClass(MyProxyFactory.class);
            definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE); // 注册bean名,一般为类名首字母小写
            beanDefinitionRegistry.registerBeanDefinition(cz.getName(), definition);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}