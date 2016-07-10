package me.zacharyjia.fuckexcel.controller;

import me.zacharyjia.fuckexcel.model.Admin;
import me.zacharyjia.fuckexcel.model.SuperAdmin;
import me.zacharyjia.fuckexcel.model.User;
import me.zacharyjia.fuckexcel.service.AdminService;
import me.zacharyjia.fuckexcel.service.SuperAdminService;
import me.zacharyjia.fuckexcel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户登录
 * Created by zachary on 16/7/9.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private SuperAdminService superAdminService;

    @RequestMapping("login")
    public String login(ModelMap map) {
        User user = null;
        //判断用户是否已经登录
        if ((user = (User) session.getAttribute("user")) != null) {
            if (user instanceof SuperAdmin) {
                return "redirect:/sa/home";
            } else if (user instanceof Admin) {
                return "redirect:/admin/home";
            } else {
                return "redirect:/user/home";
            }
        }

        String msg = (String) session.getAttribute("msg");
        session.removeAttribute("msg");
        map.addAttribute("msg", msg);
        return "login";
    }

    @RequestMapping("doLogin")
    public String doLogin(HttpServletRequest request) {
        String username, password, role;
        User user = null;
        if ((username = request.getParameter("username")) != null && !"".equals(username) &&
                (password = request.getParameter("password")) != null && !"".equals(password) &&
                (role = request.getParameter("role")) != null) {
            if ("user".equals(role)) {
                user = userService.findUserByUsername(username);
            } else if ("admin".equals(role)) {
                user = adminService.findAdminById(username);
            } else if ("super_admin".equals(role)) {
                user = superAdminService.findSuperAdminByUsername(username);
            }
            else {
                session.setAttribute("msg", "出现未知错误,请通过正常方式登录!");
                return "redirect:/login";
            }
            if (user != null && password.equals(user.getPassword())) {
                session.setAttribute("user", user);
                session.setAttribute("user_type", "user");
                return "redirect:/login";
            }
            else {
                session.setAttribute("msg", "用户名或密码错误!");
                return "redirect:/login";
            }
        }
        else {
            session.setAttribute("msg_type", "error");
            session.setAttribute("msg", "用户名或密码不能为空!");
            return "redirect:/login";
        }
    }

    @RequestMapping("/logout")
    public String logout() {
        session.removeAttribute("user");
        return "redirect:/login";
    }

}
