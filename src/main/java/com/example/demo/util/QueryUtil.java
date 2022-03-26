package com.example.demo.util;

import com.example.demo.dao.*;
import com.example.demo.dao.implement.*;

import java.util.List;

public class QueryUtil {
    private static final ClassBaseInfoDao classBaseInfoDao = new ClassBaseInfoDaoImpl();
    private static final ClassroomInfoDao classroomInfoDao = new ClassroomInfoDaoImpl();
    private static final CourseBaseInfoDao courseBaseInfoDao = new CourseBaseInfoDaoImpl();
    private static final CourseTableInfoDao courseTableInfoDao = new CourseTableInfoDaoImpl();
    private static final StudentInfoDao studentInfoDao = new StudentInfoDaoImpl();
    private static final TeacherInfoDao teacherInfoDao = new TeacherInfoDaoImpl();
    private static final UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private static List list = null;

    public static List queryListBySearch(Object o, Object... condition) {
        int pageSize = 13;
        int page = Integer.parseInt((String) condition[1]);
        int curPage = ((page - 1) * pageSize);
        if (o instanceof ClassBaseInfoDao) {
            list = classBaseInfoDao.queryListBySearch(condition[0], curPage);
        } else if (o instanceof ClassroomInfoDao) {
            list = classroomInfoDao.queryListBySearch(condition[0], curPage);
        } else if (o instanceof CourseBaseInfoDao) {
            list = courseBaseInfoDao.queryListBySearch(condition[0], curPage);
        } else if (o instanceof CourseTableInfoDao) {
            list = courseTableInfoDao.queryListBySearch(condition[0], curPage);
        } else if (o instanceof StudentInfoDao) {
            list = studentInfoDao.queryListBySearch(condition[0], curPage);
        } else if (o instanceof TeacherInfoDao) {
            list = teacherInfoDao.queryListBySearch(condition[0], curPage);
        } else if (o instanceof UserInfoDao) {
            list = userInfoDao.queryListBySearch(condition[0], curPage);
        }
        return list;
    }

    public static List queryListByPage(Object o, Object... args) {
        int pageSize = 13;
        int page = (int) args[0];
        if (o instanceof ClassBaseInfoDao) {
            list = classBaseInfoDao.queryListByPage(((page - 1) * pageSize));
        } else if (o instanceof ClassroomInfoDao) {
            list = classroomInfoDao.queryListByPage(((page - 1) * pageSize));
        } else if (o instanceof CourseBaseInfoDao) {
            list = courseBaseInfoDao.queryListByPage(((page - 1) * pageSize));
        } else if (o instanceof CourseTableInfoDao) {
            list = courseTableInfoDao.queryListByPage(((page - 1) * pageSize));
        } else if (o instanceof StudentInfoDao) {
            list = studentInfoDao.queryListByPage(((page - 1) * pageSize));
        } else if (o instanceof TeacherInfoDao) {
            list = teacherInfoDao.queryListByPage(((page - 1) * pageSize));
        } else if (o instanceof UserInfoDao) {
            list = userInfoDao.queryListByPage(((page - 1) * pageSize));
        }
        return list;
    }

    public static Integer getPageSizeBySearch(Object o, String reqParam) {
        if (o instanceof ClassBaseInfoDao) {
            list = classBaseInfoDao.getPageSizeBySearch(reqParam);;
        } else if (o instanceof ClassroomInfoDao) {
            list = classroomInfoDao.getPageSizeBySearch(reqParam);
        } else if (o instanceof CourseBaseInfoDao) {
            list = courseBaseInfoDao.getPageSizeBySearch(reqParam);
        } else if (o instanceof CourseTableInfoDao) {
            list = courseTableInfoDao.getPageSizeBySearch(reqParam);
        } else if (o instanceof StudentInfoDao) {
            list = studentInfoDao.getPageSizeBySearch(reqParam);
        } else if (o instanceof TeacherInfoDao) {
            list = teacherInfoDao.getPageSizeBySearch(reqParam);
        } else if (o instanceof UserInfoDao) {
            list = userInfoDao.getPageSizeBySearch(reqParam);
        }
        return (Integer) (int) Math.ceil((list.size()) / 13.0);
    }

    public static int getPageSize(Object o) {
        int pageSize = 0;
        if (o instanceof ClassBaseInfoDao) {
            pageSize = (int) Math.ceil((classBaseInfoDao.queryList().size()) / 13.0);
        } else if (o instanceof ClassroomInfoDao) {
            pageSize = (int) Math.ceil((classroomInfoDao.queryList().size()) / 13.0);
        } else if (o instanceof CourseBaseInfoDao) {
            pageSize = (int) Math.ceil((courseBaseInfoDao.queryList().size()) / 13.0);
        } else if (o instanceof CourseTableInfoDao) {
            pageSize = (int) Math.ceil((courseTableInfoDao.queryList().size()) / 13.0);
        } else if (o instanceof StudentInfoDao) {
            pageSize = (int) Math.ceil((studentInfoDao.queryList().size()) / 13.0);
        } else if (o instanceof TeacherInfoDao) {
            pageSize = (int) Math.ceil((teacherInfoDao.queryList().size()) / 13.0);
        } else if (o instanceof UserInfoDao) {
            pageSize = (int) Math.ceil((userInfoDao.queryList().size()) / 13.0);
        }
        return pageSize;
    }
}
