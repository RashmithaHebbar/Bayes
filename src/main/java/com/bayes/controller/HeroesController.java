package com.bayes.controller;

import com.bayes.exception.ResourceNotFoundException;
import com.bayes.data.Abilities;
import com.bayes.data.Heroes;
import com.bayes.service.HeroesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/heroes")
public class HeroesController {

    @Autowired
    private HeroesService heroesService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Collection<Heroes> listHeroes() {
        return heroesService.listHeroes();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{heroesId}")
    public @ResponseBody Object getHeroesById(@PathVariable Long heroesId) {
        Heroes heroes = heroesService.findById(heroesId);
        if(heroes != null) {
            return heroes;
        }
        return new ResourceNotFoundException("Hero with Id " + heroesId + " does not exist");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{heroesId}/abilities")
    public Collection<Abilities> getHeroesAbilities(@PathVariable Long heroesId) {
        return heroesService.getHeroesAbilities(heroesId);
    }
}
