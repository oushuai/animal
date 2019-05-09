package com.oushuai.animal.controller;

import com.oushuai.animal.bean.Msg;
import com.oushuai.animal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value={"/category","/"})
    public String list(Model model){
        model.addAttribute("list",categoryService.list());
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
