package com.roulette.masvian_test.services;

import java.util.List;

import com.roulette.masvian_test.model.Roulette;
import com.roulette.masvian_test.repository.RouletteDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouletteServiceImpl implements RouletteService {

    @Autowired
    private RouletteDAO rouletteDao;

    @Override
    public boolean saveRoulette(Roulette roulette) {
        return rouletteDao.saveRoulette(roulette);
    }

    @Override
    public List<Roulette> fetchAlluser() {
        return rouletteDao.fetchAlluser();
    }

    @Override
    public boolean OpeningRouletteById(String id) {
        return rouletteDao.openingRouletteById(id);
    }   
}
