/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;


public final class Constant {

    public static final int BD_DIG_SCALE = 2;
    public static final int DAYTMILLISEC = 86400000;
    public static final BigDecimal ZERO = new BigDecimal(0);
    //接收明细，每次生成的编号
    public static final String DOC_TYPE_D01 = "D01";
    //服务的传入
    public static final String DOC_TYPE_D02 = "D02";
//起始编号
    public static final String DOC_NO_BEGIN = "90625";

    //消息
    public static final String MSG_NO_INPUT = "传入的数据集合为0 ";
    public static final String MSG_MTL_IS_NULL = "传入的数据物料号为空 ";
    public static final String MSG_MTL_QTY_IS_0 = "传入的数据物料号~~数量为空 ";

    public static final String URL = "http://localhost:8888";

}
