package com.oushuai.animal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oushuai.animal.bean.*;
import com.oushuai.animal.service.AlbumService;
import com.oushuai.animal.service.CategoryService;
import com.oushuai.animal.service.NewService;
import com.oushuai.animal.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private AlbumService albumService;

    @RequestMapping(value = "/list/{albumId}", method = RequestMethod.GET)
    public String list(@PathVariable("albumId") Integer albumId, @RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);
        List<Video> video = videoService.list(albumId);
        Album album = albumService.getInfo(albumId);
        model.addAttribute("list", video);
        PageInfo page = new PageInfo(video, 5);
        model.addAttribute("albumName", album.getAlbumName());
        model.addAttribute("pageInfo", page);
        return "videos/list";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Msg delete(Integer videoId) {
        boolean del = videoService.delete(videoId);
        return del ? Msg.success() : Msg.fail();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAdd() {
        return "video/add";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(Video video, MultipartFile file, HttpServletRequest reqeust) {
        Msg uploadResult = uploadVideo(video, file, reqeust);
        if (uploadResult.getCode() == 0) {
            video.setVideoDate(new Date());
            videoService.insert(video);
            return "video/list";
        } else {
            return "video/add";
        }
    }
    public Msg uploadVideo(Video video,MultipartFile  file, HttpServletRequest reqeust)  {
        InputStream stream=null;
        try {
            stream =  file.getInputStream();
        } catch (IOException e) {
            return Msg.fail();
        }
        String fileName=file.getName();
        fileName= UUID.randomUUID().toString()+"_"+fileName;
        String dest= "E:/animalsite/animal/src/main/web/WEB-INF/video/";
        String s=dest+fileName+".jpg";
        video.setVideoUrl("http://localhost:8080/images/"+fileName+".jpg");
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
