package com.miage.altea.battle_api.bo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class TrainerType {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private List<PokemonType> team;

}
