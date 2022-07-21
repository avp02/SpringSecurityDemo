package com.avp.springsecuritydemo.controller;

import com.avp.springsecuritydemo.model.Developer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestController {

    private List<Developer> developers = Stream.of(
      new Developer(1L, "Ivan", "Ivanov"),
      new Developer(2L, "Sergei", "Sergeev"),
      new Developer(3L, "Vova", "Vavanov")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll() {
        return developers;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable("id") Long id) {
        return developers.stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);

    }
}
