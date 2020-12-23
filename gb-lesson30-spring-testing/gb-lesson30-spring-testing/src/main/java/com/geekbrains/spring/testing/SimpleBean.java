package com.geekbrains.spring.testing;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleBean {
    private List<String> container;

    @PostConstruct
    public void init(){
        container = new ArrayList<>();
        container.add("A");
        container.add("B");
        container.add("C");
    }

    public void add(String value){
        container.add(value);
    }
    public int size(){
        return container.size();
    }
}
