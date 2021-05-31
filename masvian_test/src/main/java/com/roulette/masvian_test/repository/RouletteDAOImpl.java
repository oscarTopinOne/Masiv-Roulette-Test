package com.roulette.masvian_test.repository;

import java.util.List;

import com.roulette.masvian_test.model.Roulette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RouletteDAOImpl implements RouletteDAO {

    @Autowired
    private RedisTemplate redisTemplate;
    private static final String KEY = "ROULETTE";

    public boolean saveRoulette (Roulette roulette) {
        try {
            redisTemplate.opsForHash().put(KEY, roulette.getId(), roulette);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Roulette> fetchAlluser() {
       List<Roulette> roulette;
       roulette = redisTemplate.opsForHash().values(KEY);
       return roulette;

    }

    @Override
    public boolean openingRouletteById(String id) {
        Roulette roulette;
        try{
            roulette = (Roulette) redisTemplate.opsForHash().get(KEY, Long.parseLong(id));
            if(roulette != null){
                return true;
            }else{
                return false;
            }
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }    
}
