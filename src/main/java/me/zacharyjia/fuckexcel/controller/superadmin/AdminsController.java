package me.zacharyjia.fuckexcel.controller.superadmin;

import me.zacharyjia.fuckexcel.common.InputUtil;
import me.zacharyjia.fuckexcel.common.Msg;
import me.zacharyjia.fuckexcel.model.Admin;
import me.zacharyjia.fuckexcel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by zachary on 16/7/10.
 */
@Controller
@RequestMapping("/sa/admins")
public class AdminsController extends BaseSaController {

    @Autowired
    private HttpSession session;

    @Autowired
    private AdminService adminService;

    private String result;

    @RequestMapping("")
    public String admins(ModelMap map) {
        if ((result = authCheck()) != null) {
            return result;
        }

        map.addAttribute("superAdmin", getLoginSuperAdmin());
        map.addAttribute("msg", session.getAttribute("msg"));
        session.removeAttribute("msg");

        List<Admin> adminList = adminService.findAll();
        map.addAttribute("admins", adminList);

        return "sa/admins";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request) {
        if ((result = authCheck()) != null) {
            return result;
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tags = request.getParameter("tags");

        if (InputUtil.isEmpty(username, password) && tags != null) {
            setMsg(new Msg("error", "用户名、密码不能为空"));
            return "redirect:/sa/admins";
        }
        Set<String> set = InputUtil.string2tag(tags);
        if (set == null)
            set = new HashSet<String>();
        if (!set.contains(username)) {
            set.add(username);
        }
        set.remove("");

        Admin admin = new Admin();
        admin.setId(UUID.randomUUID().toString());
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setTags(set);
        if (adminService.createAdmin(admin)) {
            setMsg(new Msg("success", "添加成功"));
        }
        else {
            setMsg(new Msg("error", "添加失败,用户名可能已经存在"));
        }
        return "redirect:/sa/admins";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request) {
        if ((result = authCheck()) != null) {
            return result;
        }

        String id = request.getParameter("id");
        if (id != null && !"".equals(id)) {
            adminService.deleteById(id);
            setMsg(new Msg("success", "删除成功"));
        } else {
            setMsg(new Msg("error", "参数错误,请稍后重试"));
        }

        return "redirect:/sa/admins";
    }

    @ResponseBody
    @RequestMapping("/get")
    public Admin get(HttpServletRequest request) {
        Admin admin = adminService.findAdminById(request.getParameter("id"));
        return admin;
    }

    @RequestMapping("/edit")
    public String edit(HttpServletRequest request) {
        String password = request.getParameter("new_password");
        String tags = request.getParameter("new_tags");
        String id = request.getParameter("admin_id");

        if (InputUtil.isEmpty(id)) {
            setMsg(new Msg("error", "未知错误"));
        }
        else {
            Admin admin = adminService.findAdminById(id);
            if (admin != null) {
                if (password != null && !"".equals(password))
                    admin.setPassword(password);
                admin.setTags(InputUtil.string2tag(tags));
                adminService.saveAdmin(admin);
                setMsg(new Msg("success", "修改成功"));
            } else {
                setMsg(new Msg("error", "未知错误"));
            }
        }

        return "redirect:/sa/admins";
    }
}
