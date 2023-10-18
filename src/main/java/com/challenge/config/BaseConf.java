package com.challenge.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = {"classpath:properties/environments/${environment}.properties", "classpath:properties/environments/default.properties"}, encoding = "UTF-8")
@ComponentScan(basePackages = "com.challenge")
public class BaseConf {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
