package com.miage.altea.battle_api.bo;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class Battle {
    @NonNull
    UUID uuid;

    @NonNull
    BattleTrainer  trainer;

    @NonNull
    BattleTrainer opponent;

}
