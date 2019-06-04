package com.example.demo.entity;

import java.util.Date;

//接收的信息 ，接收一次增加一条记录
public class ReceiveInfoEty {
    private int id ;
    //凭证号
    private String docNO ;
    //创建日期
    private Date cDate ;
    private int printCnt ;

    public int getPrintCnt() {
        return printCnt;
    }

    public void setPrintCnt(int printCnt) {
        this.printCnt = printCnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocNO() {
        return docNO;
    }

    public void setDocNO(String docNO) {
        this.docNO = docNO;
    }


    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

}
