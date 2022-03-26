package com.example.demo.service.implement;

import com.example.demo.dao.StudentInfoDao;
import com.example.demo.dao.implement.StudentInfoDaoImpl;
import com.example.demo.domain.StudentInfo;
import com.example.demo.service.InfoService;
import com.example.demo.util.QueryUtil;

import java.text.DecimalFormat;
import java.util.List;

public class StudentInfoServiceImpl implements InfoService {
    private static final StudentInfoDao studentInfoDao = new StudentInfoDaoImpl();

    @Override
    public List queryList() {
        return studentInfoDao.queryList();
    }

    @Override
    public List queryList(Object... args) {
        return null;
    }

    @Override
    public int updateData(Object... args) {
        return studentInfoDao.updateData(args);
    }

    @Override
    public Object queryOne(Object... args) {
        return studentInfoDao.queryOne(args);
    }

    @Override
    public int getPageSize() {
        return QueryUtil.getPageSize(studentInfoDao);
    }

    @Override
    public void delete(Object... args) {
        studentInfoDao.delete(args);
    }

    @Override
    public List queryListBySearch(Object... condition) {
        return QueryUtil.queryListBySearch(studentInfoDao, condition);
    }

    @Override
    public int insertData(Object... args) {
        return studentInfoDao.insertData(args);
    }

    @Override
    public Integer getPageSizeBySearch(String reqParam) {
        return QueryUtil.getPageSizeBySearch(studentInfoDao, reqParam);
    }

    @Override
    public List queryListByPage(Object... args) {
        return QueryUtil.queryListByPage(studentInfoDao, args);
    }

    @Override
    public String joint(Object... args) {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        String selMonth = decimalFormat.format(Integer.valueOf((String) args[4]));
        String selDay = decimalFormat.format(Integer.valueOf((String) args[5]));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(args[3]);
        stringBuilder.append("-").append(selMonth);
        stringBuilder.append("-").append(selDay);
        return String.valueOf(stringBuilder);
    }

    public String getClassNo(String username) {
        StudentInfo studentInfo = (StudentInfo) studentInfoDao.queryOne(username);
        return studentInfo.getSclass();
    }
}