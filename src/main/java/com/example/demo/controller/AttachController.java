package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/attachController")
public class AttachController {

    @ResponseBody
    @RequestMapping(value = "/getThumbnailImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public BufferedImage getThumbnailImage(@RequestParam String aId) throws IOException {
        return ImageIO.read(new ClassPathResource("/static/verificationCodeController.jpg").getInputStream());
    }

    @ResponseBody
    @RequestMapping(value = "/getPlainImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public BufferedImage getPlainImage(@RequestParam String aId) throws IOException {
        return ImageIO.read(new ClassPathResource("/static/verificationCodeController.jpg").getInputStream());
    }
}