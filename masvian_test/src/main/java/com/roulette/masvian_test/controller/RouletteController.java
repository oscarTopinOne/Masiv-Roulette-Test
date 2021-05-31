package com.roulette.masvian_test.controller;

import java.util.List;

import com.roulette.masvian_test.model.Roulette;
import com.roulette.masvian_test.services.RouletteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouletteController {
    @Autowired
    private RouletteService rouletteService;
    

    @PostMapping("/roulette")
    public ResponseEntity<Long> saveRoulette(@RequestBody Roulette roulette){
        boolean result = rouletteService.saveRoulette(roulette);
        if(result)
            return ResponseEntity.ok(roulette.getId());
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/roulette")
    public ResponseEntity<List<Roulette>> fetchAlluser(){
        List<Roulette> roulette;
        roulette = rouletteService.fetchAlluser();
        return ResponseEntity.ok(roulette);
    }

    @GetMapping("/roulette/{id}")
    public ResponseEntity<String> OpeningRouletteById(@PathVariable("id") String id) {
        boolean result = rouletteService.OpeningRouletteById(id);
        if(result)
            return ResponseEntity.ok("Roulette Opening");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    } 
}
