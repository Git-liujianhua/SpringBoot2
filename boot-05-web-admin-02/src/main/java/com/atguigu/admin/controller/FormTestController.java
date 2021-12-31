package com.atguigu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传测试
 */
@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "forms/form_layouts";
    }


    /**
     * MultipartFile   自动分装上传来的文件
     * 单文件上传获取直接使用   MultipartFile
     * 多文件上传使用  MultipartFile[] 数组即可
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：email={}，username={}，headerImg={}，photos={}",email,username,headerImg.getSize(),photos.length);

        if (!headerImg.isEmpty()){
            //保存的文件服务器，OSS服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\file\\IdeaProjects\\springboot2\\boot-05-web-admin-02\\image\\"+originalFilename));
        }

        if (photos.length > 0){
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\file\\IdeaProjects\\springboot2\\boot-05-web-admin-02\\image\\photos\\"+originalFilename));
                }
            }
        }

        return "redirect:/main.io";
    }
}
