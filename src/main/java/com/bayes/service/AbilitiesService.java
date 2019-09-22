package com.bayes.service;

import com.bayes.data.Abilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AbilitiesService {

    @Autowired
    private OverwatchService overwatchService;

    public Collection<Abilities> listAbilities() {
        return overwatchService.listAbilities();
    }

    public Abilities findById(Long id) {
        return overwatchService.findAbilityById(id);
    }
}