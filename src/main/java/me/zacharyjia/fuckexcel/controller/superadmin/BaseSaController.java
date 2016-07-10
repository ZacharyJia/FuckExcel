package me.zacharyjia.fuckexcel.controller.superadmin;

import me.zacharyjia.fuckexcel.common.Msg;
import me.zacharyjia.fuckexcel.model.SuperAdmin;
import me.zacharyjia.fuckexcel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

/**
 * Created by zachary on 16/7/10.
 */
@Controller
class BaseSaController {

    @Autowired
    private HttpSession session;

    void setMsg(Msg msg) {
        session.setAttribute("msg", msg);
    }

    String authCheck() {
        User user = (User) session.getAttribute("user");
        if (user == null || !(user instanceof SuperAdmin)) {
            setMsg(new Msg("error", "权限不足"));
            return "redirect:/login";
        }
        return null;
    }

    SuperAdmin getLoginSuperAdmin() {
        User user = (User) session.getAttribute("user");
        if (user != null && user instanceof SuperAdmin) {
            return (SuperAdmin) user;
        } else {
            return null;
        }
    }

}
