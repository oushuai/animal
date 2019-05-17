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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;
    @Autowired
    private AlbumService albumService;

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
    @RequestMapping(value="/list/{albumId}",method=RequestMethod.GET)
    public String list(@PathVariable("albumId")Integer albumId,@RequestParam(value="pn",defaultValue = "1")Integer pn,Model model) {
       PageHelper.startPage(pn,5);
        List<Photo> photo = photoService.list(albumId);
        Album album=albumService.getInfo(albumId);
        model.addAttribute("list", photo);
        PageInfo page=new PageInfo(photo,5);
        model.addAttribute("albumName",album.getAlbumName());
        model.addAttribute("pageInfo", page);
        return  "photos/list";
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Msg delete(Integer photoId,Integer albumId){
        boolean del= photoService.delete(photoId,albumId);
        return del?Msg.success():Msg.fail();
    }
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public String showAdd(){
        return "photos/add";
    }
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public String upload(Photo photo,MultipartFile file,HttpServletRequest reqeust)
    {
        Msg uploadResult=uploadPhoto(photo,file,reqeust);
        if(uploadResult.getCode()==0){
            photo.setCreateTime(new Date());
            photo.setPhotoDate(new Date());
            photoService.insert(photo);
            return "photos/list";
        }else{
            return "photos/add";
        }
    }

    public Msg uploadPhoto(Photo photo,MultipartFile  file, HttpServletRequest reqeust)  {
        InputStream stream=null;
        try {
             stream =  file.getInputStream();
        } catch (IOException e) {
            return Msg.fail();
        }
        String fileName=file.getName();
        fileName=UUID.randomUUID().toString()+"_"+fileName;
        String dest= "E:/animalsite/animal/src/main/web/WEB-INF/images/";
       String s=dest+fileName+".jpg";
       photo.setPhotoUrl("http://localhost:8080/images/"+fileName+".jpg");
        FileOutputStream fis= null;
        try {
            fis = new FileOutputStream(new File(s));
            byte[] buffer=new byte[1024];
            int len= 0;
            while( (len=stream.read(buffer))!=-1){
                fis.write(buffer,0,len);
            }
            Msg msg=new Msg();
            msg.setMsg(fileName);
            return msg;
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}