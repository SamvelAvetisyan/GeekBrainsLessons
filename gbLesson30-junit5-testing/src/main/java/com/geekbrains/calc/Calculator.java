package com.geekbrains.calc;

import java.util.Arrays;

public class Calculator {
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }
    public int mul(int a, int b){
        return a*b;
    }
    public int div(int a, int b)  {
     //   Thread.sleep(2000L);
        return a/b;
    }
    public int sum(int[] arr){//метод вернет сумма эл. массива
        return Arrays.stream(arr).sum();
    }
}
