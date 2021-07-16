package com.huang.service;

import com.huang.dao.SelectCourseMapper;
import com.huang.pojo.SelectCourse;
import org.springframework.stereotype.Service;

import java.util.List;


public class SelectCourseServiceImpl implements SelectCourseService {

    private SelectCourseMapper selectCourseMapper;

    public void setSelectCourseMapper(SelectCourseMapper selectCourseMapper) {
        this.selectCourseMapper = selectCourseMapper;
    }

    public int addSelectCourse(SelectCourse selectCourse) {
        return selectCourseMapper.addSelectCourse(selectCourse);
    }

    public int deleteSelectCourse(Integer id) {
        return selectCourseMapper.deleteSelectCourse(id);
    }

    public int updateSelectCourse(SelectCourse selectCourse) {
        return selectCourseMapper.updateSelectCourse(selectCourse);
    }

    public List<SelectCourse> queryAllSelectCourse(String courseName, String userName, int from, int _pageSize) {
        return selectCourseMapper.queryAllSelectCourse(courseName,userName,from,_pageSize);
    }

    public List<SelectCourse> queryTeacherAllCourse(String courseName, String userName, String userCode, int from, int pageSize) {
        return selectCourseMapper.queryTeacherAllCourse(courseName,userName,userCode,from,pageSize);
    }

    public SelectCourse querySelectCourseById(Integer id) {

        return selectCourseMapper.querySelectCourseById(id).get(0);
    }

    public int getSelectCourseCount(String courseName, String userName) {
        return selectCourseMapper.getSelectCourseCount(courseName,userName);
    }

    public int queryTeacherAllCount(String courseName, String userName, String userCode) {
        return selectCourseMapper.queryTeacherAllCount(courseName,userName,userCode);
    }

}
