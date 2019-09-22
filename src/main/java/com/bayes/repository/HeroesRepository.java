package com.bayes.repository;

import com.bayes.data.Heroes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroesRepository extends CrudRepository<Heroes, Long> {
}
