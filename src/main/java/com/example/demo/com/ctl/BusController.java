package com.example.demo.com.ctl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.InputEty;
import com.example.demo.entity.MtlstockEty;
import com.example.demo.entity.OutputEty;
import com.example.demo.service.DocSelectService;
import com.example.demo.service.InputService;
import com.example.demo.service.MtlstockService;
import com.example.demo.service.NOService;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class BusController {

    @Autowired
    private MtlstockService mtlstockService;
    @Autowired
    private DocSelectService docSelectService;
    @Autowired
    private InputService inputService;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NOService noService;

    // Restful服务对应的url地址
    @Value("${user.userServicePath}")
    private String userServicePath;

    @Autowired
    HttpServletRequest request;

    //计算总接收次数，今天接收次数的服务
    @RequestMapping("/ia")
    public Map computeReceiveCnt() {
        Map map = new HashMap<>();
        Map mapTmp = mtlstockService.computeReceiveCnt();
        map.putAll(mapTmp);

        String ip = getIpAddr(request);
        System.out.println("ip....... : " + ip);
        return map;
    }

    @RequestMapping("/dayInfo")
    public Map findDayReceiveInfo(
            @RequestParam(value = "pageIndex", required = false) String pageIndex
            , @RequestParam(value = "pageSize", required = false) String pageSize) {
        if (pageIndex == null || "0".equals(pageIndex)) {
            pageIndex = "1";
        }
        if (pageSize == null || "0".equals(pageSize)) {
            pageSize = "10";
        }
        Map map = new HashMap<>();

        List list1 = docSelectService.findDayReceiveInfo(pageIndex,
                pageSize);
        String total = docSelectService.findDayReceiveInfoTotal();
        map.put("aa", list1);
        map.put("pageIndex", pageIndex);
        map.put("rowTotal", total);
        map.put("pageSize", pageSize);

        return map;
    }

    @RequestMapping("/daySum")
    public Map findDaySum() {
        Map map = new HashMap<>();

        List list1 = docSelectService.findDaySum();
        map.put("aa", list1);

        return map;
    }

    @RequestMapping("/getDocByDocNO")
    public Map getDocByDocNO(String docNO) {
        Map map = new HashMap<>();

        List list1 = mtlstockService.findDocByNO(docNO);
        map.put("aa", list1);

        return map;
    }

    @RequestMapping("/monSum")
    public Map findMonSum() {
        Map map = new HashMap<>();

        List list1 = docSelectService.findMonSum();
        map.put("aa", list1
        );
        List list2 = new ArrayList();

        for (int i = 0; i < 5; i++) {
            Map map2 = new HashMap();
            map2.put("genre", i);
            map2.put("sold", i * 100);
            list2.add(map2);
        }
        JSONObject rtn = new JSONObject();
        rtn.putAll(map);
        rtn.put("test", list2);
        map.put("test", list2);
        return map;
    }

    /**********HTTP POST method**************/
    //可以做为对外的服务
    @PostMapping(value = "/testPost")
    public Object receiveData(@RequestBody JSONObject param) {
        //传入参数收集
        InputEty a1 = new InputEty();
        a1.setClassName("BusController");
        a1.setMethodName("receiveData");
        a1.setParas(param.toJSONString());
        String docNO = noService.getDcoNO(Constant.DOC_TYPE_D02);
        a1.setDocNO(docNO);
        inputService.save(a1);

        JSONObject rtn = new JSONObject();
        rtn.putAll(param);
        //调用库存服务
        Object data = param.get("data");
        if (data != null) {
            List listData = (List) data;
            List list1 = new ArrayList(listData.size());
            Calendar c1 = java.util.Calendar.getInstance();

            String currYear = String.valueOf(c1.get(Calendar.YEAR));
            String currMonth = String.valueOf(c1.get(Calendar.MONTH) + 1);
            String currDay = String.valueOf(c1.get(Calendar.DATE));
            if (currMonth.length() == 1)
                currMonth = "0" + currMonth;
            if (currDay.length() == 1)
                currDay = "0" + currDay;

            for (int i = 0, size = listData.size(); i < size; i++) {
                Map map = (Map) listData.get(i);
                MtlstockEty mtl = new MtlstockEty();
                mtl.setMtlNO((String) map.get("mtlNO"));
                mtl.setMtlDesc((String) map.get("mtlDesc"));
                Object qty = map.get("qty");
                if (qty instanceof Double) {
                    mtl.setQty(new BigDecimal((Double) qty));
                } else {
                    mtl.setQty(new BigDecimal((Integer) qty));
                }
                mtl.setCurrYear(currYear);
                mtl.setCurrMonth(currMonth);
                mtl.setCurrDay(currDay);
                list1.add(mtl);
            }

            String docNO1 = mtlstockService.saveBat(list1);
            rtn.put("docNO", docNO1);
        }
        //返回结果收集
        OutputEty o1 = new OutputEty();
        o1.setDocNO(docNO);
        o1.setRtnMsg(rtn.toJSONString());

        inputService.save(o1);

        return rtn;
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
//            System.out.println("111xxx11 " + request.getRemoteUser());
//            System.out.println("xxx11 " + request.getRemoteHost());
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ipAddress.indexOf(",") > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        // ipAddress = this.getRequest().getRemoteAddr();

        return ipAddress;
    }
}

