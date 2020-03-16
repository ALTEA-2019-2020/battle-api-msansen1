package com.miage.altea.battle_api.service;


import com.miage.altea.battle_api.bo.TrainerType;

import java.util.List;

public interface TrainerTypeService {
    List<TrainerType> listTrainersTypes();

    TrainerType getTrainerType(String name);
}