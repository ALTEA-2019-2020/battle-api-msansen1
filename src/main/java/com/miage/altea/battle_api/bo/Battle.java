package com.miage.altea.battle_api.bo;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.util.Pair;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
public class Battle {
    UUID uuid;

    BattleTrainer  trainer;

    BattleTrainer opponent;

    public Battle( UUID uuid,  BattleTrainer trainer,  BattleTrainer opponent) {
        this.uuid = uuid;
        this.trainer = trainer;
        this.opponent = opponent;

        this.trainer.setNextTurn(trainer.getTeam().get(0).getSpeed() > opponent.getTeam().get(0).getSpeed());
        this.opponent.setNextTurn(! this.trainer.getNextTurn());
    }

    public Pair<Boolean,BattleTrainer> isNextPlayer(String playerName) {
        var player= opponent;
        if ( trainer.getName().equals(playerName) ){
            player = trainer;
        }
        if ( player.getNextTurn() )
            return Pair.of(true, player);
        else return Pair.of(false, player);

    }

    public Battle doAttack(BattleTrainer battleTrainer) {
        System.out.println("Start Attack of "+ battleTrainer.getName());
        //On valide le tour et on donne la main au joueur suivant
        switchPlayerTurn();
        return this;
    }

    private void switchPlayerTurn() {
        this.trainer.setNextTurn(! this.trainer.getNextTurn());
        this.opponent.setNextTurn(! this.trainer.getNextTurn());
    }
}

