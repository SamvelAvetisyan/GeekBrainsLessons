package com.geekbrains.calc.tests;

import com.geekbrains.calc.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class CalcTest {
    private Calculator calculator;

    @BeforeEach//1)говорит что этот метод будет отрабатывать перед каждым тестом
    public void init() {//2)для подготовки теста
        //    System.out.println("init");
        calculator = new Calculator();
    }

    @Test
    @Disabled("пока не надо проверять")
    public void subTest() {
        Assertions.assertEquals(1, calculator.sub(3, 2), "abc");
    }

    @Test
    public void mulTest() {
        Assertions.assertEquals(6, calculator.mul(3, 2), "abc");
    }

    @Test
    //3) @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void divTest() {
        Assertions.assertEquals(2, calculator.div(6, 3), "abc");
    }

    @Test
    public void divBy0Test() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.div(10, 0);
        });//4)если ожидаем Exception
    }

    @CsvSource({
            "5, 5, 10",
            "1, 1, 2",
            "4, 5, 9",
            "6, 7, 13",
            "0, 9, 9"
    })//набор (массив строк)
    @ParameterizedTest
//5)Когда тест использует набор данных, то есть нужно тестировать набор (тест является параметрическим)
    public void addTest(int a, int b, int result) {////5-1)junit понимает что до a=5,b=5,result=10....
        //каждая строка будет отдельный, независимый тест
        Assertions.assertEquals(result, calculator.add(a, b));
    }

    @MethodSource("dataForTest")//6) говорит что в ролы набора данных выступает какой-то метод
    @ParameterizedTest
    public void addTestWithArgumentsStream(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.add(a, b));
    }

    public static Stream<Arguments> dataForTest() {
        List<Arguments> out = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * 10);//случ. данные(0-10)
            int b = (int) (Math.random() * 10);
            int result = a + b;
            out.add(Arguments.arguments(a, b, result));
        }
        return out.stream();
    }

    @MethodSource("demoArgs")
    @ParameterizedTest
    public void demoTest(int[] arr, int resultSum, boolean isEqual) {
        Assertions.assertEquals(isEqual, calculator.sum(arr) == resultSum);
    }

    public static Stream<Arguments> demoArgs() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 5}, 8, true));
        out.add(Arguments.arguments(new int[]{3, 5, 8}, 5, false));
        out.add(Arguments.arguments(new int[]{2, 8, 5}, 15, true));

        return out.stream();
    }

    @Test
    public void assertAllDemo() {
        Assertions.assertAll(//7)для несколько проверок
                () -> {
                    Assertions.assertEquals(4, 2);
                },
                () -> {
                    Assertions.assertEquals(3, 3);
                }
        );
    }
}

