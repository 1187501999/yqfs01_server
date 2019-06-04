package com.example.demo.mapper;

import com.example.demo.entity.NOEty;
import org.springframework.stereotype.Repository;

import java.util.List;

//编号相关
@Repository
public interface NODao {

    public void save(NOEty a);
    public void update(NOEty a);
    public NOEty maxNOByType(String type) ;

}
