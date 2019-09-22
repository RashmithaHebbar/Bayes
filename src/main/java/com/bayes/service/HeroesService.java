package  com.bayes.service;

import com.bayes.data.Abilities;
import com.bayes.data.Heroes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;


@Service
public class HeroesService {

    @Autowired
    private OverwatchService overwatchService;

    public Collection<Heroes> listHeroes() {
        return overwatchService.listHeroes();
    }

    public Heroes findById(Long id) {
        return overwatchService.findById(id);
    }

    public Collection<Abilities> getHeroesAbilities(Long id) {
        return overwatchService.getHeroesAbilities(id);
    }

}