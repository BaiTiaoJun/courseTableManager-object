package com.example.demo.dao;

import java.util.List;

public interface UserInfoDao {
    List queryList();

    List queryList(Object... args);

    int updateData(Object... args);

    Object queryOne(Object... args);

    List queryListByPage(Object... args);

    void delete(Object... args);

    List queryListBySearch(Object... args);

    List getPageSizeBySearch(Object... args);

    int insertData(Object... args);

    Object queryOneByUsername(String username);

    Integer updateAllDataByUsername(Object... args);
}
