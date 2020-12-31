package com.javabrains.springbootconfig.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Controller {

    @Value("${greeting.message}")
    public String greetings;

    @Value("${numbers.list}")
    private List<String> listOfNumber;

    @Value("#{${dbValues}}")
    private Map<String,String> dbValues;

    @Autowired
    private DbValues dataBaseValues;

    @RequestMapping("/greeting")
    public String greet(){
        return dataBaseValues.getConnection()+" "+dataBaseValues.getHost();
    }
}
