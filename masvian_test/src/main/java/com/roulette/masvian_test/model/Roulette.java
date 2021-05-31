package com.roulette.masvian_test.model;

import java.io.Serializable;

public class Roulette implements Serializable{
    

    private long id;
    private Boolean status;
    
    public Roulette() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
}