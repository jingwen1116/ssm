package com.huang.test;

import com.huang.dao.UserMapper;
import com.huang.pojo.*;
import com.huang.service.CourseService;
import com.huang.service.RoleService;
import com.huang.service.SelectCourseService;
import com.huang.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test1 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        RoleService roleMapper = context.getBean("RoleServiceImpl", RoleService.class);

        for (Role role : roleMapper.queryAllRole()) {
            System.out.println(role.toString());
        }
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean("UserServiceImpl", UserService.class);
        int userCount = userService.getUserCount(null, null);
        System.out.println(userCount);

        for (User user : userService.queryAllUser(null,null,0,5)) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CourseService courseService = context.getBean("CourseServiceImpl", CourseService.class);
        Course course = courseService.queryCourseById(2);
        System.out.println(course);
        System.out.println("==========");
        int courseCount = courseService.getCourseCount(null, null);
        System.out.println("====="+courseCount);

        List<Course> courses = courseService.queryAllCourse(null, null, 1, 5);
//        System.out.println(userCount);

        for (Course user : courses) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SelectCourseService selectCourseService = context.getBean("SelectCourseServiceImpl", SelectCourseService.class);
        List<SelectCourse> selectCourses = selectCourseService.queryAllSelectCourse(null, null, 1, 15);

        for (SelectCourse selectCours : selectCourses) {
            System.out.println(selectCours);
        }
        System.out.println("=============");

        System.out.println(selectCourseService.querySelectCourseById(2));
        System.out.println("=============");

        System.out.println(selectCourseService.getSelectCourseCount(null,null));
        System.out.println("=============");

        List<SelectCourse> selectCourses1 = selectCourseService.queryTeacherAllCourse(null, null, "kuang", 0, 15);

        for (SelectCourse selectCourse : selectCourses1) {
            System.out.println(selectCourse);
        }

        System.out.println("=============");
        System.out.println(selectCourseService.queryTeacherAllCount(null, null, "kua"));
    }
}
