package com.geekbrains.spring.testing;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BoxController {
    private BoxService boxService;

    @GetMapping//http://localhost:8189/app/
    public List<Box> findAllBoxes() {
        return boxService.findAll();
    }

    @GetMapping("/{id}")
    public Box findBoxById(@PathVariable Long id){
        return boxService.findById(id)
                .orElseThrow(()->new RuntimeException("Box with id" + id + " not found."));
    }
}
