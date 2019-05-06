package com.oushuai.animal.controller;

import com.oushuai.animal.bean.Album;
import com.oushuai.animal.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/admin/album")
@Controller
public class AlbumController {
    private final String prefix = "admin/album";

    @Autowired
    private AlbumService albumService;

    private String getTemplatePath(String fileName) {
        return prefix + fileName;
    }

    /*列表*/
//    @GetMapping("")
//    String list(Model model) {
//        List<Album> albumList = albumService.list();
//        model.addAttribute("albumList", albumList);
//        return prefix + "/list";
//    }
//    /*添加*/
//    @RequestMapping("/add")
//    String index(Model model) {
//        Album album = new Album();
//        model.addAttribute("album", album);
//        return getTemplatePath("/add_edit");
//    }

}
