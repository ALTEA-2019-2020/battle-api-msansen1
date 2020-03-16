package com.miage.altea.battle_api.factory;

import com.miage.altea.battle_api.bo.Battle;
import com.miage.altea.battle_api.bo.BattlePokemon;
import com.miage.altea.battle_api.bo.BattleTrainer;
import com.miage.altea.battle_api.bo.PokemonType;
import com.miage.altea.battle_api.service.StatsCalculator;
import com.miage.altea.battle_api.service.TrainerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BattlePokemonFactory {

    @Autowired
    StatsCalculator statsCalculator;


    public BattlePokemon createBattlePokemon(PokemonType pokemonType, int level) {
        BattlePokemon bp = new BattlePokemon(pokemonType);
        //TODO revenir sur calcul maxHp
        bp.setMaxhp(statsCalculator.calculateHp(pokemonType.getStats().getHp(),level));
        bp.setHp(statsCalculator.calculateHp(pokemonType.getStats().getHp(),level));
        bp.setSpeed(statsCalculator.calculateStat(pokemonType.getStats().getSpeed(),level));
        bp.setDefense(statsCalculator.calculateStat(pokemonType.getStats().getDefense(),level));
        bp.setAttack(statsCalculator.calculateStat(pokemonType.getStats().getAttack(),level));
        bp.setLevel(pokemonType.getLevel());

        return bp;
    }
}
