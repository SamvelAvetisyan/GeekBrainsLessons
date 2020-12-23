package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Box;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BoxRepository {
    private List<Box> boxes;

    @PostConstruct
    public void init() {
        boxes = new ArrayList<>();
        boxes.add(new Box(1L, "White", 5));
        boxes.add(new Box(2L, "Red", 15));
        boxes.add(new Box(3L, "Yellow", 25));
        boxes.add(new Box(4L, "Yellow", 22));
    }

    public List<Box> getAllBoxes() {
        return Collections.unmodifiableList(boxes);
    }

    public void save(Box box) {
        boxes.add(box);
    }
}
