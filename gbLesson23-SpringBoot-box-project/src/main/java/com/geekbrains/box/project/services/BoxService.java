package com.geekbrains.box.project.services;

import com.geekbrains.box.project.entities.Box;
import com.geekbrains.box.project.exceptions.ResourceNotFoundException;
import com.geekbrains.box.project.repositories.BoxRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//Service является прослойкой между репозиторий и другими спринг бинами.
@AllArgsConstructor//Lombok создаст конструкторы со всеми аргументами
public class BoxService {
    private BoxRepository boxRepository;

    public List<Box> getAllBoxes() {

        return boxRepository.findAll();
    }

    public long getBoxesCount() {

        return boxRepository.count();
    }

    public List<Box> getBoxesWithMaxSizeFiltering(Integer maxSize) {
        List<Box> out = boxRepository.findAll();
        if (maxSize == null) {
            return out;
        }
        out.removeIf(b -> b.getSize() > maxSize);
        return out;
    }//логика фильтрации

    public Box findById(Long id) {
        return boxRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    public Box saveOrUpdate(Box box) {
        return boxRepository.save(box);
    }

    public void removeById(Long id) {
        boxRepository.deleteById(id);
    }
}
