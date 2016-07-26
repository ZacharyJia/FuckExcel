package me.zacharyjia.fuckexcel.controller.admin;

import me.zacharyjia.fuckexcel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zachary on 16/7/23.
 */
@Controller("adminIndex")
@RequestMapping("/admin")
public class IndexController extends BaseAdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/home")
    public String index(ModelMap map) {
        String result;
        if ((result = authCheck()) != null) {
            return result;
        }
        map.addAttribute("admin", getLoginAdmin());
        return "admin/home";
    }

}
