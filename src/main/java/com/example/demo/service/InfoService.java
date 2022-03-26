package com.example.demo.service;

import com.example.demo.domain.CourseTableInfo;

import java.util.List;

public interface InfoService {
    List queryList();

    List queryList(Object... args);

    int updateData(Object... args);

    Object queryOne(Object... args);

    List queryListByPage(Object... args);

    int getPageSize();

    void delete(Object... args);

    Integer getPageSizeBySearch(String reqParam);

    List queryListBySearch(Object... condition);

    int insertData(Object... args);

    default List<String> getCourseTableInfosTimeList (List<CourseTableInfo> list) {
        return null;
    }

    default List<String> removeRepeatTime(List<String> strList) {
        return null;
    }

    default String[] getTime(String ctbTime) {
        return null;
    }

    default Object queryOneByUsername(String username) {
        return null;
    }

    default Integer updateAllDataByUsername(Object...args) {
        return 0;
    }

    default String joint (Object... args) {
        return null;
    }

    default String getClassNo(String username) {
        return null;
    }

    default List sortedSelWeek(List<String> list){
        return list;
    }

    default List getWeek(Object... args) {
        return null;
    }
}
