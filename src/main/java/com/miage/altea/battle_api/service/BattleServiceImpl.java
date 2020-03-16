package com.miage.altea.battle_api.service;


import com.miage.altea.battle_api.bo.Battle;
import com.miage.altea.battle_api.bo.BattlePokemon;
import com.miage.altea.battle_api.bo.BattleTrainer;
import com.miage.altea.battle_api.bo.PokemonType;
import com.miage.altea.battle_api.factory.BattlePokemonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BattleServiceImpl implements BattleService {

    @Autowired
    private final BattlePokemonFactory battlePokemonFactory;
    @Autowired
    TrainerTypeService trainerTypeService;
    
    public BattleServiceImpl(BattlePokemonFactory battlePokemonFactory) {
        this.battlePokemonFactory = battlePokemonFactory;
    }

    @Override
    public Battle createBattle(String trainerName, String opponentName) {
        var trainer = trainerTypeService.getTrainerType(trainerName);
        BattleTrainer bTrainer = new BattleTrainer(trainer.getName());
        List<BattlePokemon> lbpt = new ArrayList<>();
        trainer.getTeam().forEach(pokemonType -> {
            lbpt.add(battlePokemonFactory.createBattlePokemon(pokemonType, pokemonType.getLevel()));
        });
        bTrainer.setTeam(lbpt);

        var opponent = trainerTypeService.getTrainerType(opponentName);
        BattleTrainer bOpponent = new BattleTrainer(opponent.getName());
        List<BattlePokemon> lbpo = new ArrayList<>();
        opponent.getTeam().forEach(pokemonType -> {
            lbpo.add(battlePokemonFactory.createBattlePokemon(pokemonType, pokemonType.getLevel()));
        });
        bOpponent.setTeam(lbpo);

        return new Battle(UUID.randomUUID(),bTrainer, bOpponent);
    }

    @Override
    public List<Battle> getAllBattles() {
        return null;
    }
}
