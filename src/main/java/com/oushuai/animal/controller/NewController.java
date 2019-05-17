package com.oushuai.animal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oushuai.animal.bean.Album;
import com.oushuai.animal.bean.New;
import com.oushuai.animal.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewController {
    @Autowired
    private NewService newService;

    /**
     * 资讯列表
     * @param pn
     * @param album
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Album album, Model model) {
        PageHelper.startPage(pn, 5);
        List<New> list = newService.getList(new New());
        model.addAttribute("list", list);
        PageInfo page = new PageInfo(list, 5);
        model.addAttribute("pageInfo", page);
        return "news/list";
    }

    /**
     * 更新资讯
     * @param news
     * @return
     */
    @PostMapping("/edit")
    public String edit(New news){
        newService.update(news);
        return "redirect:/";
    }

    /**
     * 添加资讯
     * @param news
     * @return
     */
    @PostMapping("/add")
    public String add(New news){
        newService.save(news);
        return "redirect:/";
    }

    /**
     * 删除资讯
     * @param newId
     * @return
     */
    @PostMapping("/del")
    public String edit(int newId){
        newService.del(newId);
        return "redirect:/";
    }

    /**
     * 资讯详情
     * @param newId
     * @param model
     * @return
     */
    @RequestMapping("/info")
    public String info(int newId, Model model) {
        New news = newService.getInfo(newId);
        model.addAttribute("info", news);
        return "news/info";
    }
}
