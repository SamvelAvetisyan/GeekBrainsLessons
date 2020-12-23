package com.geekbrains.box.project.controllers;

import com.geekbrains.box.project.entities.Box;
import com.geekbrains.box.project.services.BoxService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoxController {
    private BoxService boxService;

    @GetMapping("/all")//http://localhost:8189/app/all
    public String showDemo(Model model, @RequestParam(required = false) Integer maxSize) {//для фильтра
        model.addAttribute("boxes", boxService.getBoxesWithMaxSizeFiltering(maxSize));//from BoxService
        return "boxes-page";
    }

    @PostMapping("/boxes/add")//обработчик для добавления box-a
    public String addNewBox(@ModelAttribute Box box) {//Spring сама добавит атрибуты в Box box(color, size)
        boxService.saveOrUpdate(box);//from BoxService
        return "redirect:/all";//перенаправили по адресу  http://localhost:8189/app/all
    }

    @GetMapping("/boxes/edit/{id}")//для редактирования
    public String showEditBoxForm(@PathVariable Long id, Model model) {
        model.addAttribute("box", boxService.findById(id));//findById from BoxService
        return "box-edit-page";
    }

    @PostMapping("/boxes/edit")//для редактирования
    public String editBox(@ModelAttribute Box box) {
        boxService.saveOrUpdate(box);
        return "redirect:/all";
    }

    @GetMapping("/boxes/remove/{id}")//для удаления
    public String removeBoxById(@PathVariable Long id) {//{id} преобразует в Long и поставит как id
        boxService.removeById(id);//from BoxService
        return "redirect:/all";
    }
}
