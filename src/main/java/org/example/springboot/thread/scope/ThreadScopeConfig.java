package org.example.springboot.thread.scope;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreadScopeConfig {

    @Bean
    public static BeanFactoryPostProcessor postProcessor(){
        return new ThreadBeanFactoryPostProcessor();
    }
}
