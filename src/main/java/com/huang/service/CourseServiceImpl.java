package com.huang.service;

import com.huang.dao.CourseMapper;
import com.huang.pojo.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseMapper courseMapper;
    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    public int deleteCourse(Integer id) {
        return courseMapper.deleteCourse(id);
    }

    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    public List<Course> queryAllCourse(String courseName, String userName, int from, int _pageSize) {
        return courseMapper.queryAllCourse(courseName,userName,from,_pageSize);
    }

    public Course queryCourseById(Integer id) {
        List<Course> courses = courseMapper.queryCourseById(id);

        return courses.get(0);
    }

    public int getCourseCount(String courseName, String userName) {
        return courseMapper.getCourseCount(courseName,userName);
    }

    public List<Course> selectAllCourse() {
        return courseMapper.selectAllCourse();
    }
}
