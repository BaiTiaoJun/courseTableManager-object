package com.example.demo.web.controller;

import com.example.demo.domain.*;
import com.example.demo.service.InfoService;
import com.example.demo.util.ServicesFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

@WebServlet("/modify.do")
public class ModifyServlet extends HttpServlet {
    private InfoService infoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        updatePassByUser(request, out);
        updateStu(request, response, out);
        updateUser(request, response, out);
        updateTeacher(request, response, out);
        updateCourseTable(request, response, out);
        updateCourseBase(request, response, out);
        updateClassBase(request, response, out);
        updateClassroom(request, response, out);
    }

    //用户修改自己的密码信息
    private void updatePassByUser(HttpServletRequest request, PrintWriter out) {
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String finalPassword = request.getParameter("finalPassword");
        if (oldPassword != null && newPassword != null && finalPassword != null) {
            HttpSession session = request.getSession(false);
            String username = (String) session.getAttribute("username");
            infoService = ServicesFactory.getUserInfoService();
            List<UserInfo> userInfos = infoService.queryList();
            for (UserInfo userInfo1 : userInfos) {
                if (userInfo1.getPassword().equals(oldPassword) && userInfo1.getUsername().equals(username)) {
                    if (userInfo1.getPassword().equals(newPassword)) {
                        out.print("false");
                    } else {
                        int n = infoService.updateData(finalPassword, username);
                        out.print(n);
                    }
                    return;
                } else if (userInfo1.getUsername().equals(username)) {
                    out.print("true");
                    return;
                }
            }
        }
    }

    //修改用户信息
    private void updateUser(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        String username = request.getParameter("username");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String type = request.getParameter("type");
        if (username != null) {
            infoService = ServicesFactory.getUserInfoService();
            UserInfo userInfo = (UserInfo) infoService.queryOneByUsername(username);
            request.setAttribute("username", userInfo.getUsername());
            request.setAttribute("password", userInfo.getPassword());
            request.setAttribute("usertype", userInfo.getUsertype());
            try {
                request.getRequestDispatcher("/UserUpdateJsp.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
            return;
        }
        if (user != null && (!"".equals(pass) && pass != null)) {
            infoService = ServicesFactory.getUserInfoService();
            int n = infoService.updateAllDataByUsername(pass, type, user);
            if (n == 1) {
                out.write("true");
            }
        }
    }

    //修改学生信息
    private void updateStu(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        String stuNo = request.getParameter("stuNo");
        String stuId = request.getParameter("stuId");
        String stuName = request.getParameter("name");
        String stuSex = request.getParameter("sex");
        String stuYear = request.getParameter("year");
        String stuMonth = request.getParameter("month");
        String stuDay = request.getParameter("day");
        StringBuilder stuDate = null;
        if (stuYear != null) {
            stuDate = new StringBuilder(stuYear);
            stuDate.append("-").append(new DecimalFormat("00").format(Integer.valueOf(stuMonth)));
            stuDate.append("-").append(new DecimalFormat("00").format(Integer.valueOf(stuDay)));
        }
        String stuDept = request.getParameter("dept");
        String stuClass = request.getParameter("class");
        String stuAddr = request.getParameter("addr");
        String stuContact = request.getParameter("contact");
        if (stuNo != null) {
            infoService = ServicesFactory.getStudentInfoService();
            StudentInfo studentInfo =(StudentInfo) infoService.queryOne(stuNo);
            request.setAttribute("stuNo", studentInfo.getNo());
            request.setAttribute("stuName", studentInfo.getName());
            request.setAttribute("stuSex", studentInfo.getSex());
            String[] time = studentInfo.getBirthdate().split("-");
            request.setAttribute("year", time[0]);
            request.setAttribute("month", time[1]);
            request.setAttribute("day", time[2]);
            request.setAttribute("stuBirthdate", studentInfo.getBirthdate());
            request.setAttribute("stuDept", studentInfo.getDept());
            request.setAttribute("stuSclass", studentInfo.getSclass());
            request.setAttribute("stuAddress", studentInfo.getAddress());
            request.setAttribute("stuContact", studentInfo.getContact());
            try {
                request.getRequestDispatcher("/StuUpdateJsp.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
            return;
        }
        if (!"".equals(stuId) && stuId != null && !"".equals(stuName) && stuName != null && !"".equals(stuSex) && stuSex != null && stuDate != null && !"".equals(stuDept) && stuDept != null && !"".equals(stuAddr) && stuAddr != null && !"".equals(stuContact) && stuContact != null && !"".equals(stuClass) && stuClass != null) {
            infoService = ServicesFactory.getStudentInfoService();
            infoService.updateData(stuName, stuSex, String.valueOf(stuDate), stuDept, stuClass, stuAddr, stuContact, stuId);
            out.write("true");
        }
    }

    //修改老师信息
    private void updateTeacher(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        String teaNo = request.getParameter("teaNo");
        String teaId = request.getParameter("teaId");
        String teaName = request.getParameter("teaName");
        String teaDept = request.getParameter("teaDept");
        String teaMajor = request.getParameter("teaMajor");
        String teaPosTitle = request.getParameter("teaPosTitle");
        if (teaNo != null) {
            infoService = ServicesFactory.getTeacherInfoService();
            TeacherInfo teacherInfo = (TeacherInfo) infoService.queryOne(teaNo);
            request.setAttribute("teaNo", teacherInfo.getNo());
            request.setAttribute("teaName", teacherInfo.getName());
            request.setAttribute("teaDept", teacherInfo.getDept());
            request.setAttribute("teaMajor", teacherInfo.getMajor());
            request.setAttribute("teaPosTitle", teacherInfo.getPositionalTitle());
            try {
                request.getRequestDispatcher("/TeaUpdateJsp.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
            return;
        }
        if (teaId != null && (teaName != null && !"".equals(teaName)) && (teaDept != null && !"".equals(teaDept))
                && (teaMajor != null && !"".equals(teaMajor)) && (teaPosTitle != null && !"".equals(teaPosTitle))) {
            infoService = ServicesFactory.getTeacherInfoService();
            int n = infoService.updateData(teaName, teaDept, teaMajor, teaPosTitle, teaId);
            if (n == 1) {
                out.write("true");
            }
        }
    }

    //修改课程表信息
    private void updateCourseTable(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        String ctbId = request.getParameter("ctbId");
        String ctbNo = request.getParameter("ctbNo");
        String ctbCouNo = request.getParameter("ctbCouNo");
        String ctbClassNo = request.getParameter("ctbClassNo");
        String ctbTeaNo = request.getParameter("ctbTeaNo");
        String ctbTimeWeek = request.getParameter("ctbTimeWeek");
        String ctbTimeWhatDay = request.getParameter("ctbTimeWhatDay");
        String ctbTimeSessionNo = request.getParameter("ctbTimeSessionNo");
        String ctbSite = request.getParameter("ctbSite");
        if (ctbId != null) {
            infoService = ServicesFactory.getCourseTableInfoService();
            CourseTableInfo courseTableInfo = (CourseTableInfo) infoService.queryOne(ctbId);
            request.setAttribute("courseId", courseTableInfo.getId());
            request.setAttribute("courseNo", courseTableInfo.getCourseNo());
            request.setAttribute("classNo", courseTableInfo.getCclass());
            request.setAttribute("teacherNo", courseTableInfo.getTeacherNo());
            String[] time = infoService.getTime(courseTableInfo.getTime());
            request.setAttribute("week", time[0]);
            request.setAttribute("whatDay", time[1]);
            request.setAttribute("sessionNo", time[2]);
            request.setAttribute("site", courseTableInfo.getSite());
            try {
                request.getRequestDispatcher("/CourseTableUpdateJsp.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
            return;
        }
        if (ctbNo != null && !"".equals(ctbNo) && ctbCouNo != null && !"".equals(ctbCouNo) && ctbClassNo != null && !"".equals(ctbClassNo) &&
        ctbTeaNo != null && !"".equals(ctbTeaNo) && ctbTimeWeek != null && !"".equals(ctbTimeWeek) && ctbTimeWhatDay != null && !"".equals(ctbTimeWhatDay) &&
        ctbTimeSessionNo != null && !"".equals(ctbTimeSessionNo) && ctbSite != null && !"".equals(ctbSite)) {
            infoService = ServicesFactory.getCourseTableInfoService();
            String time = infoService.joint(ctbTimeWeek, ctbTimeWhatDay, ctbTimeSessionNo);
            int n = infoService.updateData(ctbCouNo, ctbClassNo, ctbTeaNo, time, ctbSite, ctbNo);
            if (n == 1) {
                out.write("true");
            }
        }
    }

    //修改课程基本信息
    private void updateCourseBase(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        String cbCourseNo = request.getParameter("courseNo");
        String couNo = request.getParameter("couNo");
        String couName = request.getParameter("couName");
        String couTerm = request.getParameter("couTerm");
        String couPeriod = request.getParameter("couPeriod");
        String couCredit = request.getParameter("couCredit");
        if (cbCourseNo != null) {
            infoService = ServicesFactory.getCourseBaseInfoService();
            CourseBaseInfo courseBaseInfo = (CourseBaseInfo) infoService.queryOne(cbCourseNo);
            request.setAttribute("courseNo", courseBaseInfo.getCourseNo());
            request.setAttribute("cname", courseBaseInfo.getCname());
            request.setAttribute("term", courseBaseInfo.getTerm().trim());
            request.setAttribute("period", courseBaseInfo.getPeriod());
            request.setAttribute("credit", courseBaseInfo.getCredit());
            try {
                request.getRequestDispatcher("/CourseBaseUpdateJsp.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        if (couNo != null && !"".equals(couNo) && couName != null && !"".equals(couName) && couTerm != null && !"".equals(couTerm)
        && couPeriod != null && !"".equals(couPeriod) && couCredit != null && !"".equals(couCredit)) {
            infoService = ServicesFactory.getCourseBaseInfoService();
            int n = infoService.updateData(couName, couTerm, couPeriod, couCredit, couNo);
            if (n == 1) {
                out.write("true");
            }
        }
    }

    //修改班级基本信息
    private void updateClassBase(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        String classNo = request.getParameter("classNo");
        String cNo = request.getParameter("cNo");
        String dept = request.getParameter("dept");
        String classStuNum = request.getParameter("classStuNum");
        String selYear = request.getParameter("selYear");
        String selMonth = request.getParameter("selMonth");
        String selDay = request.getParameter("selDay");
        String instructor = request.getParameter("instructor");
        if (classNo != null) {
            infoService = ServicesFactory.getClassBaseInfoService();
            ClassBaseInfo classBaseInfo = (ClassBaseInfo) infoService.queryOne(classNo);
            request.setAttribute("classNo", classBaseInfo.getClassNo());
            request.setAttribute("dept", classBaseInfo.getDept());
            request.setAttribute("classStuNum", classBaseInfo.getClassNum());
            String[] date = classBaseInfo.getEnYear().split("-");
            request.setAttribute("year", date[0]);
            request.setAttribute("month", date[1]);
            request.setAttribute("day", date[2]);
            request.setAttribute("instructor", classBaseInfo.getInstructor());
            try {
                request.getRequestDispatcher("/ClassBaseUpdateJsp.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        if (cNo != null && !"".equals(cNo) && dept != null && !"".equals(dept) && classStuNum != null && !"".equals(classStuNum) &&
                selYear != null && !"".equals(selYear) && selMonth != null && !"".equals(selMonth) && selDay != null && !"".equals(selDay) &&
                instructor != null && !"".equals(instructor)) {
            infoService = ServicesFactory.getClassBaseInfoService();
            String enYear = infoService.joint(selYear, selMonth, selDay);
            int n = infoService.updateData(dept, classStuNum, enYear, instructor, cNo);
            if (n == 1) {
                out.write("true");
            }
        }
    }

    //修改教室基本信息
    private void updateClassroom(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        String classroomNo = request.getParameter("classroomNo");
        String classroomNumber = request.getParameter("classroomNumber");
        String capacity = request.getParameter("capacity");
        String isMulClassroom = request.getParameter("isMulClassroom");
        String isUse = request.getParameter("isUse");
        if (classroomNo != null) {
            infoService = ServicesFactory.getClassroomInfoService();
            ClassroomInfo classroomInfo = (ClassroomInfo) infoService.queryOne(classroomNo);
            request.setAttribute("classroomNo", classroomInfo.getClassroomNo());
            request.setAttribute("isMulClassroom", classroomInfo.getIsMulClassroom().equals("1"));
            request.setAttribute("capacity", classroomInfo.getCapacity());
            request.setAttribute("status", classroomInfo.getStatus());
            try {
                request.getRequestDispatcher("/ClassroomUpdateJsp.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        if (classroomNumber != null && !"".equals(classroomNumber) && isMulClassroom != null && !"".equals(isMulClassroom) &&
        capacity != null && !"".equals(capacity) && isUse != null && !"".equals(isUse)) {
            infoService = ServicesFactory.getClassroomInfoService();
            int n = infoService.updateData(capacity, isMulClassroom, isUse, classroomNumber);
            if (n == 1) {
                out.write("true");
            }
        }
    }
}