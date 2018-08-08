package com.newforesee.girl.controller;

import com.newforesee.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by newforesee on 2018/8/6.
 */
@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    //
//    @GetMapping(value = "/hello")
//    public String say(){
//        return "hello ningdan " + girlProperties.getCupSize()+girlProperties.getAge();
//    }
    @GetMapping(value = "/login")
    public String login() {
        return girlProperties.getCupSize();
    }
}
