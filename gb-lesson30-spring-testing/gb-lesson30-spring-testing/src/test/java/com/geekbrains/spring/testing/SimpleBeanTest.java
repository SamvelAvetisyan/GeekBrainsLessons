package com.geekbrains.spring.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleBeanTest {
    SimpleBean simpleBean;

    @Autowired
    public void setSimpleBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }

    @Test
    void simpleBenTest() {
        simpleBean.add("D");
        simpleBean.add("E");
        Assertions.assertEquals(5, simpleBean.size());
    }
}
