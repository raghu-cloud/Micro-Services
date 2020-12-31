package com.javabrains.springbootconfig.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Controller {

    @Value("${greeting.message}")
    public String greetings;

    @Value("${app.name}")
    public String appName;

    @Value("${numbers.list}")
    private List<String> listOfNumber;

    @Autowired
    private DbValues dataBaseValues;

    @Autowired
    private Environment env;

    @RequestMapping("/greeting")
    public String greet(){
        return dataBaseValues.getConnection();
    }

    @RequestMapping("/getEnvDetails")
    public String envDetails(){
        return env.toString();
    }

}
