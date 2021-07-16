package com.huang.service;

import com.huang.pojo.Course;
import com.huang.pojo.User;

import java.util.List;

public interface CourseService {

    //    增
    int addCourse(Course course);
    //    删
    int deleteCourse(Integer id);
    //    改
    int updateCourse(Course course);

    //    查
    List<Course> queryAllCourse(String courseName, String userName, int from, int _pageSize);

    Course queryCourseById(Integer id);

    //    查询总人数
    int getCourseCount( String courseName,String userName);

    List<Course> selectAllCourse();
}
