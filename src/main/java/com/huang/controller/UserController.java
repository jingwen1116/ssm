package com.huang.controller;

import com.huang.pojo.Role;
import com.huang.pojo.User;
import com.huang.service.RoleService;
import com.huang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService ;

    @Autowired
    @Qualifier("RoleServiceImpl")
    private RoleService roleService ;

    private int _pageSize=10;

//    查询全部的数据
    @RequestMapping("/queryUser")
    public String queryUser(String queryUserName, Integer userType, Integer pageIndex, Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<User> userList;
        List<Role> roleList;
        int userCount=0;

        System.out.println("进入了queryUser");

        if(user.getUserType()==2){
            userCount = userService.getUserCount(queryUserName, 1);
        }else {
            userCount = userService.getUserCount(queryUserName, userType);
        }

        System.out.println(userCount);

        Integer totalPage=null;
        if(userCount==0) totalPage=1;
        else {
            if(userCount%_pageSize==0) totalPage=userCount/_pageSize;
            else totalPage=userCount/_pageSize+1;
        }

        //初始记录= (pageIndex-1)*_pageSize
        if(pageIndex==null || pageIndex<1) {pageIndex=1;} //初始值
        //有效范围，不能小于1，不能大于 总页数
        if(pageIndex>totalPage) pageIndex=totalPage;

        int from =(pageIndex-1)*_pageSize;


        if(user.getUserType()==2){
            userList=userService.queryAllUser(queryUserName,1, from, _pageSize);
            roleList = roleService.queryRoleByType(1);
        }else {
            userList=userService.queryAllUser(queryUserName,userType, from, _pageSize);
            roleList = roleService.queryAllRole();
        }


        model.addAttribute("roleList",roleList);
        for (Role role : roleList) {
            System.out.println(role.toString());
        }
        model.addAttribute("userlist",userList);
        model.addAttribute("totalCount", userCount);
        model.addAttribute("currentPageNo", pageIndex);
        model.addAttribute("totalPageCount", totalPage);

        if(user.getUserType()==0){
            return "listUser";
        }else if(user.getUserType()==2){
            return "listUserTea";
        }else {
            model.addAttribute("msg","访问有误");
            return "login";
        }

    }

//    跳转添加页面
    @RequestMapping("/toAddUser")
    public String toAddUser(Model model ,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<Role> roleList = roleService.queryAllRole();
        model.addAttribute("roleList",roleList);
        if(user.getUserType()==0){
            return "userAdd";
        }else {
            model.addAttribute("user",user);
            return "userAddTea";
        }

    }

//    添加用户
    @RequestMapping("/addUser")
    public String AddUser(User user,Model model){

        System.out.println(user.toString());

        int count = userService.addUser(user);

        if(count>0){
//            请求重定向是到 查询的请求
            return "redirect:/user/queryUser";
        }else {
            return "userAdd";
        }
    }

//    跳转更新用户
    @RequestMapping("/toUpdateUser")
    public String toUpdateUser(HttpServletRequest request,Integer id,Model model) {
        User thisUser = userService.queryUserById(id);
        User user = (User) request.getSession().getAttribute("user");

        List<Role> roleList;
        System.out.println(user.toString());
        if(user.getUserType()==0){
            roleList = roleService.queryAllRole();
        }else {
            roleList = roleService.queryRoleByType(1);
        }

        for (Role role : roleList) {
            System.out.println(role);
        }

        model.addAttribute("roleList",roleList);
        model.addAttribute("thisUser",thisUser);

        if(user.getUserType()==0){
            return "userUpdate";
        }else {
            return "userUpdateTea";
        }

    }


//    更新用户
    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        System.out.println(user);
        int count = userService.updateUser(user);

        if(count>0){
            return "redirect:/user/queryUser";
        }else {
            return "toUpdateUser";
        }
    }

//    删除用户
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer id,Model model) {
        int count = userService.deleteUser(id);

        if(count>0){
            return "redirect:/user/queryUser";
        }else {
            model.addAttribute("msg","删除失败");
            return "queryUser";
        }
    }
}
