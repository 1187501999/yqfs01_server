package com.example.demo.mapper;

import com.example.demo.entity.InputEty;
import org.springframework.stereotype.Repository;

import java.util.List;

//接收参数相关
@Repository
public interface InputDao {

    public void save( InputEty a);
    public List<InputEty> findAll();

}
