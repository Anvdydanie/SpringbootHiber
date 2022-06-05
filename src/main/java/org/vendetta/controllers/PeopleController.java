package org.vendetta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vendetta.entity.PeopleEntity;
import org.vendetta.services.PeopleService;

@RestController
@RequestMapping(path = "/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping
    public String index() {
        return "People are ready";
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PeopleEntity> getEntity(
        @PathVariable(name = "id") Long id
    ) {
        return peopleService.getById(id);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PeopleEntity> saveEntity(@RequestBody PeopleEntity entity) {
        return peopleService.saveNew(entity);
    }

}
