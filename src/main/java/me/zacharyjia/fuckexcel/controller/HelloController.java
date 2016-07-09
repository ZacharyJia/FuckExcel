package me.zacharyjia.fuckexcel.controller;

import me.zacharyjia.fuckexcel.model.User;
import me.zacharyjia.fuckexcel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by zachary on 16/7/9.
 */
@Controller
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping("/hello.do")
    public String hello(HttpServletRequest request, ModelMap map) {
        String name = request.getParameter("name");
        map.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/create.do")
    public String create(ModelMap map) {
        User user = new User();
        user.setId("c443f7db-6792-3385-66f1-b011157711a6");
        userService.deleteById(user.getId());
        return "hello";
    }
}
