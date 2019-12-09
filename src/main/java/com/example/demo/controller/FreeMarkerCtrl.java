package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FreeMarkerCtrl {

    @RequestMapping(value = "/test")
    public String test(ModelMap map){
        map.addAttribute("msg","123456");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/")
    public String root() {
        return "Thanks For Posting!!!";
    }

}