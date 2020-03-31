package com.miage.altea.battle_api.service;

public interface StatsCalculator {

    int calculateHp(int base, int level);

    int calculateStat(int base, int level);
}
