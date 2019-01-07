package com.ligee.client.index.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:05 PM
 */
@RestController
@RequestMapping("")
public class IndexController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){
        try {
            Thread.sleep(20);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "hello world!";
    }
}
