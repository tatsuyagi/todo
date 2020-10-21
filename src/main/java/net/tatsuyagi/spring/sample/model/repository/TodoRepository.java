package net.tatsuyagi.spring.sample.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.tatsuyagi.spring.sample.model.entity.Todo;

/**
 * TodoRepository.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}