package com.example.demo.com.ctl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.MtlstockEty;
import com.example.demo.service.DocSelectService;
import com.example.demo.service.InputService;
import com.example.demo.service.MtlstockService;
import com.example.demo.service.NOService;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;
//测试用的REST服务
@CrossOrigin(maxAge = 3600)
@RestController
public class TestController {

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

    /***********HTTP GET method*************/
    @GetMapping("/testGetApi")
    public String getJson() {
        String url = Constant.URL + "/getshopbyid?shopId=19";
        //String json =restTemplate.getForObject(url,Object.class);
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = results.getBody();
        return json;
    }

    //测试rest服务
    @RequestMapping(value = "/testPostApi")
    public Object testPost() {
        String url = Constant.URL + "/testPost";
        JSONObject postData = new JSONObject();
        postData.put("descp", "request for post");
        List list1 = new ArrayList();
        for (int i = 0; i < 10; i++) {
            MtlstockEty a1 = new MtlstockEty();

            a1.setMtlNO("X11" + i);
            a1.setMtlDesc("流动11" + i * 2);
            a1.setQty(new BigDecimal(i * 11));

            list1.add(a1);
        }

        postData.put("data", list1);

        JSONObject json = restTemplate.postForEntity(url, postData, JSONObject.class).getBody();
        return json;
    }
}
