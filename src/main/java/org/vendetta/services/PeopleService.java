package org.vendetta.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.vendetta.entity.PeopleEntity;
import org.vendetta.repository.PeopleRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public ResponseEntity<PeopleEntity> getById(Long id) {
        Optional<PeopleEntity> result = peopleRepository.findById(id);
        return result.map(
            peopleEntity -> new ResponseEntity<>(peopleEntity, HttpStatus.OK)
        ).orElseGet(
            () -> new ResponseEntity<>(HttpStatus.BAD_REQUEST)
        );
    }

    public ResponseEntity<PeopleEntity> saveNew(PeopleEntity entity) {
        Optional<PeopleEntity> result = peopleRepository.findById(entity.getId());
        return result.map(
            peopleEntity -> new ResponseEntity<>(peopleRepository.save(entity), HttpStatus.OK)
        ).orElseGet(
            () -> new ResponseEntity<>(HttpStatus.BAD_REQUEST)
        );
    }

}
