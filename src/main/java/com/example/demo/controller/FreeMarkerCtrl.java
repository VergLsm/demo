package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreeMarkerCtrl {

    // @RequestMapping(value = "/{file}")
    // public String test(ModelMap map, @PathVariable("file") String file, @RequestParam String param) {
    //     map.addAttribute("msg", "123456" + param);
    //     return file;
    // }

    @RequestMapping(value = "/")
    public String root() {
        return "redirect:webpage/web/guaranteeQuery.html";
    }

}