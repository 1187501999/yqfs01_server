package com.example.demo.mapper;

import com.example.demo.entity.OutputEty;
import org.springframework.stereotype.Repository;

import java.util.List;

//返回相关
@Repository
public interface OutputDao {

    public void save(OutputEty a);
    public List<OutputEty> findAll();
}
