package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/verificationCodeController")
public class VerificationCodeController {

    @RequestMapping("/imgmaker")
    public Object imgmaker() {
        return "";
    }

    @ResponseBody
    @RequestMapping("/getValidateCode")
    public Map<String, Object> getValidateCode(@RequestParam String verificationCode) {
        // {"success":true,"msg":"操作成功","obj":"Y","status":null,"info":"所填内容在系统中已存在,请检查","attributes":null,"next":null}
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        map.put("msg", "操作成功");
        if (verificationCode.equals("123")) {
            map.put("obj", "Y");
        } else {
            map.put("obj", "N");
        }
        map.put("status", null);
        map.put("info", "所填内容在系统中已存在,请检查");
        map.put("attributes", null);
        map.put("next", null);
        return map;
    }

    @ResponseBody
    @RequestMapping("/quicklyCheckAndShowProjectInfoPage")
    public Map<String, Object> quicklyCheckAndShowProjectInfoPage(@RequestParam String projectName,
            @RequestParam String uniqueNumber) {

       //附件
        Map<String, Object> dataVoMap = new HashMap<String, Object>();
        dataVoMap.put("attachType", "img");
        dataVoMap.put("id", "img_id");
        dataVoMap.put("name", "img_name");
        //附件，可以有多个，图片
        List<Object> dataVoList = new ArrayList<>();
        dataVoList.add(dataVoMap);

        //保函信息
        Map<String, Object> expandMap = new HashMap<String, Object>();
        expandMap.put("financingBegindate", 1573401600000L);
        expandMap.put("financingEnddate", 1576080000000L);
        expandMap.put("financingName", "我保你大保函1号");
        expandMap.put("financingMoney", 2333);
        
        List<Object> expandList = new ArrayList<>();
        expandList.add(expandMap);

        Map<String, Object> objMap = new HashMap<String, Object>();
        objMap.put("isMsuh", "2");
        objMap.put("dataVoList", dataVoList);
        objMap.put("expandList", expandList);
        objMap.put("projectName", "田鸡");
        objMap.put("unitName", "小明");
        objMap.put("guaranteeOpenOrg", "唔知咩公司");
        objMap.put("financingBegindate", 1573401600000L);
        objMap.put("financingEnddate", 1576080000000L);
        objMap.put("financingName", "我保你大保函1号");
        objMap.put("financingMoney", 2222);


        List<Object> objList = new ArrayList<>();
        objList.add(objMap);

        // {"success":true,"msg":"操作成功","obj":"Y","status":null,"info":"所填内容在系统中已存在,请检查","attributes":null,"next":null}
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        map.put("msg", "操作成功");
        map.put("obj", objList);
        map.put("status", null);
        map.put("info", "所填内容在系统中已存在,请检查");
        map.put("attributes", null);
        map.put("next", null);

        return map;
    }
}
