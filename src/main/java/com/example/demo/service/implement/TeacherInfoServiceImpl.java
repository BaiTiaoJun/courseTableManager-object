package com.example.demo.service.implement;

import com.example.demo.dao.TeacherInfoDao;
import com.example.demo.dao.implement.TeacherInfoDaoImpl;
import com.example.demo.service.InfoService;
import com.example.demo.util.QueryUtil;

import java.util.List;

public class TeacherInfoServiceImpl implements InfoService {
    private static final TeacherInfoDao teacherInfoDao = new TeacherInfoDaoImpl();
    @Override
    public List queryList() {
        return teacherInfoDao.queryList();
    }

    @Override
    public List queryList(Object... args) {
        return teacherInfoDao.queryList(args);
    }

    @Override
    public int updateData(Object... args) {
        return teacherInfoDao.updateData(args);
    }

    @Override
    public Object queryOne(Object... args) {
        return teacherInfoDao.queryOne(args);
    }

    @Override
    public int getPageSize() {
        return QueryUtil.getPageSize(teacherInfoDao);
    }

    @Override
    public void delete(Object... args) {
        teacherInfoDao.delete(args);
    }

    @Override
    public List queryListBySearch(Object... condition) {
        return QueryUtil.queryListBySearch(teacherInfoDao, condition);
    }

    @Override
    public int insertData(Object... args) {
        return teacherInfoDao.insertData(args);
    }

    @Override
    public Integer getPageSizeBySearch(String reqParam) {
        return QueryUtil.getPageSizeBySearch(teacherInfoDao, reqParam);
    }

    @Override
    public List queryListByPage(Object... args) {
        return QueryUtil.queryListByPage(teacherInfoDao, args);
    }
}