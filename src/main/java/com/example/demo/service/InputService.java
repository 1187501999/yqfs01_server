package com.example.demo.service;

import com.example.demo.entity.InputEty;
import com.example.demo.entity.OutputEty;
import com.example.demo.mapper.InputDao;
import com.example.demo.mapper.OutputDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//传入参数保存到日志表
@Service
public class InputService {
    @Autowired
    private InputDao inputDao;
    @Autowired
    private OutputDao outputDao;

    public void save(InputEty a) {
        inputDao.save(a);
    }

    public void save(OutputEty a) {
        outputDao.save(a);
    }

    public List findAllIn() {
        return inputDao.findAll();
    }

    public List findAllOut() {
        return outputDao.findAll();
    }

}
