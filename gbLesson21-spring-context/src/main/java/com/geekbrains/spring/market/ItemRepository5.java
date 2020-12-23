package com.geekbrains.spring.market;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


public interface ItemRepository5 {
     List<SimpleItem1> getAllItems();
     void addItem(SimpleItem1 item);
}
