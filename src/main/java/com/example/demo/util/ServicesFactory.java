package com.example.demo.util;

import com.example.demo.service.InfoService;
import com.example.demo.service.implement.*;

public class ServicesFactory {
    private static final InfoService classBaseInfoService = new ClassBaseInfoServiceImpl();
    private static final InfoService classroomInfoService = new ClassroomInfoServiceImpl();
    private static final InfoService courseBaseInfoService = new CourseBaseInfoServiceImpl();
    private static final InfoService courseTableInfoService = new CourseTableInfoServiceImpl();
    private static final InfoService studentInfoService = new StudentInfoServiceImpl();
    private static final InfoService teacherInfoService = new TeacherInfoServiceImpl();
    private static final InfoService userInfoService = new UserInfoServiceImpl();

    private ServicesFactory() {
    }

    public static InfoService getClassBaseInfoService () {
        return classBaseInfoService;
    }

    public static InfoService getClassroomInfoService () {
        return classroomInfoService;
    }

    public static InfoService getCourseBaseInfoService () {
        return courseBaseInfoService;
    }

    public static InfoService getCourseTableInfoService () {
        return courseTableInfoService;
    }

    public static InfoService getStudentInfoService () {
        return studentInfoService;
    }

    public static InfoService getTeacherInfoService () {
        return teacherInfoService;
    }

    public static InfoService getUserInfoService () {
        return userInfoService;
    }
}
