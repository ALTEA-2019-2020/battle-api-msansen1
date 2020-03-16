package com.miage.altea.battle_api.service;

import org.springframework.stereotype.Service;

@Service
public class StatsCalculatorImpl implements StatsCalculator {
    @Override
    public int calculateHp(int base, int level) {
        return 10+level+(base*level/50);
    }

    @Override
    public int calculateStat(int base, int level) {
        return 5+(base*level/50);
    }
}
