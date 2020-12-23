package com.geekbrains.spring.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ComplexBeanTest {
    @Autowired
    private ComplexBean complexBean;

    @MockBean//взяли подделку
    private SimpleBean simpleBean;

    @Test
    public void findComplexBeanTest(){//тестируем ТОЛЬКО ComplexBean
        Mockito.doReturn(10)//должна вернуть 10, когда обращались simpleBean и вызвали метод size
                .when(simpleBean)
                .size();
        Assertions.assertEquals(20, complexBean.getSimpleBeanDoubleSize());
    }
}

