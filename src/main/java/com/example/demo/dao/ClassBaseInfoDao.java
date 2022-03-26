package com.example.demo.dao;

import com.example.demo.domain.ClassBaseInfo;
import com.example.demo.util.JdbcUtils;

import java.util.List;

public interface ClassBaseInfoDao {

    List queryList();

    List queryList(Object... args);

    int updateData(Object... args);

    Object queryOne(Object... args);

    List queryListByPage(Object... args);

    void delete(Object... args);

    List queryListBySearch(Object... args);

    List getPageSizeBySearch(Object... args);

    int insertData(Object... args);
}
