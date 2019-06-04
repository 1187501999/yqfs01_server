package com.example.demo.entity;

import java.util.Date;
//根据类型取编号
public class NOEty {
    private int id ;
    private String docNO ;

    private String docType ;

    private Date cDate ;

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

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }
}
