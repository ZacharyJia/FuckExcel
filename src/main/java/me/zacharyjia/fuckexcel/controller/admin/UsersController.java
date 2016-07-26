package me.zacharyjia.fuckexcel.controller.admin;

import me.zacharyjia.fuckexcel.common.InputUtil;
import me.zacharyjia.fuckexcel.common.Msg;
import me.zacharyjia.fuckexcel.model.Admin;
import me.zacharyjia.fuckexcel.model.User;
import me.zacharyjia.fuckexcel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by zachary on 16/7/23.
 */
@Controller("adminUsers")
@RequestMapping("/admin/users")
public class UsersController extends BaseAdminController {

    public static final int ITEM_COUNT = 20;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @RequestMapping("")
    public String index(ModelMap map, HttpServletRequest request) {
        String result;
        if ((result = authCheck()) != null) {
            return result;
        }
        map.addAttribute("admin", getLoginAdmin());
        map.addAttribute("msg", session.getAttribute("msg"));
        session.removeAttribute("msg");

        String page_str = request.getParameter("page");
        int page = 1;
        if (page_str != null) {
            try {
                page = Integer.valueOf(page_str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        List<User> userList = userService.findUsers(ITEM_COUNT, (page - 1) * ITEM_COUNT);
        map.addAttribute("userList", userList);

        long count = userService.getUserCount();
        map.addAttribute("userCount", count);

        return "admin/users";
    }

    @RequestMapping("add")
    public String add(HttpServletRequest request) {
        String result;
        if ((result = authCheck()) != null) {
            return result;
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tags = request.getParameter("tags");

        if (InputUtil.isEmpty(username, password) && tags != null) {
            setMsg(new Msg("error", "用户名、密码不能为空"));
            return "redirect:/admin/users";
        }
        Set<String> set = InputUtil.string2tag(tags);
        if (set == null)
            set = new HashSet<String>();
        if (!set.contains(username)) {
            set.add(username);
        }
        set.remove("");

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(username);
        user.setPassword(password);
        user.setTags(set);
        if (userService.createUser(user)) {
            setMsg(new Msg("success", "添加成功"));
        }
        else {
            setMsg(new Msg("error", "添加失败,用户名可能已经存在"));
        }
        return "redirect:/admin/users";
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request) {
        String result;
        if ((result = authCheck()) != null) {
            return result;
        }

        String id = request.getParameter("id");
        if (id != null && !"".equals(id)) {
            userService.deleteById(id);
            setMsg(new Msg("success", "删除成功"));
        } else {
            setMsg(new Msg("error", "参数错误,请稍后重试"));
        }

        return "redirect:/admin/users";
    }

    @ResponseBody
    @RequestMapping("get")
    public User get(HttpServletRequest request) {
        User user = userService.findUserById(request.getParameter("id"));
        return user;
    }

    @RequestMapping("edit")
    public String edit(HttpServletRequest request) {
        String result;
        if ((result = authCheck()) != null) {
            return result;
        }

        String password = request.getParameter("new_password");
        String tags = request.getParameter("new_tags");
        String id = request.getParameter("user_id");

        if (InputUtil.isEmpty(id)) {
            setMsg(new Msg("error", "未知错误"));
        }
        else {
            User user = userService.findUserById(id);
            if (user != null) {
                if (password != null && !"".equals(password))
                    user.setPassword(password);
                user.setTags(InputUtil.string2tag(tags));
                userService.saveUser(user);
                setMsg(new Msg("success", "修改成功"));
            } else {
                setMsg(new Msg("error", "未知错误"));
            }
        }

        return "redirect:/admin/users";
    }
}
