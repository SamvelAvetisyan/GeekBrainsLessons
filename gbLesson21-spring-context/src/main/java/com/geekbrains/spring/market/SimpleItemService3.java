package com.geekbrains.spring.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleItemService3 {//1)пользователь не напрямую общается с SimpleItemRepository
    //а через Service
    //2) итемы лежат в репозитории, то есть для работы сервиса ему нужен репозитория

    //@Autowired//3-1) 1 вариант инджекшена через поле (не рекомендуется)
    private SimpleItemRepository2 simpleItemRepository2;
//3)мы говорим спрингу что нужен компонент но он должен ссылаться на другой компонент который имеет
    // тип SimpleItemRepository2. ТУТ и нужен инджекшн, то есть внедрять зависимость. Есть 3 Варианта

    @Autowired//3-2) 2 вариант инджекшена через сеттер
    public void setSimpleItemRepository2(SimpleItemRepository2 simpleItemRepository2) {
        this.simpleItemRepository2 = simpleItemRepository2;
    }

//    @Autowired//3-3) 3 вариант инджекшена через конструктор
//    public SimpleItemService3(SimpleItemRepository2 simpleItemRepository2) {
//        this.simpleItemRepository2 = simpleItemRepository2;
//    }

    public List<SimpleItem1> getAllItems(){
        return simpleItemRepository2.getAllItems();
    }
}

