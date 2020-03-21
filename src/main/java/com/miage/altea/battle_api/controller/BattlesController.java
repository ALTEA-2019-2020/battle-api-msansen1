package com.miage.altea.battle_api.controller;


import com.miage.altea.battle_api.bo.Battle;
import com.miage.altea.battle_api.repository.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value="/battles", produces = MediaType.APPLICATION_JSON_VALUE)
public class BattlesController {

    @Autowired
    public BattleRepository battleRepository;

    @PostMapping(value = "/")
    ResponseEntity<UUID> createBattle(@RequestParam String trainer, @RequestParam String opponent){
        return ResponseEntity.status(HttpStatus.OK).body(battleRepository.createBattle(trainer, opponent));
    }

    @GetMapping("/")
    ResponseEntity<List<Battle>> getAllBattles() {
        var battles = battleRepository.findBattles();
        if (battles.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        else return ResponseEntity.status(HttpStatus.OK).body(battles.get());
    }

    @GetMapping("/{uuid}")
    ResponseEntity<Battle> getBattle(@PathVariable UUID uuid) {
        var battle = battleRepository.findBattle(uuid);
        if (battle.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        else return ResponseEntity.status(HttpStatus.OK).body(battle.get());
    }

    @PostMapping("/{uuid}/{trainerName}/attack")
    ResponseEntity<Battle> updateBattle(@PathVariable UUID uuid, @PathVariable String trainerName) throws Exception {
        return battleRepository.updateBattle(uuid,trainerName);
    }
}
