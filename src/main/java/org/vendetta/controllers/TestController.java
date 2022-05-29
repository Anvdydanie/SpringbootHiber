package org.vendetta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.vendetta.entity.TestEntity;
import org.vendetta.repository.TestRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    private final TestRepository testRepository;

    @Autowired
    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping
    public String index() {
        return "Test controller is ready";
    }

    @GetMapping("/get/{id}")
    public Optional<TestEntity> getEntity(
        @PathVariable(name = "id") Long id
    ) {
        return testRepository.findById(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TestEntity saveEntity(@RequestBody TestEntity entity) {
        return testRepository.save(entity);
    }

}
