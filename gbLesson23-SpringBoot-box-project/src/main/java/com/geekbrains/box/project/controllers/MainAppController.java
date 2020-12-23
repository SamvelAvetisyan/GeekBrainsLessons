package com.geekbrains.box.project.controllers;

import com.geekbrains.box.project.entities.Box;
import com.geekbrains.box.project.repositories.BoxRepository;
import com.geekbrains.box.project.services.BoxService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor//Lombok создаст конструкторы со всеми аргументами, и заинджектится зависимости
public class MainAppController {
  //private BoxRepository boxRepository;
    private BoxService boxService;

//    @Autowired
//    public MainAppController(BoxRepository boxRepository) {
//        this.boxRepository = boxRepository;
//    }//вместе этого подключили @AllArgsConstructor

    //http://localhost:8189/app/demo
    @GetMapping("/demo")
    @ResponseBody
    public List<Box> showDemo(){
    //return boxRepository.findAll();//1)вернем список наших коробок, до Service//findAll метод from Spring Data
        return boxService.getAllBoxes();//2)вернем список наших коробок, через Service
    }
}