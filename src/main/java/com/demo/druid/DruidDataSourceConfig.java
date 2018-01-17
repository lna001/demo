package com.demo.druid;

import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.env.Environment;

/**
 * Created by user on 2018/1/17.
 * Druid的DataResource配置类
 */
@Configuration
@EnableTransactionManagement
public class DruidDataSourceConfig   implements EnvironmentAware {
     private RelaxedPropertyResolver propertyResolver;
     public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    }
}
