package com.competition.controller;


import com.competition.model.Animals;
import com.competition.service.AdoptManService;
import com.competition.service.AnimalsService;
import com.competition.service.impl.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by 14553 on 2018/4/29.
 */
@Controller
public class FindDogController {
    @Autowired
    private AnimalsService animalsService;

    @Autowired
    private AdoptManService adoptManService;
    //@Value("${cbs.imagesPath}")
    //String filePath;

    @RequestMapping("/finddog")
    public String findDog(){
        return "finddog";
    }

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        int nums = (int)animalsService.getNumber();
        view.addObject("nums",nums);
        List<Animals> list = animalsService.getAllAnimals();
        for(int i=0;i<5;i++){
            Animals animals = list.get(0);
            int flag=0;
            for(int j=1;j<nums-i;j++){
                if(list.get(j).getTime().after(animals.getTime())){
                    animals = list.get(j);
                    flag = j;
                }

            }
            view.addObject("infoImg"+i,animals.getImgName());
            list.remove(flag);
        }

        return view;
    }


    @RequestMapping(value = "/uploadDogInfo",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView findDogInfo(@RequestParam("img") MultipartFile img, @RequestParam("city") String city, @RequestParam("isDog") String is_dog, @RequestParam("connect") String connect){
        ModelAndView result = new ModelAndView();
        //String contentType = img.getContentType();
        String[] temp = img.getOriginalFilename().split("\\.");
        Date date = new Date();
        String fileName = date.getTime()+"."+temp[temp.length-1];
        //System.out.println(fileName);
        result.setViewName("upload");
        String filePath = "C://www//files//";
        try {
            FileUtil.uploadFile(img.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        Timestamp currTime = new Timestamp(System.currentTimeMillis());
        try {
            animalsService.addAnimals(fileName,city,is_dog,connect,currTime);
            result.addObject("code", 1);
            result.addObject("message", "成功");
        }catch (Exception e){
            result.addObject("code", 2);
            result.addObject("message", "失败");
        }
        return result;
    }

    @RequestMapping(value = "/adopt/{img_name}",method = RequestMethod.GET)
    public ModelAndView adopt(@PathVariable String img_name){
        ModelAndView view = new ModelAndView();
        view.setViewName("adopt");
        //Animals animals = new Animals("123","456","87","90");
        Animals animals = animalsService.findByImgName(img_name);
        System.out.println("img_name:"+img_name);
        System.out.println(animals.getCity());
        view.addObject("resultCity", animals.getCity());
        view.addObject("resultImg", img_name);
        view.addObject("resultKind",animals.getIsDog());
        return view;
    }
    @RequestMapping(value = "/adoptInfo/{img_name}",method = RequestMethod.POST)
    public ModelAndView adoptInfo(@PathVariable String img_name,@RequestParam("gender") String gender,@RequestParam("name") String name,@RequestParam("pnumber") String pnumber,@RequestParam("address") String address){
        ModelAndView view = new ModelAndView();
        //保存领养人信息
        Timestamp currTime = new Timestamp(System.currentTimeMillis());
        adoptManService.addAdoptMan(name,pnumber,address,img_name,currTime,gender);
        //查询领养的动物信息并删除之
        Animals animals = animalsService.findByImgName(img_name);
        animalsService.deleteById(animals.getId());
        view.setViewName("adoptSuccess");
        return view;
    }

    @RequestMapping("/test")
    public String test(){
        return "adoptSuccess";
    }

}
