package com.geekbrains.spring.market;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.geekbrains.spring.market"}) //2)этот аннот.
// говорит спрингу ты должен искать бины в этом пакете
public class MarketConfig {//1)конфигурационный класс(@Configuration),
    // это те классы которые указывают спрингу как работать (класс настроек)
}
