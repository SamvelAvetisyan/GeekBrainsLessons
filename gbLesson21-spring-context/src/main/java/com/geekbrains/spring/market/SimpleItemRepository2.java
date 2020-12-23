package com.geekbrains.spring.market;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class SimpleItemRepository2 implements ItemRepository5{//1)хранилище simpleItem1-ов
    private List<SimpleItem1> items;
    //2) хотим что при старте программы были какие-то айтимы

    @PostConstruct
    public void initialData() {//3)инициализация данных
        items = new ArrayList<>();
        items.add(new SimpleItem1(1L, "Box1"));
        items.add(new SimpleItem1(2L, "Box2"));
        items.add(new SimpleItem1(3L, "Box3"));
    }

    @Override
    public List<SimpleItem1> getAllItems() {//4)наш репозиторий может вернуть список объектов которые в нем есть
        return Collections.unmodifiableList(items);//4)возвращаем список (неизменяемый, чтобы не смогли напрямую менять наше хранилище)
    }
    @Override
    public void addItem(SimpleItem1 item){//5) метод добавляет item в items
        items.add(item);
    }
}

