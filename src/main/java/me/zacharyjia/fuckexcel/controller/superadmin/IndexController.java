package me.zacharyjia.fuckexcel.controller.superadmin;

import me.zacharyjia.fuckexcel.model.SuperAdmin;
import me.zacharyjia.fuckexcel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by zachary on 16/7/10.
 */
@Controller
@RequestMapping("/sa")
public class IndexController extends BaseSaController {

    @Autowired
    private HttpSession session;

    @RequestMapping("/home")
    public String home(ModelMap map) {
        if (!authCheck()) {
            session.setAttribute("msg", "权限不足");
            return "redirect:/login";
        }

        map.addAttribute("superAdmin", getLoginSuperAdmin());

        return "sa/home";
    }

}
