package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//凭证查询相关
@Repository
public interface DocSelectDao {

    public List findDayReceiveInfo(Map mapPara);
    //取记录总数
    public String findDayReceiveInfoTotal();

    public List findDaySum();

    public List findMonSum();
}
