package com.oushuai.animal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oushuai.animal.bean.Album;
import com.oushuai.animal.bean.Msg;
import com.oushuai.animal.service.AlbumService;
import com.oushuai.animal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RequestMapping("/album")
@Controller
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("/list")
    public String list(@RequestParam(value="pn",defaultValue = "1")Integer pn,Album album,Model model){
        PageHelper.startPage(pn,5);
        List<Album> albums = albumService.list();
        model.addAttribute("list",albums);
        PageInfo page=new PageInfo(albums,5);
        model.addAttribute("pageInfo", page);
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
    @RequestMapping("/getAlbums")
    @ResponseBody
    public List<Album> getAlbums(){
        return albumService.list();
    }

}
