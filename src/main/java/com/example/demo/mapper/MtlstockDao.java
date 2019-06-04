package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

//库存记账相关
@Repository
public interface MtlstockDao {

    public void saveBat(List list);

    public List findDocByNO(String docNO);
}
