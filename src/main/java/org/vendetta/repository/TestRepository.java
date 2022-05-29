package org.vendetta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vendetta.entity.TestEntity;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {

}
