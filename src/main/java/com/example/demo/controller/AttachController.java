package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/verificationCodeController")
public class AttachController {

    @ResponseBody
    @RequestMapping("/getThumbnailImage")
    public String getThumbnailImage(@RequestParam String aId) {
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/getPlainImage")
    public String getPlainImage(@RequestParam String aId) {
        return "hello";
    }
}