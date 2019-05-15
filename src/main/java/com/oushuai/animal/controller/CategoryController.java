package com.oushuai.animal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oushuai.animal.bean.Category;
import com.oushuai.animal.bean.Msg;
import com.oushuai.animal.bean.Photo;
import com.oushuai.animal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value={"/category","/"})
    public String list(@RequestParam(value="pn",defaultValue = "1")Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<Category> category = categoryService.list();
        model.addAttribute("list",category);
        PageInfo page=new PageInfo(category,5);
        model.addAttribute("pageInfo", page);
        return "category/list";
    }
    @RequestMapping(value = "/category/edit",method = RequestMethod.POST)
    public String edit(int cateId,String cateName){
        categoryService.update(cateId,cateName);
        return "redirect:/";
    }
    @RequestMapping(value = "/category/add",method = RequestMethod.POST)
    public String edit(String cateName){
        categoryService.add(cateName);
        return "redirect:/";
    }
    @RequestMapping(value = "/category/delete",method = RequestMethod.GET)
    @ResponseBody
    public Msg edit(int id){
        int result = categoryService.delete(id);
        return  Msg.success();
    }
}
