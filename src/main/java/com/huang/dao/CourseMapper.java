package com.huang.dao;

import com.huang.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    //    增
    int addCourse(Course course);
    //    删
    int deleteCourse(@Param("cid")Integer cid);
    //    改
    int updateCourse(Course course);

//    查

    List<Course> queryAllCourse(@Param("course_name") String courseName, @Param("userName")String userName, @Param("from")int from, @Param("pageSize")int pageSize);

    List<Course> queryCourseById(@Param("cid")Integer cid);

    //    得出多少条记录
    int getCourseCount(@Param("course_name") String courseName, @Param("userName")String userName);

//    查询全部课程
    List<Course> selectAllCourse();
}
