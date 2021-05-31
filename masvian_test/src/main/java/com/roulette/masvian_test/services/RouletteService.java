package com.roulette.masvian_test.services;

import java.util.List;

import com.roulette.masvian_test.model.Roulette;

public interface RouletteService {
    
    boolean saveRoulette(Roulette roulette);
    List<Roulette> fetchAlluser();
    boolean OpeningRouletteById(String id);
}
