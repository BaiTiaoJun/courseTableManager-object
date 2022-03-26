package com.example.demo.web.controller;

import com.example.demo.service.InfoService;
import com.example.demo.util.ServicesFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
    private InfoService infoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        //删除用户信息
        String username = request.getParameter("username");
        if (username != null) {
            infoService = ServicesFactory.getUserInfoService();
            delete(infoService, username, response);
        }
        //删除学生信息
        String stuNo = request.getParameter("stuNo");
        if (stuNo != null) {
            infoService = ServicesFactory.getStudentInfoService();
            delete(infoService, stuNo, response);
        }
        //删除老师信息
        String teaNo = request.getParameter("teaNo");
        if (teaNo != null) {
            infoService = ServicesFactory.getTeacherInfoService();
            delete(infoService, teaNo, response);
        }
        //删除课程表信息
        String id = request.getParameter("id");
        if (id != null) {
            infoService = ServicesFactory.getCourseTableInfoService();
            delete(infoService, id, response);
        }
        //删除课程基本信息
        String courseNo = request.getParameter("courseNo");
        if (courseNo != null) {
            infoService = ServicesFactory.getCourseBaseInfoService();
            delete(infoService, courseNo, response);
        }
        //删除班级基本信息
        String classNo = request.getParameter("classNo");
        if (classNo != null) {
            infoService = ServicesFactory.getClassBaseInfoService();
            delete(infoService, classNo, response);
        }
        //删除教室基本信息
        String classroomNo = request.getParameter("classroomNo");
        if (classroomNo != null) {
            infoService = ServicesFactory.getClassroomInfoService();
            delete(infoService, classroomNo, response);
        }
    }

    //删除信息
    private void delete(InfoService infoService, String delKey, HttpServletResponse response) {
        infoService.delete(delKey);
        int pageSize = infoService.getPageSize();
        try {
            response.getWriter().write(String.valueOf(pageSize));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}