package me.zacharyjia.fuckexcel.controller.superadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by zachary on 16/7/10.
 */
@Controller
@RequestMapping("/sa/tags")
public class TagsController extends BaseSaController {
    @Autowired
    private HttpSession session;

    @RequestMapping("")
    public String tags(ModelMap map) {
        if (!authCheck()) {
            session.setAttribute("msg", "权限不足");
        }

        map.addAttribute("superAdmin", getLoginSuperAdmin());

        return "sa/tags";
    }
}
