package com.huang.service;

import com.huang.pojo.Course;
import com.huang.pojo.SelectCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectCourseService {

    //    增
    int addSelectCourse(SelectCourse selectCourse);
    //    删
    int deleteSelectCourse(Integer id);
    //    改
    int updateSelectCourse(SelectCourse selectCourse);

    //    查
    List<SelectCourse> queryAllSelectCourse(String courseName, String userName, int from, int _pageSize);

    List<SelectCourse> queryTeacherAllCourse(String courseName,String userName, String userCode, int from,int pageSize);


    SelectCourse querySelectCourseById(Integer id);

    //    查询总人数
    int getSelectCourseCount(String courseName, String userName);

    //    得出多少条记录
    int queryTeacherAllCount(String courseName,String userName,String userCode);

}
