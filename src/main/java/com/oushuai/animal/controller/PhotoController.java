package com.oushuai.animal.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oushuai.animal.bean.Album;
import com.oushuai.animal.bean.Msg;
import com.oushuai.animal.bean.Photo;
import com.oushuai.animal.service.AlbumService;
import com.oushuai.animal.service.CategoryService;
import com.oushuai.animal.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
//  @RequestMapping(value="/list?albumId={albumId}",method=RequestMethod.GET)
//  @ResponseBody
//  public String list(@RequestParam(value="pn",defaultValue = "1")Integer pn,@RequestParam(value="count",defaultValue = "10")Integer pageSize,@PathVariable("albumId")Integer albumId,Model model) {
//        PageHelper.startPage(pn,5);
//        Page<Photo> photo = photoService.list(albumId,pn,pageSize);
//        model.addAttribute("list",photo.getResult());
//        model.addAttribute("pageInfo", photo);
//        return  "photo/list";
//    }
    @RequestMapping(value="/{albumId}",method=RequestMethod.GET)
    @ResponseBody
    public String list1(@PathVariable("albumId")Integer albumId,@RequestParam(value="pn",defaultValue = "1")Integer pn,Model model) {
       PageHelper.startPage(pn,5);
        List<Photo> photo = photoService.list(albumId);

        model.addAttribute("photo", photo);
        return  "photo/list";
    }
    @RequestMapping("/photo")
    public String list2(Model model){
        model.addAttribute("list",photoService.list1());
        return "category/photolist";
    }


}
