package com.example.demo.entity;

import com.example.demo.util.Constant;

import java.math.BigDecimal;
import java.util.Date;

//物料凭证行
public class MtlstockEty {
    private int id ;
    private String currYear ;
    private String currMonth ;

    private String currDay ;
    private String mtlNO ;
    private String mtlDesc ;
    private String docNO ;
    private BigDecimal price = Constant.ZERO;
    private BigDecimal qty = Constant.ZERO;
    private Date cDate ;
    private String itemNO ;

    public String getItemNO() {
        return itemNO;
    }

    public void setItemNO(String itemNO) {
        this.itemNO = itemNO;
    }

    public int getId() {
        return id;
    }

    public String getCurrDay() {
        return currDay;
    }

    public void setCurrDay(String currDay) {
        this.currDay = currDay;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrYear() {
        return currYear;
    }

    public void setCurrYear(String currYear) {
        this.currYear = currYear;
    }

    public String getCurrMonth() {
        return currMonth;
    }

    public void setCurrMonth(String currMonth) {
        this.currMonth = currMonth;
    }

    public String getMtlNO() {
        return mtlNO;
    }

    public void setMtlNO(String mtlNO) {
        this.mtlNO = mtlNO;
    }

    public String getMtlDesc() {
        return mtlDesc;
    }

    public void setMtlDesc(String mtlDesc) {
        this.mtlDesc = mtlDesc;
    }

    public String getDocNO() {
        return docNO;
    }

    public void setDocNO(String docNO) {
        this.docNO = docNO;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }
}
