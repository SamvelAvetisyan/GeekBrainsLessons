package com.geekbrains.spring.market;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MarketConfig.class);//3 создается контекст
//SimpleItem1 item1 = context.getBean("simpleItem1", SimpleItem1.class);//4) у спринга запрашиваем SimpleItem, simpleItem1 имя бина
//SimpleItemRepository2 sitrep = context.getBean("simpleItemRepository2", SimpleItemRepository2.class);
 SimpleItemService6 simpleItemService6 = context.getBean("simpleItemService6", SimpleItemService6.class);
        System.out.println(simpleItemService6.getAllItems());

        context.close();
    }

}
