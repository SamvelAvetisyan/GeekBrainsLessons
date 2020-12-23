package com.geekbrains.spring.testing;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ComplexBean {
    SimpleBean simpleBean;

    public int getSimpleBeanDoubleSize(){
        return simpleBean.size() * 2;
    }
}
