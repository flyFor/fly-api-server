package com.github.flyfor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2017. 8. 26..
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    @ResponseBody
    public String index() {
        return "Fly to the Sky";
    }
}
