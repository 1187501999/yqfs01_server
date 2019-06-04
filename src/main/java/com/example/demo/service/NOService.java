package com.example.demo.service;

import com.example.demo.entity.NOEty;
import com.example.demo.mapper.NODao;
import com.example.demo.util.Constant;
import com.example.demo.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//编号服务
@Service
public class NOService {
    @Autowired
    private NODao d;

    //根据传入的docType取编号+1返回，没有返回默认值，并存入编号表中
    public String getDcoNO(String docType) {
        if (ObjectUtil.isNull(docType))
            docType = Constant.DOC_TYPE_D01;
        NOEty ety = d.maxNOByType(docType);
        String tmpNO = null ;
        if (ObjectUtil.isNull(ety)) {
            tmpNO = Constant.DOC_NO_BEGIN;
            ety = new NOEty();
        }
        else {
            tmpNO = ety.getDocNO();
        }
        Long noNew = Long.valueOf(tmpNO) + 1;

        ety.setDocType(docType);
        ety.setDocNO(noNew + "");
        if( ety.getId() !=0)
            d.update(ety);
        else
            d.save(ety);
        return ety.getDocNO();
    }
}
