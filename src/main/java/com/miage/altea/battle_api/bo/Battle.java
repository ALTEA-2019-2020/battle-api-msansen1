package com.miage.altea.battle_api.bo;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
@Slf4j
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

    public Battle doAttack(BattleTrainer battleTrainer1) {
        System.out.println("Start Attack of "+ battleTrainer1.getName());

        BattleTrainer battleTrainer2 = opponent;
        if ( ! battleTrainer1.equals(trainer))
             battleTrainer2 = trainer;

        //Attaquant=Striker
        //Attaqué = Defender

        var pokemonStriker  = battleTrainer1.findNextPokemon().orElseThrow();
        var pokemonDefender = battleTrainer2.findNextPokemon().orElseThrow();

        log.info("Match opposant :"+ pokemonStriker.getType().getName() + " vs "+pokemonDefender.getType().getName());

        var degat = ( ( 2*pokemonStriker.getLevel()/5 + 2*pokemonStriker.getAttack()/pokemonDefender.getDefense()) + 2 );
        log.info("degats occasionnés: "+degat);
        pokemonDefender.setHp(pokemonDefender.getHp()-degat);
        if ( pokemonDefender.getHp() < 0){
            pokemonDefender.setHp(0);
            pokemonDefender.setKo(true);
            pokemonDefender.setAlive(false);
            log.info(pokemonDefender.getType().getName()+ "est KO !!!!!!!!!!!!!");
        }


        //On valide le tour et on donne la main au joueur suivant
        switchPlayerTurn();
        return this;
    }

    private void switchPlayerTurn() {
        this.trainer.setNextTurn(! this.trainer.getNextTurn());
        this.opponent.setNextTurn(! this.trainer.getNextTurn());
    }
}

