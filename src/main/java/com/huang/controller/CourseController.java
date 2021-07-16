package com.huang.controller;

import com.huang.pojo.Course;
import com.huang.pojo.Role;
import com.huang.pojo.User;
import com.huang.service.CourseService;
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
@RequestMapping("/course")
public class CourseController {

    @Autowired
    @Qualifier("CourseServiceImpl")
    private CourseService courseService ;

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService ;


    private int _pageSize=10;
    @RequestMapping("/queryCourse")
    public String queryCourse(String courseName, String userName, Integer pageIndex, Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<Course> courseList;
        int userCount=0;

        if(user.getUserType()==0) {
            userCount = courseService.getCourseCount(courseName, userName);
        }else {
            userCount = courseService.getCourseCount(courseName, user.getUserName());
        }
        System.out.println("进入了querySelcetCourse");
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

        if(user.getUserType()==0){
            courseList = courseService.queryAllCourse(courseName, userName, from, _pageSize);
        }else {
            courseList = courseService.queryAllCourse(courseName, user.getUserName(), from, _pageSize);
        }


        model.addAttribute("user",user);
        model.addAttribute("courseList",courseList);
        model.addAttribute("totalCount", userCount);
        model.addAttribute("currentPageNo", pageIndex);
        model.addAttribute("totalPageCount", totalPage);

        if(user.getUserType()==0){
            return "listCourse";
        }else if(user.getUserType()==2){
            return "listCourseTea";
        }else {
            model.addAttribute("msg","访问有误");
            return "login";
        }
    }

    //    跳转添加页面
    @RequestMapping("/toAddCourse")
    public String toAddCourse(HttpServletRequest request,Model model){
        User user = (User) request.getSession().getAttribute("user");
        List<User> userList = userService.queryAllType(2);

        model.addAttribute("user",user);
        model.addAttribute("userList",userList);
        if(user.getUserType()==0){
            return "courseAdd";
        }else {
            return "courseAddTea";
        }

    }

    //    添加课程
    @RequestMapping("/addCourse")
    public String AddCourse(Course course,Model model){
        System.out.println(course.toString());

        int count = courseService.addCourse(course);

        if(count>0){
//            请求重定向是到 查询的请求
            return "redirect:/course/queryCourse";
        }else {
            return "courseAdd";
        }
    }

    //    跳转更新课程
    @RequestMapping("/toUpdateCourse")
    public String toUpdateCourse(HttpServletRequest request,Integer cid,Model model) {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println("进入了个人的:"+cid);
        List<User> userList = userService.queryAllType(2);

        Course course = courseService.queryCourseById(cid);
        System.out.println("课程为："+course);

        model.addAttribute("userList",userList);
        model.addAttribute("course",course);
        if(user.getUserType()==0){
            return "courseUpdate";
        }else {
            return "courseUpdateTea";
        }

    }


    //    更新课程
    @RequestMapping("/updateCourse")
    public String updateCourse(Course course) {
        System.out.println(course);
        int count = courseService.updateCourse(course);

        if(count>0){
            return "redirect:/course/queryCourse";
        }else {
            return "toUpdateCourse";
        }
    }

    //    删除用户
    @RequestMapping("/deleteCourse")
    public String deleteCourse(Integer cid,Model model) {
        int count = courseService.deleteCourse(cid);

        if(count>0){
            return "redirect:/course/queryCourse";
        }else {
            model.addAttribute("msg","删除失败");
            return "queryCourse";
        }
    }
}
