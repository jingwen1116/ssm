package com.huang.controller;


import com.huang.pojo.User;
import com.huang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService ;


    @RequestMapping("/login")
    public String login(HttpSession session, HttpServletRequest request, String username, String password){
        User user = userService.checkLogin(username, password);

        if(user!=null){
            session.setAttribute("user",user);
            System.out.println("登录成功");
            return "redirect:/toWelcome";
        }else{
            System.out.println("登录失败");
            request.setAttribute("msg",  "用户名或密码错误");
            return "login";
        }
    }

    @RequestMapping("/toWelcome")
    public String login(HttpSession session, HttpServletRequest request){
        User user = (User) session.getAttribute("user");
        System.out.println(user);

        if(user!=null){
            if(user.getUserType()==2){
                return "welcomeTea";
            }else if(user.getUserType()==1){
                return "welcomeStu";
            }
            System.out.println("跳转首页成功");
            return "welcome";
        }else{
            System.out.println("session 失效 请重新登录");
            request.setAttribute("msg",  "session 失效 请重新登录");
            return "login";
        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request){
        session.setAttribute("user",null);
        System.out.println("退出登录");
        return "redirect:/";

    }
}
