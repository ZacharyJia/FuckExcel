package me.zacharyjia.fuckexcel.controller.superadmin;

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

    boolean authCheck() {
        User user = (User) session.getAttribute("user");
        if (user == null || !(user instanceof SuperAdmin)) {
            return false;
        }
        return true;
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
