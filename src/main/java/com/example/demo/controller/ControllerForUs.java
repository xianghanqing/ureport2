package com.example.demo.controller;

import com.example.demo.annotation.AnnotationForUs;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class ControllerForUs {
    @RequestMapping(value = "QueryTestone.do" ,method = RequestMethod.POST)
    @AnnotationForUs()
    public void QueryTestone(HttpServletRequest request){
        System.out.println("################################QueryTestone");
    }
}
