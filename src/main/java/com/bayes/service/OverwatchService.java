package com.bayes.service;

import com.bayes.data.Abilities;
import com.bayes.data.Heroes;
import com.bayes.get.FromHttp;
import com.bayes.get.FromJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;

@Service
public class OverwatchService {

    @Autowired
    private FromHttp fromHttp;

    @Autowired
    private FromJson fromJson;

    public Collection<Heroes> listHeroes() {
        try {
            String json = fromHttp.sendGet("https://overwatch-api.net/api/v1/hero/");
            return fromJson.HeroesList(json);
        } catch (Exception exception) {
            return new Vector<>();
        }
    }

    public Heroes findById(Long id) {
        try {
            String json = fromHttp.sendGet(String.format("https://overwatch-api.net/api/v1/hero/%d", id));
            return fromJson.buildHeroes(json);
        } catch (IOException e) {
            return null;
        }
    }

    public Collection<Abilities> getHeroesAbilities(Long id) {
        try {
            String json = fromHttp.sendGet("https://overwatch-api.net/api/v1/ability/");
            Map<Long, Long> items = fromJson.buildHeroesAbilitiesList(json);
            Collection<Abilities> abilities = new Vector<>();
            items.entrySet().stream().filter(p -> p.getValue().equals(id)).map(Map.Entry::getKey).collect(Collectors.toSet()).stream().forEach(p -> {
                Abilities ability = findAbilityById(p);
                abilities.add(ability);
            });
            return abilities;
        } catch (IOException e) {
            return null;
        }
    }

    public Collection<Abilities> listAbilities() {
        try {
            String json = fromHttp.sendGet("https://overwatch-api.net/api/v1/ability/");
            return fromJson.AbilitiesList(json);
        } catch (Exception exception) {
            return new Vector<>();
        }
    }

    public Abilities findAbilityById(Long id) {
        try {
            String json = fromHttp.sendGet(String.format("https://overwatch-api.net/api/v1/ability/%d", id));
            return fromJson.buildAbilities(json);
        } catch (IOException e) {
            return null;
        }

    }
}

