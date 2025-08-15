package com.gyabisito.springboot;

import com.gyabisito.springboot.Dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    Dao dao;

    @Autowired
    Service(Dao dao){
        this.dao = dao;
    }
    public void save(){
        dao.create();
    }
}
