package com.bayes.get;

import com.bayes.data.Abilities;
import com.bayes.data.Heroes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

@Service
public class FromJson {

    public Collection<Heroes> HeroesList(String json) throws JSONException {
        Collection<Heroes> heroes = new Vector<>();
        JSONObject object = new JSONObject(json);
        object.getJSONArray("data").forEach(item -> {heroes.add(buildHeroes((JSONObject) item));});
        return heroes;
    }

    public Collection<Abilities> AbilitiesList(String json) {
        Collection<Abilities> abilities = new Vector<>();
        JSONObject object = new JSONObject(json);
        object.getJSONArray("data").forEach(item -> {abilities.add(buildAbilities((JSONObject) item)); });
        return abilities;
    }

    public Heroes buildHeroes(String json) throws JSONException {
        return buildHeroes(new JSONObject(json));
    }

    private Heroes buildHeroes(JSONObject jsonObject) throws JSONException {
        return new Heroes().setId(jsonObject.getLong("id"))
                .setName(jsonObject.getString("name"))
                .setReal_name(jsonObject.getString("real_name"))
                .setArmour(jsonObject.getInt("armour"))
                .setHealth(jsonObject.getInt("health"))
                .setShield(jsonObject.getInt("shield"));
    }

    public Abilities buildAbilities(String json) throws JSONException {
        return buildAbilities(new JSONObject(json));
    }

    private Abilities buildAbilities(JSONObject jsonObject) throws JSONException {
        return new Abilities().setId(jsonObject.getLong("id"))
                .setName(jsonObject.getString("name"))
                .setDescription(jsonObject.getString("description"))
                .setIs_ultimate(jsonObject.getBoolean("is_ultimate"));
    }

    public Map<Long, Long> buildHeroesAbilitiesList(String json) {
        Map<Long, Long> items = new HashMap<>();
        JSONObject obj = new JSONObject(json);
        JSONArray arr = obj.getJSONArray("data");
        arr.forEach(item -> {
            Long id = ((JSONObject) item).getLong("id");
            JSONObject hero = ((JSONObject) item).getJSONObject("hero");
            Long heroId = hero.getLong("id");
            items.put(id, heroId);
        });
        return items;
    }

}
