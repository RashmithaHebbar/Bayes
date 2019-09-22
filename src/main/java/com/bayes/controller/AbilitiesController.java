package com.bayes.controller;

import com.bayes.exception.ResourceNotFoundException;
import com.bayes.data.Abilities;
import com.bayes.service.AbilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/abilities")
public class AbilitiesController {

    @Autowired
    private AbilitiesService abilitiesService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Abilities> listAbilities() {
        return abilitiesService.listAbilities();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{abilitiesId}")
    public @ResponseBody Object findById(@PathVariable Long abilitiesId) {
        Abilities abilities = abilitiesService.findById(abilitiesId);
        if(abilities != null) {
            return abilities;
        }
        return new ResourceNotFoundException("Ability with Id " + abilitiesId + " does not exist");
    }
}
