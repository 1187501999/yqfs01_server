package com.example.demo.service;

import com.example.demo.entity.DayDetailMdl;
import com.example.demo.mapper.DocSelectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DocSelectService {

    @Autowired
    private DocSelectDao docSelectDao;
    //取记录总数
    public String findDayReceiveInfoTotal()
    {
        return docSelectDao.findDayReceiveInfoTotal();
    }

    public List findDayReceiveInfo(String pageIndex ,String pageSize ) {
        //limit #{currRow},#{pageSize}
        Map map = new HashMap();
        int a = Integer.parseInt(pageIndex);
        int b = Integer.parseInt(pageSize);

        map.put("pageIndex",(a-1)*b);
        map.put("pageSize",b);

        List list =  docSelectDao.findDayReceiveInfo(map);
        return list;
    }

    public List findDaySum() {
        return docSelectDao.findDaySum();
    }

    public List findMonSum() {
        DayDetailMdl tmp = new DayDetailMdl();
        tmp.setcDate("啥地方");

        List list = docSelectDao.findMonSum();

        return list ;
    }
}
