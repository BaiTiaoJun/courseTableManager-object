package com.example.demo.service.implement;

import com.example.demo.dao.ClassroomInfoDao;
import com.example.demo.dao.implement.ClassroomInfoDaoImpl;
import com.example.demo.service.InfoService;
import com.example.demo.util.QueryUtil;

import java.util.List;

public class ClassroomInfoServiceImpl implements InfoService {
    private static final ClassroomInfoDao classroomInfoDao = new ClassroomInfoDaoImpl();
    @Override
    public List queryList() {
        return classroomInfoDao.queryList();
    }

    public List queryList(Object... args) {
        return null;
    }

    @Override
    public int updateData(Object... args) {
        return classroomInfoDao.updateData(args);
    }

    @Override
    public Object queryOne(Object... args) {
        return classroomInfoDao.queryOne(args);
    }

    @Override
    public int getPageSize() {
        return QueryUtil.getPageSize(classroomInfoDao);
    }

    @Override
    public void delete(Object... args) {
        classroomInfoDao.delete(args);
    }

    @Override
    public List queryListBySearch(Object... args) {
        return QueryUtil.queryListBySearch(classroomInfoDao, args);
    }

    @Override
    public int insertData(Object... args) {
        return classroomInfoDao.insertData(args);
    }

    @Override
    public Integer getPageSizeBySearch(String reqParam) {
        return QueryUtil.getPageSizeBySearch(classroomInfoDao, reqParam);
    }

    @Override
    public List queryListByPage(Object... args) {
        return QueryUtil.queryListByPage(classroomInfoDao, args);
    }
}
