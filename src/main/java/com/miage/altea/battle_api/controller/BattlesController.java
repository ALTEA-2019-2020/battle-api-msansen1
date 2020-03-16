package com.miage.altea.battle_api.controller;


import com.miage.altea.battle_api.bo.Battle;
import com.miage.altea.battle_api.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/battles", produces = MediaType.APPLICATION_JSON_VALUE)
public class BattlesController {

    @Autowired
    public BattleService battleService;

    @PostMapping(value = "/")
    Battle createBattle(@RequestParam String trainer, @RequestParam String opponent){
        return battleService.createBattle(trainer, opponent);
    }

    @GetMapping("/")
    public List<Battle> getAllBattles() {
        return battleService.getAllBattles();
    }
}
