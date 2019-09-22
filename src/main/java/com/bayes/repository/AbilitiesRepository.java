package com.bayes.repository;

import com.bayes.data.Abilities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilitiesRepository extends CrudRepository<Abilities, Long> {
}
