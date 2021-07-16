package com.huang.dao;

import com.huang.pojo.SelectCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectCourseMapper {
    //    增
    int addSelectCourse(SelectCourse selectCourse);
    //    删
    int deleteSelectCourse(@Param("id")Integer id);
    //    改
    int updateSelectCourse(SelectCourse selectCourse);

//    查

    List<SelectCourse> queryAllSelectCourse(@Param("course_name") String courseName, @Param("userName")String userName, @Param("from")int from, @Param("pageSize")int pageSize);

    List<SelectCourse> querySelectCourseById(@Param("id")Integer id);

    List<SelectCourse> queryTeacherAllCourse(@Param("course_name") String courseName, @Param("userName")String userName,@Param("user_code")String userCode, @Param("from")int from, @Param("pageSize")int pageSize);


    //    得出多少条记录
    int getSelectCourseCount(@Param("course_name") String courseName, @Param("userName")String userName);

    //    得出多少条记录
    int queryTeacherAllCount(@Param("course_name") String courseName, @Param("userName")String userName,@Param("user_code")String userCode);


}
