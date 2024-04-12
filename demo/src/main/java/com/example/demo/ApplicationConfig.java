package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {
    // Define a bean of type MyFirstClass
    @Bean("firstBean")
    @Qualifier("Bean1")
    public MyFirstClass myFirstClass() {
        // Instantiate and return a new instance of MyFirstClass
        return new MyFirstClass("This is first Bean with Qualifer -> Bean1");
    }

    // Define another bean of type MyFirstClass
    @Bean("secondBean")
    @Qualifier("Bean2")
    public MyFirstClass mySecondClass() {
        // Instantiate and return a new instance of MyFirstClass
        return new MyFirstClass("This is second Bean with Qualifer -> Bean2");
    }

    //This Bean will be available to dev profile only
    @Bean("secondBean")
    @Qualifier("Bean3")
    @Profile("dev")
    public MyFirstClass myThirdClass() {
        // Instantiate and return a new instance of MyFirstClass
        return new MyFirstClass("This is third Bean with Qualifer -> Bean3");
    }
}
