package com.example.demo.web.controller;

import com.example.demo.service.InfoService;
import com.example.demo.util.ServicesFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/insert.do")
public class InsertServlet extends HttpServlet {
    private InfoService infoService;
    private int n;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //添加用户信息
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String type = request.getParameter("type");
        if (user != null && pass != null && type != null) {
            insertUser(out, user.trim(), pass.trim(), type);
        }
        //添加学生信息
        String stuId = request.getParameter("stuId");
        String stuName = request.getParameter("stuName");
        String sex = request.getParameter("sex");
        String selYear = request.getParameter("selYear");
        String selMonth = request.getParameter("selMonth");
        String selDay= request.getParameter("selDay");
        String dept = request.getParameter("dept");
        String sclass = request.getParameter("sclass");
        String addr = request.getParameter("addr");
        String contact = request.getParameter("contact");
        if (stuId != null && stuName != null && sex != null && selYear != null && selMonth != null
        && selDay != null && dept != null && sclass != null && addr != null && contact != null) {
            insertStu(out, stuId.trim(), stuName.trim(), sex, selYear, selMonth, selDay, dept, sclass.trim(), addr.trim(), contact.trim());
        }
        //添加教师信息
        String teaNo = request.getParameter("teaNo");
        String teaName = request.getParameter("teaName");
        String deptOption = request.getParameter("deptOption");
        String majorOption = request.getParameter("majorOption");
        String levelOption = request.getParameter("levelOption");
        if (teaNo != null && teaName != null && deptOption != null && majorOption != null &&levelOption != null) {
            insertTea(out, teaNo.trim(), teaName.trim(), deptOption, majorOption, levelOption);
        }
        //添加课程表信息
        String ctbCouNo = request.getParameter("ctbCouNo");
        String ctbClassNo = request.getParameter("ctbClassNo");
        String ctbTeaNo = request.getParameter("ctbTeaNo");
        String ctbTimeWeek = request.getParameter("ctbTimeWeek");
        String ctbTimeWhatDay = request.getParameter("ctbTimeWhatDay");
        String ctbTimeSessionNo = request.getParameter("ctbTimeSessionNo");
        String ctbSite = request.getParameter("ctbSite");
        if (ctbCouNo != null && ctbClassNo != null && ctbTeaNo != null && ctbTimeWeek != null
                && ctbTimeWhatDay != null && ctbTimeSessionNo != null && ctbSite != null) {
            insertCourseTable(out, ctbCouNo, ctbClassNo, ctbTeaNo, ctbTimeWeek, ctbTimeWhatDay, ctbTimeSessionNo, ctbSite);
        }
        //添加课程基本信息
        String couNo = request.getParameter("couNo");
        String couName = request.getParameter("couName");
        String couTerm = request.getParameter("couTerm");
        String couPeriod = request.getParameter("couPeriod");
        String couCredit = request.getParameter("couCredit");
        if(couNo != null && couName != null && couTerm != null && couPeriod != null && couCredit != null) {
            insertCourseBase(out, couNo, couName, couTerm, couPeriod, couCredit);
        }
        //添加班级基本信息
        String classNo = request.getParameter("classNo");
        String classDept = request.getParameter("classDept");
        String classStuNum = request.getParameter("classStuNum");
        String year = request.getParameter("selYear");
        String month = request.getParameter("selMonth");
        String day = request.getParameter("selDay");
        String instructor = request.getParameter("instructor");
        if (classNo != null && classDept != null && classStuNum != null && year != null && month != null && day != null && instructor != null) {
            insertClassBase(out, classNo, classDept, classStuNum, year, month, day, instructor);
        }
        //添加教室信息
        String classroomNo = request.getParameter("classroomNo");
        String capacity = request.getParameter("capacity");
        String isMul = request.getParameter("isMul");
        String isUse = request.getParameter("isUse");
        if (classroomNo != null && capacity != null && isMul != null && isUse != null) {
            insertClassroom(out, classroomNo, capacity, isMul, isUse);
        }
    }

    private void insertUser(PrintWriter out, Object... args) {
        infoService = ServicesFactory.getUserInfoService();
        insert(out, args);
    }

    private void insertStu(PrintWriter out, Object... args) {
        infoService = ServicesFactory.getStudentInfoService();
        String selTime = infoService.joint(args);
        insert(out, args[0], args[1], args[2], selTime, args[6], args[7], args[8], args[9]);
        if(n == 1) {
            ServicesFactory.getUserInfoService().insertData(args[0], "123456", "学生");
        }
    }

    private void insertTea(PrintWriter out, Object... args) {
        infoService = ServicesFactory.getTeacherInfoService();
        insert(out, args);
        if(n == 1) {
            ServicesFactory.getUserInfoService().insertData(args[0], "123456", "老师");
        }
    }

    private void insertCourseTable(PrintWriter out, Object... args) {
        infoService = ServicesFactory.getCourseTableInfoService();
        String time = infoService.joint(args[3], args[4], args[5]);
        insert(out, args[0], args[1], args[2], time, args[6]);
    }

    private void insertCourseBase(PrintWriter out, Object... args) {
        infoService = ServicesFactory.getCourseBaseInfoService();
        insert(out, args);
    }

    private void insertClassBase(PrintWriter out, Object... args) {
        infoService = ServicesFactory.getClassBaseInfoService();
        String time = infoService.joint(args[3], args[4], args[5]);
        insert(out, args[0], args[1], args[2], time, args[6]);
    }

    private void insertClassroom(PrintWriter out, Object...  args) {
        infoService = ServicesFactory.getClassroomInfoService();
        insert(out, args);
    }

    private void insert(PrintWriter out, Object... args) {
        n = infoService.insertData(args);
        out.write(String.valueOf(n));
    }
}
