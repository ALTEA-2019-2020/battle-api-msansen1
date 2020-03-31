package com.miage.altea.battle_api.bo;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@RequiredArgsConstructor
public class BattleTrainer {

    @NonNull
    String name;

    @NonNull
    List<BattlePokemon> team;

    @NonNull
    Boolean nextTurn;

    public BattleTrainer(String trainerName) {
        this.name = trainerName;
    }

    public Optional<BattlePokemon> findNextPokemon() {
        return Optional.ofNullable(team.stream()
                .filter(battlePokemon -> battlePokemon.getKo().equals(Boolean.FALSE))
                .findFirst()
                .get()
        );
    }
}
