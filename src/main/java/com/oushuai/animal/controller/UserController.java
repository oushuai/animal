package com.oushuai.animal.controller;

import com.oushuai.animal.bean.Album;
import com.oushuai.animal.bean.Msg;
import com.oushuai.animal.bean.SysUser;
import com.oushuai.animal.service.AlbumService;
import com.oushuai.animal.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 */
@RequestMapping("/admin/user")
@Controller
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/list")
    public String list(Album album,Model model){
        model.addAttribute("list",sysUserService.list());
        return "album/list";
    }
    @GetMapping("/list1")
    public Msg list(){
        Msg msg=new Msg();
        List<SysUser> list = sysUserService.list();
        msg.add("list",list);
        return msg;
    }
//    @PostMapping("/edit")
//    public String edit(Album album){
//        albumService.update(album);
//        return "redirect:/";
//    }
//    @PostMapping("/add")
//    public String add(Album album){
//        albumService.save(album);
//        return "redirect:/";
//    }
//    @PostMapping("/del")
//    public String edit(int id){
//        albumService.del(id);
//        return "redirect:/";
//    }

}
