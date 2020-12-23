package com.geekbrains.spring.testing;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoxService {
    private BoxRepository boxRepository;

    public List<Box> findAll() {
        return boxRepository.findAll();
    }

    public Optional<Box> findById(Long id) {
        return boxRepository.findById(id);
    }

}
