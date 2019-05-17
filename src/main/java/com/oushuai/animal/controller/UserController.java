package com.oushuai.animal.controller;

import com.oushuai.animal.bean.Album;
import com.oushuai.animal.bean.Msg;
import com.oushuai.animal.bean.SysUser;
import com.oushuai.animal.service.AlbumService;
import com.oushuai.animal.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/login")
    public String loginIndex(){
        return "user/login";
    }
    @RequestMapping("/submitlogin")
    public String login(SysUser sysUser, Model model, HttpServletRequest request, HttpServletResponse response){
        if(sysUser==null|| StringUtils.isBlank(sysUser.getUserName()) ||StringUtils.isBlank(sysUser.getPassword())){
            model.addAttribute("loginError","登录失败，用户名或密码错误");
            return "user/login";
        }
         SysUser user=sysUserService.login(sysUser.getUserName(),sysUser.getPassword());
        if(user!=null){
            HttpSession session = request.getSession();
            session.setAttribute("sysUser",user);
            return "redirect:/";
        }else{
            model.addAttribute("loginError","登录失败，用户名或密码错误");
            return "user/login";
        }
    }
    @RequestMapping("/register")
    public String register(){
        return "user/register";
    }
    @RequestMapping("/submitregister")
    public String submitRegister(SysUser sysUser, Model model){
        sysUserService.register(sysUser);
        return "redirect:/user/login";
    }
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
