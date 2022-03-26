package com.example.demo;

import com.example.demo.dao.ClassBaseInfoDao;
import com.example.demo.dao.implement.ClassBaseInfoDaoImpl;
import org.junit.Test;

public class TestClassBaseInfo {
    @Test
    public void test1() {
        //        InfoDao infoDao = new StudentInfoDaoImpl();
//        int n = infoDao.updateData("张顺","男","1997-09-16","计算机与科学学院","0213217523","湖北工程学院西区18栋701","18580497990","021321752327");
//        System.out.println(n);
    }
    @Test
    public void test2() {
        //        InfoService infoService = MyServices.getStudentInfoService();
//        InfoDao infoDao = new StudentInfoDaoImpl();
//        StudentInfo studentInfo = (StudentInfo) infoDao.queryOne("021321752316");
//        String[] time = infoService.getDate(studentInfo.getBirthdate());
//        for (String s:time) {
//            System.out.println(s);
//        }
//        InfoService infoService = MyServices.getUserInfoService();
//        UserInfo userInfo = (UserInfo) infoService.queryOneByUsername("0213105");
//        System.out.println(userInfo);\
    }

    @Test
    public void test3() {
//        InfoService infoService = MyServices.getTeacherInfoService();
//        int n = infoService.updateData("立华奏", "计算机与科学学院", "python","教授", "0213105");
//        System.out.println(n);
//        InfoService infoService = MyServices.getCourseTableInfoService();
//        String s = infoService.joint("大","个人头","过热");
//        System.out.println(s);
    }

    @Test
    public void test4() {
//        InfoService infoService = MyServices.getCourseTableInfoService();
//        infoService.updateData("201335","0213217523","02132135","第四周，星期五，第3-4节", "02114", "10015");

//        InfoService infoService = MyServices.getClassroomInfoService();
//        ClassroomInfo classroomInfo = (ClassroomInfo) infoService.queryOne("02114");
//        System.out.println(classroomInfo);
    }

    @Test
    public void test5() {
//        InfoService infoService = MyServices.getClassBaseInfoService();
//        System.out.println(infoService.joint("1999", 2, 12));

//        InfoService infoService = MyServices.getCourseTableInfoService();
//        infoService.delete(10033);

//        InfoService infoService = MyServices.getCourseTableInfoService();
//        List<CourseTableInfo> list = infoService.queryListBySearch("%第二周%", "1");
//        int count = 0;
//        for (CourseTableInfo courseTableInfo:list) {
//            System.out.println(courseTableInfo);
//            count++;
//        }
//        System.out.println(count);

//        InfoService infoService = MyServices.getTeacherInfoService();
//        TeacherInfo teacherInfo = (TeacherInfo) infoService.queryOne("0213105", 1);
//        System.out.println(teacherInfo);

//        InfoService infoService = MyServices.getCourseTableInfoService();
//        int n = infoService.getPageSizeBySearch("%2013%");
//        System.out.println(n);

//        InfoService infoService = MyServices.getStudentInfoService();
//        int n = infoService.insertData("021321752399", "孙钱", "女", "1920-01-01",	"湖北工程学院", "0213217523",	"孝感市孝南区", "18580497990");
//        System.out.println(n);

//        InfoService infoService = MyServices.getStudentInfoService();
//        String cclass = infoService.getClassNo("021321752321");
//        infoService = MyServices.getCourseTableInfoService();
//        List<CourseTableInfo> list = infoService.queryList("第二周%", "%" + cclass + "%");
//        for (CourseTableInfo courseTableInfo:list) {
//            System.out.println(courseTableInfo);
//        }
//        InfoService infoService = MyServices.getCourseBaseInfoService();
//        List list = infoService.queryList("%0213217523%");
//        for (Object o:list) {
//            System.out.println(o);
//        }
    }

    @Test
    public void sayHello() {
        System.out.println("hello!");
    }
}
