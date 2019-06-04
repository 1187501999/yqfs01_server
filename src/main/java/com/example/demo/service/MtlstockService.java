package com.example.demo.service;

import com.example.demo.entity.MtlstockEty;
import com.example.demo.entity.ReceiveInfoEty;
import com.example.demo.mapper.MtlstockDao;
import com.example.demo.mapper.PrintInfoDao;
import com.example.demo.mapper.ReceiveInfoDao;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MtlstockService {

    @Autowired
    private NOService noService;
    @Autowired
    private MtlstockDao mtlstockDao;
    @Autowired
    private ReceiveInfoDao receiveInfoDao;

    @Autowired
    private PrintInfoDao printInfoDao;

    /**
     * 计算，一共接收的次数，和今天接收的次数
     * @return
     */
    public Map computeReceiveCnt()
    {
        String cntAll = receiveInfoDao.receiveCntAll();
        String cntCurrDay = receiveInfoDao.receiveCntCurrDay() ;
        Map rtn = new HashMap();
        rtn.put("cntAll",cntAll) ;
        rtn.put("cntCurrDay",cntCurrDay) ;
        return rtn ;
    }

    public void saveBat() {
        String docNO = noService.getDcoNO(Constant.DOC_TYPE_D01);
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            MtlstockEty e = new MtlstockEty();
            e.setDocNO(docNO);
            e.setQty(new BigDecimal(i * 20));
            e.setMtlNO("Mxxx_" + i);

            list.add(e);
        }

        mtlstockDao.saveBat(list);

    }

    //行号补位
    private String getItemNO(int x) {
        String itemNO = null;
        x = x + 1;
        if (x < 10) {
            itemNO = "00" + x;
        } else if (x < 100) {
            itemNO = "0" + x;
        } else
            itemNO = "" + x;

        return itemNO;


    }

    public String saveBat(List list) {
        String docNO = noService.getDcoNO(Constant.DOC_TYPE_D01);
        if (list == null)
            list = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            MtlstockEty e = (MtlstockEty) list.get(i);
            e.setDocNO(docNO);
            e.setItemNO(getItemNO(i));
        }

        mtlstockDao.saveBat(list);


        ReceiveInfoEty riEty = new ReceiveInfoEty();
        riEty.setDocNO(docNO);
        receiveInfoDao.save(riEty);

        //ReceiveInfoEty 对象中的打印次数，加 1
//        PrintInfoEty printEty = new PrintInfoEty();
//        printEty.setDocNO(docNO);

//        printInfoDao.save(printEty);
        return docNO;
    }

    public List findDocByNO(String docNO)
    {
        return mtlstockDao.findDocByNO(docNO);
    }
}
