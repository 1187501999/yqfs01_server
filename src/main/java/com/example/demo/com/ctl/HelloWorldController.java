package com.example.demo.com.ctl;

import com.example.demo.entity.InputEty;
import com.example.demo.service.InputService;
import com.example.demo.service.MtlstockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class HelloWorldController {


    @Autowired
    private InputService s1;


    @Autowired
    private MtlstockService mtlstockService;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/h1")
    public Map index1(@RequestParam String mobile) {
        Map map = new HashMap<>();
        map.put("a", "b788888");
        map.put("a1", "bbgggg");
        map.put("a2", mobile);

        System.out.println("ssssssssmapInssss h1 " + map.get("a2"));
        return map;
    }

    @RequestMapping("/h2")
    public Map index(@RequestParam String mapIn) {
        Map map = new HashMap<>();
        System.out.println("ssssssssmapInssss h2" + mapIn);
        map.put("aa", mapIn);
        return map;
    }

    @RequestMapping(value = "/h3", method = RequestMethod.POST)
    public Map inde1x(@RequestParam String mapIn) {
        Map map = new HashMap<>();
        map.put("a", "b788888");
        map.put("a1", "bbgggg");
        map.put("a2", "dd");

        System.out.println("ssssssssssss111 h3 " + mapIn);

        return map;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public Map index(@RequestBody Map mapIn) {
        Map map = new HashMap<>();
        map.put("a", "b788888");
        map.put("a1", "bbgggg");
        map.put("a2", "dd");

        List list = new ArrayList();
        System.out.println("ssssssssssss hello " + list.size());
        map.put("aa", list);
        return map;
    }

    @RequestMapping("/i1")
    public Map input(@RequestBody Map mapIn) {
        Map map = new HashMap<>();
        InputEty a1 = new InputEty();
        a1.setUrl((String) mapIn.get("url"));
        a1.setClassName("x");
        a1.setMethodName("sss1");
        a1.setParas("sss2");
        a1.setUserName((String) mapIn.get("name"));

        a1.setcDate(new Date());

        s1.save(a1);
        return map;
    }

    @RequestMapping("/i2")
    public Map inputFindAll() {
        Map map = new HashMap<>();

        List list1 = s1.findAllIn();
        map.put("aa", list1);

        return map;
    }


}
