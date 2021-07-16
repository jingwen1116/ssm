package com.huang.controller;

import com.huang.pojo.Course;
import com.huang.pojo.SelectCourse;
import com.huang.pojo.User;
import com.huang.service.CourseService;
import com.huang.service.SelectCourseService;
import com.huang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/selectCourse")
public class SelectCourseController {

    @Autowired
    @Qualifier("SelectCourseServiceImpl")
    private SelectCourseService selectCourseService ;

    @Autowired
    @Qualifier("CourseServiceImpl")
    private CourseService courseService ;

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService ;

    private int _pageSize=10;
    @RequestMapping("/querySelectCourse")
    public String querySelectCourse(String courseName, String userName, Integer pageIndex, Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<SelectCourse> selectCourseList;
        int userCount=0;

        if(user.getUserType()==0) {
            userCount=selectCourseService.getSelectCourseCount(courseName, userName);
        }else if(user.getUserType()==2){
            userCount=selectCourseService.queryTeacherAllCount(courseName, userName,user.getUserCode());
        }else {
            userCount=selectCourseService.getSelectCourseCount(courseName, user.getUserName());
        }

        System.out.println("进入了querySelectCourse");

        System.out.println(userCount);

//        分页设置
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
            selectCourseList = selectCourseService.queryAllSelectCourse(courseName,userName,from,_pageSize);
        }else if(user.getUserType()==2){
            selectCourseList = selectCourseService.queryTeacherAllCourse(courseName,userName,user.getUserCode(),from,_pageSize);
        }else {
            selectCourseList = selectCourseService.queryAllSelectCourse(courseName,user.getUserName(),from,_pageSize);
        }


        model.addAttribute("selectCourseList",selectCourseList);
        model.addAttribute("totalCount", userCount);
        model.addAttribute("currentPageNo", pageIndex);
        model.addAttribute("totalPageCount", totalPage);

        if(user.getUserType()==0){
            return "listSelectCourse";
        }else if(user.getUserType()==2){
            model.addAttribute("user",user);
            return "listSelectCourseTea";
        }else {
            model.addAttribute("user",user);
            return "listSelectCourseStu";
        }
    }


    //    跳转添加页面
    @RequestMapping("/toAddSelectCourse")
    public String toAddSelectCourse(Model model,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");

        List<User> userList = userService.queryAllType(1);
        List<Course> courseList = courseService.selectAllCourse();

        model.addAttribute("user",user);
        model.addAttribute("userList",userList);
        model.addAttribute("courseList",courseList);
        if(user.getUserType()==2){
            return "selectCourseAddTea";
        }else if (user.getUserType()==0){
            return "selectCourseAdd";
        }else {
            return "selectCourseAddStu";
        }
    }

    //    添加课程
    @RequestMapping("/addSelectCourse")
    public String AddSelectCourse(SelectCourse selectCourse,Model model){

        System.out.println(selectCourse.toString());

        int count = selectCourseService.addSelectCourse(selectCourse);

        if(count>0){
//            请求重定向是到 查询的请求
            return "redirect:/selectCourse/querySelectCourse";
        }else {
            return "selectCourseAdd";
        }
    }


    //    跳转更新课程
    @RequestMapping("/toUpdateSelectCourse")
    public String toUpdateSelectCourse(HttpServletRequest request,Integer sid,Integer id,Model model) {
        User user = (User) request.getSession().getAttribute("user");
        System.out.println("sid:"+sid+"id"+id);
        User thisUser = userService.queryUserById(sid);
        System.out.println("-------");
        List<Course> courseList = courseService.selectAllCourse();
        System.out.println("+++++++");
        SelectCourse selectCourse = selectCourseService.querySelectCourseById(id);
        System.out.println("========");

        model.addAttribute("courseList",courseList);
        model.addAttribute("thisUser",thisUser);
        model.addAttribute("selectCourse",selectCourse);
        model.addAttribute("user",user);
        if(user.getUserType()==0){
            return "selectCourseUpdate";
        }else if(user.getUserType()==2){
            return "selectCourseUpdateTea";
        }else {
            return "selectCourseUpdateStu";
        }

    }


    //    更新课程
    @RequestMapping("/updateSelectCourse")
    public String updateSelectCourse(SelectCourse selectCourse) {
        System.out.println(selectCourse);
        int count = selectCourseService.updateSelectCourse(selectCourse);

        if(count>0){
            return "redirect:/selectCourse/querySelectCourse";
        }else {
            return "toUpdateSelectCourse";
        }
    }

    //    删除选课
    @RequestMapping("/deleteSelectCourse")
    public String deleteSelectCourse(Integer id,Model model) {
        System.out.println(id);
        int count = selectCourseService.deleteSelectCourse(id);

        if(count>0){
            return "redirect:/selectCourse/querySelectCourse";
        }else {
            model.addAttribute("msg","删除失败");
            return "querySelectCourse";
        }
    }

}
