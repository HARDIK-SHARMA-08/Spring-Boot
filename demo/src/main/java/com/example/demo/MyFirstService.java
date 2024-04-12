package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom2.properties")
})
public class MyFirstService {

    // Constructor Dependency Injection

    private final MyFirstClass firstClass;
    private MyFirstClass secondClass;
    private Environment environment;

    @Value("Hello from Hardik")
    private String customProperty;

    @Value("${my.application.property}")
    private String applicationProperty;

    @Value("${my.custom.property}")
    private String customPropertyFromAnotherFile;

    @Value("${my.custom2.property}")
    private String custom2PropertyFromAnotherFile;

    // Since there are multiple bean of type MyFirstClass so we are using Qualifier
    // to specify which bean should be used

    public MyFirstService(
            @Qualifier("Bean1") MyFirstClass firstClass,
            @Qualifier("Bean2") MyFirstClass secondClass,
            Environment environment) {
        this.firstClass = firstClass;
        this.secondClass = secondClass;
        this.environment = environment;
    }

    // Setter Dependency injection

    // private MyFirstClass firstClass;
    // private MyFirstClass secondClass;

    // private Environment environment;

    // @Autowired
    // public void setMyFirstClass(
    // @Qualifier("Bean1") MyFirstClass firstClass,
    // @Qualifier("Bean2") MyFirstClass secondClass) {
    // this.firstClass = firstClass;
    // this.secondClass = secondClass;
    // }

    // @Autowired
    // public void setEnvironment(Environment environment) {
    // this.environment = environment;
    // }

    public String tellStory() {
        return "This dependency is saying:: " + firstClass.helloWorld() + " :: " + secondClass.helloWorld();
    }

    public String JAVAversion() {
        return "The JAVA verion is:: " + environment.getProperty("java.version");
    }

    public String OSdetails() {
        return "The OS verion is:: " + environment.getProperty("os.name") + " :: "
                + environment.getProperty("os.version");
    }

    public String getApplicationProperty() {
        return "This is application Property from application.properties File:: " + applicationProperty;
    }

    public String getCustomProperty() {
        return "This is custom Property:: " + customProperty;
    }

    public String getCustomPropertyFromAnotherFile() {
        return "This is custom Property from custom.properties File:: " + customPropertyFromAnotherFile;
    }

    public String getCustom2PropertyFromAnotherFile() {
        return "This is custom2 Property from custom2.properties File:: " + custom2PropertyFromAnotherFile;
    }
}
