package com.example.demo.mapper;

import com.example.demo.entity.ReceiveInfoEty;
import org.springframework.stereotype.Repository;

//接口接收相关
@Repository
public interface ReceiveInfoDao {
    public void save(ReceiveInfoEty a);
    public void updatePrintCntByID(int id);
    public void updatePrintCntByDocNO(String docNO);

    public String receiveCntAll();
    public String receiveCntCurrDay();
}
