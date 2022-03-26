package com.example.demo.service.implement;

import com.example.demo.dao.CourseBaseInfoDao;
import com.example.demo.dao.implement.CourseBaseInfoDaoImpl;
import com.example.demo.service.InfoService;
import com.example.demo.util.QueryUtil;

import java.util.List;

public class CourseBaseInfoServiceImpl implements InfoService {
    private static final CourseBaseInfoDao courseBaseInfoDao = new CourseBaseInfoDaoImpl();
    @Override
    public List queryList() {
        return courseBaseInfoDao.queryList();
    }

    public List queryList(Object... args) {
        return courseBaseInfoDao.queryList(args);
    }

    @Override
    public int updateData(Object... args) {
        return courseBaseInfoDao.updateData(args);
    }

    @Override
    public Object queryOne(Object... args) {
        return courseBaseInfoDao.queryOne(args);
    }

    @Override
    public int getPageSize() {
        return QueryUtil.getPageSize(courseBaseInfoDao);
    }

    @Override
    public void delete(Object... args) {
        courseBaseInfoDao.delete(args);
    }

    @Override
    public List queryListBySearch(Object... args) {
        return QueryUtil.queryListBySearch(courseBaseInfoDao, args);
    }

    @Override
    public int insertData(Object... args) {
        return courseBaseInfoDao.insertData(args);
    }

    @Override
    public Integer getPageSizeBySearch(String reqParam) {
        return QueryUtil.getPageSizeBySearch(courseBaseInfoDao, reqParam);
    }

    @Override
    public List queryListByPage(Object... args) {
        return QueryUtil.queryListByPage(courseBaseInfoDao, args);
    }
}
