package me.zacharyjia.fuckexcel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zachary on 16/7/9.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello.do")
    public String hello(HttpServletRequest request, ModelMap map) {
        String name = request.getParameter("name");
        map.addAttribute("name", name);
        return "hello";
    }
}
