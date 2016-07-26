package me.zacharyjia.fuckexcel.controller.superadmin;

import me.zacharyjia.fuckexcel.common.Msg;
import me.zacharyjia.fuckexcel.model.User;
import me.zacharyjia.fuckexcel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zachary on 16/7/10.
 */
@Controller("saUsers")
@RequestMapping("/sa/users")
public class UsersController extends BaseSaController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserService userService;


    private String result;

    @RequestMapping("")
    public String users(HttpServletRequest request, ModelMap map) {
        if ((result = authCheck()) != null) {
            return result;
        }

        String offsetStr = request.getParameter("offset");
        int offset = 0;
        if (offsetStr != null) {
            offset = Integer.parseInt(offsetStr);
        }
        map.addAttribute("superAdmin", getLoginSuperAdmin());
        map.addAttribute("msg", session.getAttribute("msg"));
        session.removeAttribute("msg");

        List<User> userList = userService.findUsers(10, offset);
        map.addAttribute("userList", userList);
        long userCount = userService.getUserCount();

        return "sa/users";
    }
}
