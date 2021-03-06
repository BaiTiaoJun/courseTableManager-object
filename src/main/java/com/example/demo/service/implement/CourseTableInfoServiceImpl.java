package com.example.demo.service.implement;

import com.example.demo.dao.CourseTableInfoDao;
import com.example.demo.dao.implement.CourseTableInfoDaoImpl;
import com.example.demo.domain.CourseTableInfo;
import com.example.demo.service.InfoService;
import com.example.demo.util.QueryUtil;

import java.util.*;

public class CourseTableInfoServiceImpl implements InfoService {
    private static final CourseTableInfoDao courseTableInfoDao = new CourseTableInfoDaoImpl();
    @Override
    public List queryList() {
        return courseTableInfoDao.queryList();
    }

    @Override
    public List queryList(Object... obj) {
        return courseTableInfoDao.queryList(obj);
    }

    @Override
    public int updateData(Object... args) {
        return courseTableInfoDao.updateData(args);
    }

    @Override
    public Object queryOne(Object... args) {
        return courseTableInfoDao.queryOne(args);
    }

    @Override
    public List queryListByPage(Object... args) {
        return QueryUtil.queryListByPage(courseTableInfoDao, args);
    }

    public List<String> getCourseTableInfosTimeList (List<CourseTableInfo> list) {
        List<String> strList = new ArrayList<>();
        for (CourseTableInfo courseTableInfo:list) {
            String str =  courseTableInfo.getTime().trim().substring(0, 3);
            strList.add(str);
        }
        return strList;
    }

    public List<String> removeRepeatTime(List<String> strList) {
        List<String> list1 = new ArrayList<>();
        for (String strings:strList) {
            if (!list1.contains(strings)) {
                list1.add(strings);
            }
        }
        return list1;
    }

    @Override
    public int getPageSize() {
        return QueryUtil.getPageSize(courseTableInfoDao);
    }

    @Override
    public void delete(Object... args) {
        courseTableInfoDao.delete(args);
    }

    @Override
    public List queryListBySearch(Object... condition) {
        return QueryUtil.queryListBySearch(courseTableInfoDao, condition);
    }

    @Override
    public int insertData(Object... args) {
        return courseTableInfoDao.insertData(args);
    }

    @Override
    public Integer getPageSizeBySearch(String reqParam) {
        return QueryUtil.getPageSizeBySearch(courseTableInfoDao, reqParam);
    }

    @Override
    public String[] getTime(String ctbTime) {
        String[] time = ctbTime.trim().split("???");
        return time;
    }

    @Override
    public String joint(Object... args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            stringBuilder.append(args[i]);
            if (i < args.length - 1) {
                stringBuilder.append("???");
            }
        }
        return String.valueOf(stringBuilder);
    }

    public List sortedSelWeek(List<String> list) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list1 = new ArrayList<>();
        String[] weeks = {"?????????","?????????","?????????","?????????","?????????","?????????","?????????","?????????","?????????","?????????",
                "????????????","????????????","????????????","????????????","????????????","????????????","????????????"};
        for (String string:list) {
            for (int i = 0; i < weeks.length; i++) {
                if (string.equals(weeks[i])) {
                    map.put(i + 1, string);
                }
            }
        }
        for (int j = 0; j < weeks.length; j++) {
            String value = map.get(j + 1);
            if (value != null) {
                list1.add(value);
            }
        }
        return list1;
    }

    public List getWeek(Object... args) {
        return courseTableInfoDao.getWeek(args);
    }
}