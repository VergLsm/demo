package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/verificationCodeController")
public class VerificationCodeController {

    @Autowired
    private Producer captchaProducer;

    @ResponseBody
    @RequestMapping("/imgmaker")
    public void imgmaker(HttpSession httpSession, HttpServletResponse response) throws IOException {
        //生成验证码
        String capText = captchaProducer.createText();
        httpSession.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        //向客户端写出
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

    @ResponseBody
    @RequestMapping("/getValidateCode")
    public Map<String, Object> getValidateCode(HttpSession httpSession, @RequestParam String verificationCode) {
        String capText = (String) httpSession.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (capText == null || capText.equals("")) {
            return null;
        }
        // {"success":true,"msg":"操作成功","obj":"Y","status":null,"info":"所填内容在系统中已存在,请检查","attributes":null,"next":null}
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        map.put("msg", "操作成功");
        if (verificationCode.toUpperCase().equals(capText)) {
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
