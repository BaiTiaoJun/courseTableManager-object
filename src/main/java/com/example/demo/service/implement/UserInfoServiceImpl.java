package com.example.demo.service.implement;

import com.example.demo.dao.UserInfoDao;
import com.example.demo.dao.implement.UserInfoDaoImpl;
import com.example.demo.service.InfoService;
import com.example.demo.util.QueryUtil;

import java.util.List;

public class UserInfoServiceImpl implements InfoService {
    private static final UserInfoDao userInfoDao = new UserInfoDaoImpl();
    @Override
    public List queryList() {
        return userInfoDao.queryList();
    }

    @Override
    public List queryList(Object... args) {
        return null;
    }

    @Override
    public int updateData(Object... args) {
        return userInfoDao.updateData(args);
    }

    @Override
    public Object queryOne(Object... args) {
        return userInfoDao.queryOne(args);
    }

    @Override
    public int getPageSize() {
        return QueryUtil.getPageSize(userInfoDao);
    }

    @Override
    public void delete(Object... args) {
        userInfoDao.delete(args);
    }

    @Override
    public List queryListBySearch(Object... args) {
        return null;
    }

    @Override
    public int insertData(Object... args) {
        return userInfoDao.insertData(args);
    }

    @Override
    public Integer getPageSizeBySearch(String reqParam) {
        return null;
    }

    @Override
    public List queryListByPage(Object... args) {
        return QueryUtil.queryListByPage(userInfoDao, args);
    }

    @Override
    public Object queryOneByUsername(String username) {
        return userInfoDao.queryOneByUsername(username);
    }

    @Override
    public Integer updateAllDataByUsername(Object... args) {
        return userInfoDao.updateAllDataByUsername(args);
    }

}