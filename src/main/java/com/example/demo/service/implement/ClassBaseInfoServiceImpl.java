package com.example.demo.service.implement;

import com.example.demo.dao.ClassBaseInfoDao;
import com.example.demo.dao.implement.ClassBaseInfoDaoImpl;
import com.example.demo.service.InfoService;
import com.example.demo.util.QueryUtil;

import java.text.DecimalFormat;
import java.util.List;

public class ClassBaseInfoServiceImpl implements InfoService {
    private static final ClassBaseInfoDao classBaseInfoDao = new ClassBaseInfoDaoImpl();
    @Override
    public List queryList() {
        return classBaseInfoDao.queryList();
    }

    public List queryList(Object... args) {
        return null;
    }

    @Override
    public List queryListByPage(Object... args) {
        return QueryUtil.queryListByPage(classBaseInfoDao, args);
    }

    @Override
    public int updateData(Object... args) {
        return classBaseInfoDao.updateData(args);
    }

    @Override
    public Object queryOne(Object... args) {
        return classBaseInfoDao.queryOne(args);
    }

    @Override
    public int getPageSize() {
        return QueryUtil.getPageSize(classBaseInfoDao);
    }

    @Override
    public void delete(Object... args) {
        classBaseInfoDao.delete(args);
    }

    @Override
    public List queryListBySearch(Object... args) {
        return QueryUtil.queryListBySearch(classBaseInfoDao, args);
    }

    @Override
    public int insertData(Object... args) {
        return classBaseInfoDao.insertData(args);
    }

    @Override
    public Integer getPageSizeBySearch(String reqParam) {
        return QueryUtil.getPageSizeBySearch(classBaseInfoDao, reqParam);
    }

    @Override
    public String joint(Object... args) {
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("00");
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof String) {
                Integer integer = Integer.valueOf((String) args[i]);
                stringBuilder.append(decimalFormat.format(integer));
            } else if (args[i] instanceof Integer) {
                stringBuilder.append(decimalFormat.format(args[i]));
            }
            if (i < args.length - 1) {
                stringBuilder.append("-");
            }
        }
        return String.valueOf(stringBuilder);
    }
}
