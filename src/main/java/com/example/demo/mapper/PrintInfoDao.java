package com.example.demo.mapper;

import com.example.demo.entity.PrintInfoEty;
import org.springframework.stereotype.Repository;

//打印相关
@Repository
public interface PrintInfoDao {
    public void save(PrintInfoEty a);
}
