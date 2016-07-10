package me.zacharyjia.fuckexcel.controller.admin;

import me.zacharyjia.fuckexcel.common.Msg;
import me.zacharyjia.fuckexcel.model.Admin;
import me.zacharyjia.fuckexcel.model.SuperAdmin;
import me.zacharyjia.fuckexcel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * Created by zachary on 16/7/10.
 */
@Controller
public class BaseAdminController {

    @Autowired
    private HttpSession session;

    void setMsg(Msg msg) {
        session.setAttribute("msg", msg);
    }

    String authCheck() {
        User user = (User) session.getAttribute("user");
        if (user == null || !(user instanceof Admin)) {
            setMsg(new Msg("error", "权限不足"));
            return "redirect:/login";
        }
        return null;
    }

    Admin getLoginAdmin() {
        User user = (User) session.getAttribute("user");
        if (user != null && user instanceof Admin) {
            return (Admin) user;
        } else {
            return null;
        }
    }
}
