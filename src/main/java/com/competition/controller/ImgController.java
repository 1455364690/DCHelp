package com.competition.controller;


import com.competition.service.impl.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 14553 on 2018/4/29.
 */
@Controller
public class ImgController {


    //跳转到上传文件的页面
    @RequestMapping(value="/uploadimg", method = RequestMethod.GET)
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "uploadimg";
    }

    //处理文件上传
    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
    public @ResponseBody
    String uploadImg(@RequestParam("file") MultipartFile file,
                     HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/
        String filePath = "G://test//";
        //String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        return "uploadimg success";
    }
}
