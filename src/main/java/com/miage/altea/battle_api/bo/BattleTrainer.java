package com.miage.altea.battle_api.bo;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

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
}
