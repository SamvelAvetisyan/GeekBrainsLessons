package com.geekbrains.spring.market;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleItemDbRepository4 implements ItemRepository5 {
    @Override
    public List<SimpleItem1> getAllItems() {
    throw  new UnsupportedOperationException();
    }

    @Override
    public void addItem(SimpleItem1 item) {
    throw  new UnsupportedOperationException();
    }
}
