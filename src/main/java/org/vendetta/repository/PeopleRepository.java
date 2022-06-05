package org.vendetta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vendetta.entity.PeopleEntity;

@Repository
public interface PeopleRepository extends JpaRepository<PeopleEntity, Long> {

}
