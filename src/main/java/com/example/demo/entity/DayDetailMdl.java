package com.example.demo.entity;

import java.math.BigDecimal;

public class DayDetailMdl {

    private String docNO ;//凭证号

    private String cDate = null;//日期
    private int mtlCnt;//物料品种数
    private BigDecimal sumQty;//数量和
    private int printCnt;//打印次数
    private int receiveCnt ;//接收次数

      public int getReceiveCnt() {
        return receiveCnt;
    }

    public void setReceiveCnt(int receiveCnt) {
        this.receiveCnt = receiveCnt;
    }

    public String getDocNO() {
        return docNO;
    }

    public void setDocNO(String docNO) {
        this.docNO = docNO;
    }

    public String getcDate() {
        return cDate;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public int getMtlCnt() {
        return mtlCnt;
    }

    public void setMtlCnt(int mtlCnt) {
        this.mtlCnt = mtlCnt;
    }

    public BigDecimal getSumQty() {
        return sumQty;
    }

    public void setSumQty(BigDecimal sumQty) {
        this.sumQty = sumQty;
    }

    public int getPrintCnt() {
        return printCnt;
    }

    public void setPrintCnt(int printCnt) {
        this.printCnt = printCnt;
    }
}
