package com.oushuai.animal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.MessageFormat;

@Controller
public class PageController {
    @RequestMapping(value = "/{module:[^(css)(js)(images)(videos)(js)(fonts)]]}/{page}",method = RequestMethod.GET)
    public String goPage(@PathVariable("module") String module,@PathVariable("page") String page){
        return MessageFormat.format("{0}/{1}",module,page);

    }
}
