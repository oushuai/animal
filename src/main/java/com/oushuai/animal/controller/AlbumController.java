package com.oushuai.animal.controller;

import com.oushuai.animal.bean.Album;
import com.oushuai.animal.bean.Msg;
import com.oushuai.animal.service.AlbumService;
import com.oushuai.animal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RequestMapping("/album")
@Controller
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping("/list")
    public String list(Album album,Model model){
        model.addAttribute("list",albumService.getList(album));
        return "album/list";
    }
    @PostMapping("/edit")
    public String edit(Album album){
        albumService.update(album);
        return "redirect:/";
    }
    @PostMapping("/add")
    public String add(Album album){
        albumService.save(album);
        return "redirect:/";
    }
    @PostMapping("/del")
    public String edit(int id){
        albumService.del(id);
        return "redirect:/";
    }

}
