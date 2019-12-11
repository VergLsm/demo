package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FreeMarkerCtrl {

    // @RequestMapping(value = "/{file}")
    // public String test(ModelMap map, @PathVariable("file") String file, @RequestParam String param) {
    //     map.addAttribute("msg", "123456" + param);
    //     return file;
    // }

    @ResponseBody
    @RequestMapping(value = "/")
    public String root() {
        return "Thanks For Posting!!!!";
    }

}