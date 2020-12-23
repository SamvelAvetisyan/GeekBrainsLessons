package com.geekbrains.spring.market;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component//1)при скане спринг создаст бин класса который отмечен @Component
public class SimpleItem1 {
    private Long id;
    private String title;

    @PostConstruct//1-1) означает что после создания бина проинициализирует по init
    public void init(){//1) мы можем бины настроить, скажем спрингу если бин создашь, дай начальное состояние
 id = 1L;
 title = "Box";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SimpleItem1() {
    }

    public SimpleItem1(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("id: %d, title: %s", id, title);
    }
}
