package com.roulette.masvian_test.repository;

import java.util.List;

import com.roulette.masvian_test.model.Roulette;

public interface RouletteDAO {

    boolean saveRoulette(Roulette roulette);
    List<Roulette> fetchAlluser();
    boolean openingRouletteById(String id);
}
