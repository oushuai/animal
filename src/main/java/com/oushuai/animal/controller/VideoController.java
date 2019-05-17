package com.oushuai.animal.controller;

import com.oushuai.animal.bean.Video;
import com.oushuai.animal.service.CategoryService;
import com.oushuai.animal.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;
@GetMapping("/video")
String list(Model model){
    List<Video> video = videoService.list();
    model.addAttribute("list",video);
    return "video/play";
}
}
