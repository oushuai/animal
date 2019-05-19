package com.oushuai.animal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oushuai.animal.bean.*;
import com.oushuai.animal.service.AlbumService;
import com.oushuai.animal.service.CategoryService;
import com.oushuai.animal.service.NewService;
import com.oushuai.animal.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
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
    @Value("${upload.root.server}")
    private String uploadRootServer;
    @Value("${video.context.address}")
    private String videoContext;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam(value = "albumId", required = false) Integer albumId, @RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);
        List<Video> video = null;
        if(albumId==null){
            video=videoService.list();
        }else{
            video=videoService.list(albumId);
            Album album = albumService.getInfo(albumId);
            model.addAttribute("album", album);
        }
        model.addAttribute("list", video);
        PageInfo page = new PageInfo(video, 5);

        model.addAttribute("pageInfo", page);
        return "video/list";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Msg delete(Integer videoId) {
        boolean del = videoService.delete(videoId);
        return del ? Msg.success() : Msg.fail();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAdd(@RequestParam(value = "albumId", required = false) Integer albumId, Model model) {
        model.addAttribute("albumId", albumId);
        return "video/add";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showedit(@RequestParam(value = "albumId", required = true) Integer albumId, @RequestParam(value = "videoId", required = true) Integer videoId, Model model) {
        Video video = videoService.getVideo(videoId);
        model.addAttribute("video", video);
        model.addAttribute("albumId", albumId);
        return "video/edit";
    }
    @RequestMapping(value = "/doedit", method = RequestMethod.POST)
    public String edit(Video video) {
        video.setVideoDate(new Date());
        if (videoService.update(video)) {
            return "redirect:/video/list?albumId=" + video.getAlbumId();
        } else {
            return "redirect:/video/edit?albumId=" + video.getAlbumId() + "&videoId=" + video.getVideoId();
        }
    }
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String add(Video video, MultipartFile file, HttpServletRequest reqeust) {
        Msg uploadResult = uploadVideo(file, reqeust);
        if (uploadResult.getCode() == 0) {
            video.setVideoDate(new Date());
            video.setRecommend("0");
            video.setReadTimes(0);
            video.setVideoUrl(uploadResult.getMsg());
            videoService.insert(video);
            return "redirect:/video/list?albumId=" + video.getAlbumId();
        } else {
            return "redirect:/video/add?albumId=" + video.getAlbumId();
        }
    }
    public Msg uploadVideo(MultipartFile file, HttpServletRequest reqeust) {

        if (file == null || file.getSize() == 0) return Msg.fail();
        InputStream stream = null;
        try {
            stream = file.getInputStream();
        } catch (IOException e) {
            return Msg.fail();
        }
        String fileName = file.getOriginalFilename();
        String ext = fileName.split("\\.")[1];
        fileName = MessageFormat.format("{0}.{1}", UUID.randomUUID(), ext);
        uploadRootServer = reqeust.getServletContext().getRealPath("/WEB-INF/videos/");
        File root = new File(uploadRootServer);
        if (!root.exists()) {
            root.mkdirs();
        }

        File savedFile = new File(uploadRootServer, fileName);
        FileOutputStream fis = null;
        try {
            fis = new FileOutputStream(savedFile);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = stream.read(buffer)) != -1) {
                fis.write(buffer, 0, len);
            }
            Msg msg = new Msg();
            msg.setMsg(MessageFormat.format("{0}{1}", videoContext, fileName));
            return msg;
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
