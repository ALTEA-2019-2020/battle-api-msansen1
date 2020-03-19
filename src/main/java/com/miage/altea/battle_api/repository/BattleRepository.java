package com.miage.altea.battle_api.repository;

import com.miage.altea.battle_api.bo.Battle;
import com.miage.altea.battle_api.bo.BattleTrainer;
import com.miage.altea.battle_api.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BattleRepository {
    private Map<UUID, Battle> battles = new HashMap<>();

    @Autowired
    public BattleService battleService;


    public UUID createBattle(String trainer, String opponent){
        var newbattle = battleService.createBattle(trainer, opponent);
        battles.put(newbattle.getFirst(), newbattle.getSecond());
        return newbattle.getFirst();
    }

    public Optional<Battle> findBattle(UUID uuid){
        return Optional.ofNullable(battles.get(uuid));
    }

    public Optional<List<Battle>> findBattles() {
        if ( battles.size() == 0 )
            return Optional.empty();
        else return Optional.of(new ArrayList(battles.values()));
    }

    public ResponseEntity<Battle> updateBattle(UUID uuid, String playerName) throws Exception {
        Optional<Battle> battle = findBattle(uuid);
        if ( battle.isEmpty() ) return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED).body(null);
        Pair<Boolean, BattleTrainer> test = battle.get().isNextPlayer(playerName);
        if ( battle.isPresent() &&  test.getFirst() ){

            var updatedBattle= battle.get().doAttack(test.getSecond());
            return ResponseEntity.status(HttpStatus.OK).body(updatedBattle);
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }
}
