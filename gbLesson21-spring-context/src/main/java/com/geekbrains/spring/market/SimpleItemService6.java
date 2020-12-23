package com.geekbrains.spring.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleItemService6 {
    private ItemRepository5 itemRepository5;

    @Autowired
    public void setItemRepository5(@Qualifier(value = "simpleItemDbRepository4") ItemRepository5 itemRepository5) {
        this.itemRepository5 = itemRepository5;//1)@Qualifier для уточнения какой бин нужно, если несколько классов имплементят один и тот же интерфейс
    }

    public List<SimpleItem1> getAllItems(){
        return itemRepository5.getAllItems();
    }
}
