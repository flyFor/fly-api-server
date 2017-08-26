package com.github.flyfor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 2017. 8. 26..
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    @ResponseBody
    public String index() {
        return "Fly to the Sky";
    }
}
