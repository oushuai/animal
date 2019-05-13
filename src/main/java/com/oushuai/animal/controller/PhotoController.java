package com.oushuai.animal.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oushuai.animal.bean.Album;
import com.oushuai.animal.bean.Msg;
import com.oushuai.animal.bean.Photo;
import com.oushuai.animal.service.AlbumService;
import com.oushuai.animal.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/photo")
@Controller
public class PhotoController {


    @Autowired
    private PhotoService photoService;

    /*@RequestMapping("/photo1")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue = "1")Integer pn, Model model) {
        PageHelper.startPage(pn,5);
        List<Photo> photo = photoService.list();
        PageInfo page=new PageInfo(photo,5);
        return Msg.success().add("pageInfo",page);
    }
*/
    /*列表*/
    @RequestMapping("/list")
  public String list(@RequestParam(value="pn",defaultValue = "1")Integer pn,@RequestParam(value="count",defaultValue = "10")Integer pageSize,Integer albumId,Model model) {
        PageHelper.startPage(pn,5);
        Page<Photo> photo = photoService.list(albumId,pn,pageSize);
//        model.addAttribute("photo1",photo);
        //连续传入5页
      // PageInfo page=new PageInfo(photo,5);
//for(Photo p:photo){
//        System.out.println(p.getPhotoId());
//}
        model.addAttribute("list",photo.getResult());
       model.addAttribute("pageInfo", photo);
        return  "photo/list";
    }




}
