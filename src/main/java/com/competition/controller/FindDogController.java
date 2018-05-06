package com.competition.controller;


import com.competition.model.Animals;
import com.competition.service.AnimalsService;
import com.competition.service.impl.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 14553 on 2018/4/29.
 */
@Controller
public class FindDogController {
    @Autowired
    private AnimalsService animalsService;

    @RequestMapping("/finddog")
    public String findDog(){
        return "finddog";
    }

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        long nums = animalsService.getNumber();
        view.addObject("nums",nums);
        List<Animals> list = animalsService.getAllAnimals();
        int cat=0,dog=1;
        for(int i=0;i<nums;i++){
            int state = list.get(i).getIsDog().equals("dog")?dog:cat;
            view.addObject("infoImg"+state,"images/"+list.get(i).getImgName());
            view.addObject("infoCity"+state,list.get(i).getCity());
            view.addObject("infoKind"+state,list.get(i).getIsDog());
            if(list.get(i).getIsDog().equals("dog"))
                dog+=2;
            else
                cat+=2;
        }

        return view;
    }


    @RequestMapping(value = "/uploadDogInfo",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,Object> findDogInfo(@RequestParam("img") MultipartFile img, @RequestParam("city") String city, @RequestParam("isDog") String is_dog, @RequestParam("connect") String connect){
        HashMap<String,Object> result = new HashMap<String,Object>();
        //String contentType = img.getContentType();
        String fileName = img.getOriginalFilename();

        String filePath = "G://test//";
        try {
            FileUtil.uploadFile(img.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }

        try {
            animalsService.addAnimals(img.getOriginalFilename(),city,is_dog,connect);
            result.put("code", 1);
            result.put("message", "成功");
        }catch (Exception e){
            result.put("code", 2);
            result.put("message", "失败");
        }
        return result;
    }

    @RequestMapping(value = "/getInfo/{img_name}",method = RequestMethod.GET)
    //@ResponseBody
    public ModelAndView getInfo(@PathVariable String img_name){
        ModelAndView view = new ModelAndView();
        view.setViewName("detailInfo");
        //Animals animals = new Animals("123","456","87","90");
        Animals animals = animalsService.findByImgName(img_name);
        view.addObject("resultCity", animals.getCity());
        view.addObject("resultImg", "images/"+animals.getImgName());
        view.addObject("resultKind",animals.getIsDog());
        return view;
    }


}
