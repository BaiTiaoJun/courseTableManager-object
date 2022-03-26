package com.example.demo.web.controller;

import com.example.demo.service.InfoService;
import com.example.demo.util.PrintJson;
import com.example.demo.util.ServicesFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/query.do")
public class SelectServlet extends HttpServlet {
    private InfoService infoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        String time = request.getParameter("time");
        String select = request.getParameter("select");
        String selTime = request.getParameter("selTime");
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");
        HttpSession session = request.getSession(false);
        String userType = (String) session.getAttribute("userType");
        String username = (String) session.getAttribute("username");
        //接收查询的信息请求参数
        String reqStuParam = request.getParameter("reqStuParam");
        String reqTeaParam = request.getParameter("reqTeaParam");
        String reqClassBaseParam = request.getParameter("reqClassBaseParam");
        String reqClassroomParam = request.getParameter("reqClassroomParam");
        String reqCourseBaseParam = request.getParameter("reqCourseBaseParam");
        String reqCourseTableParam = request.getParameter("reqCourseTableParam");
        //接受默认课程表添加信息请求参数
        String reqCourseNo = request.getParameter("reqCourseNo");
        String reqSite = request.getParameter("reqSite");
        String reqTeaNo = request.getParameter("reqTeaNo");
        String reqClassNo = request.getParameter("reqClassNo");
        //查询搜索结果返回的页数请求参数
        String pageSizeBySearch = request.getParameter("pageSizeBySearch");
        PrintWriter out = response.getWriter();
        if ("课程表".equals(type)) {
            queryCourseTable(request, response, selTime);
            return;
        } else if ("周次".equals(time)) {
            queryWeek(out, request);
            return;
        } else if ("maxPage".equals(pageSize)) {
            queryPageSize(response, select);
            return;
        } else if (select != null && page != null) {
            queryAllInfoByPage(select, page, out);
            return;
        }
        //获取搜索结果集总页数
        if ("pageSize".equals(pageSizeBySearch)) {
            if (!"".equals(reqStuParam) && reqStuParam != null) {
                queryPageSizeBySearch(response, out, reqStuParam, ServicesFactory.getStudentInfoService());
            } else if (!"".equals(reqTeaParam) && reqTeaParam != null) {
                queryPageSizeBySearch(response, out, reqTeaParam, ServicesFactory.getTeacherInfoService());
            } else if (!"".equals(reqClassBaseParam) && reqClassBaseParam != null) {
                queryPageSizeBySearch(response, out, reqClassBaseParam, ServicesFactory.getClassBaseInfoService());
            } else if (!"".equals(reqClassroomParam) && reqClassroomParam != null) {
                queryPageSizeBySearch(response, out, reqClassroomParam, ServicesFactory.getClassroomInfoService());
            } else if (!"".equals(reqCourseBaseParam) && reqCourseBaseParam != null) {
                queryPageSizeBySearch(response, out, reqCourseBaseParam, ServicesFactory.getCourseBaseInfoService());
            } else if (!"".equals(reqCourseTableParam) && reqCourseTableParam != null) {
                queryPageSizeBySearch(response, out, reqCourseTableParam, ServicesFactory.getCourseTableInfoService());
            }
            return;
        }
        //查找学生信息
        if (!"".equals(reqStuParam) && reqStuParam != null && page != null) {
            queryBySearch(reqStuParam, out, page, type);
            return;
        }
        //查找教师信息
        if (!"".equals(reqTeaParam) && reqTeaParam != null && page != null) {
            queryBySearch(reqTeaParam, out, page, type);
            return;
        }
        //查找班级基本信息
        if (!"".equals(reqClassBaseParam) && reqClassBaseParam != null && page != null) {
            queryBySearch(reqClassBaseParam, out, page, type);
            return;
        }
        //查找教室信息
        if (!"".equals(reqClassroomParam) && reqClassroomParam != null && page != null) {
            queryBySearch(reqClassroomParam, out, page, type);
            return;
        }
        //查找课程基本信息
        if (!"".equals(reqCourseBaseParam) && reqCourseBaseParam != null && page != null) {
            queryBySearch(reqCourseBaseParam, out, page, type);
            return;
        }
        //查找课程表信息
        if (!"".equals(reqCourseTableParam) && reqCourseTableParam != null && page != null) {
            queryBySearch(reqCourseTableParam, out, page, type);
            return;
        }
        //查找所有课程的基本信息
        if ("courseNo".equals(reqCourseNo)) {
            queryAllInfo(ServicesFactory.getCourseBaseInfoService(), out);
            return;
        }
        //查找所有教室的信息
        if ("site".equals(reqSite)) {
            queryAllInfo(ServicesFactory.getClassroomInfoService(), out);
            return;
        }
        //查找所有老师信息
        if ("teaNo".equals(reqTeaNo)) {
            queryAllInfo(ServicesFactory.getTeacherInfoService(), out);
            return;
        }
        //查找所有班级信息
        if ("classNo".equals(reqClassNo)) {
            queryAllInfo(ServicesFactory.getClassBaseInfoService(), out);
            return;
        }

        if (type != null || userType != null) {
            queryOneUserInfo(type, userType, username, request, response);
        }
    }

    // 课程表查询
    private void queryCourseTable(HttpServletRequest request, HttpServletResponse response, String selTime) {
        HttpSession session = request.getSession(false);
        String type = (String) session.getAttribute("userType");
        infoService = ServicesFactory.getCourseTableInfoService();
        String sclass = null;
        if ("学生".equals(type)) {
            //根据学号查找班级
            sclass = ServicesFactory.getStudentInfoService().getClassNo((String) session.getAttribute("username"));
            //查询班级所上的课程名
            request.setAttribute("nameList", ServicesFactory.getCourseBaseInfoService().queryList("%" + sclass + "%"));
            //查找班级锁上的教师名
            request.setAttribute("noList", ServicesFactory.getTeacherInfoService().queryList("%" + sclass + "%"));
        }
        //根据周数和班级号或老师编号查找课程班级和地点
        if (sclass != null) {
            request.setAttribute("list", infoService.queryList(selTime + "%", "%" + sclass + "%"));
        } else {
            request.setAttribute("list", infoService.queryList(selTime + "%", "%" + session.getAttribute("username") + "%"));
        }
        //查询老师所上的课程名
        if ("老师".equals(type)) {
            infoService = ServicesFactory.getCourseBaseInfoService();
            request.setAttribute("nameList", infoService.queryList("%" + session.getAttribute("username") + "%"));
            infoService = ServicesFactory.getTeacherInfoService();
            request.setAttribute("noList", infoService.queryList("%" + session.getAttribute("username") + "%"));
        }
        try {
            request.getRequestDispatcher("/CouSelectJsp.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    // 获取周次
    @SuppressWarnings("unchecked")
    private void queryWeek(PrintWriter out, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String type = (String) session.getAttribute("userType");
        List list = null, list1, list2;
        infoService = ServicesFactory.getCourseTableInfoService();
        if ("学生".equals(type)) {
            String sclass = ServicesFactory.getStudentInfoService().getClassNo((String) session.getAttribute("username"));
            list = infoService.getWeek("%" + sclass + "%");
        } else if ("老师".equals(type)) {
            list = infoService.getWeek("%" + session.getAttribute("username") + "%");
        }
        List<String> list3 = infoService.getCourseTableInfosTimeList(list);
        list1 = infoService.removeRepeatTime(list3);
        list2 = infoService.sortedSelWeek(list1);
        out.print(PrintJson.convertJson(list2));
        out.flush();
    }
    //获取每个表的总页数
    private void queryPageSize(HttpServletResponse response, String select) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert out != null;
        if ("查询学生".equals(select)) {
            infoService = ServicesFactory.getStudentInfoService();
        } else if ("查询用户".equals(select)) {
            infoService = ServicesFactory.getUserInfoService();
        } else if ("查询教师".equals(select)) {
            infoService = ServicesFactory.getTeacherInfoService();
        } else if ("查询课程表信息".equals(select)) {
            infoService = ServicesFactory.getCourseTableInfoService();
        } else if ("查询课程基本信息".equals(select)) {
            infoService = ServicesFactory.getCourseBaseInfoService();
        } else if ("查询班级基本信息".equals(select)) {
            infoService = ServicesFactory.getClassBaseInfoService();
        } else if ("查询教室基本信息".equals(select)) {
            infoService = ServicesFactory.getClassroomInfoService();
        }
        out.print(infoService.getPageSize());
    }
    //根据页数获取每个表的所有信息
    private void queryAllInfoByPage(String select, String page, PrintWriter out) {
        if ("查询学生".equals(select)) {
            infoService = ServicesFactory.getStudentInfoService();
        } else if ("查询用户".equals(select)) {
            infoService = ServicesFactory.getUserInfoService();
        } else if ("查询教师".equals(select)) {
            infoService = ServicesFactory.getTeacherInfoService();
        } else if ("查询课程表信息".equals(select)) {
            infoService = ServicesFactory.getCourseTableInfoService();
        } else if ("查询课程基本信息".equals(select)) {
            infoService = ServicesFactory.getCourseBaseInfoService();
        } else if ("查询班级基本信息".equals(select)) {
            infoService = ServicesFactory.getClassBaseInfoService();
        } else if ("查询教室基本信息".equals(select)) {
            infoService = ServicesFactory.getClassroomInfoService();
        }
        out.print(PrintJson.convertJson(infoService.queryListByPage(Integer.parseInt(page))));
    }
    //获取不同用户类别的个人信息
    private void queryOneUserInfo(String type, String userType, String username, HttpServletRequest request, HttpServletResponse response) {
        String url = null;
        String name = null;
        if ("学生".equals(type) || "学生".equals(userType)) {
            infoService = ServicesFactory.getStudentInfoService();
            url = "/StuSelectJsp.jsp";
            name = "stuInfo";
        } else if ("老师".equals(type) || "老师".equals(userType)) {
            infoService = ServicesFactory.getTeacherInfoService();
            name = "teaInfo";
            url = "/TeaSelectJsp.jsp";
        } else if ("管理员".equals(type) || "管理员".equals(userType)) {
            try {
                response.sendRedirect("/myweb/ManagerJsp.jsp");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            request.setAttribute(name, infoService.queryOne(username));
            request.getRequestDispatcher(url).forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    //搜索栏查询信息
    private void queryBySearch(String searchParam, PrintWriter out,String page, String type) {
        if ("stu".equals(type)) {
            infoService = ServicesFactory.getStudentInfoService();
        } else if ("tea".equals(type)) {
            infoService = ServicesFactory.getTeacherInfoService();
        } else if ("classBase".equals(type)) {
            infoService =  ServicesFactory.getClassBaseInfoService();
        } else if ("classroom".equals(type)) {
            infoService = ServicesFactory.getClassroomInfoService();
        } else if ("courseBase".equals(type)) {
            infoService = ServicesFactory.getCourseBaseInfoService();
        } else if ("courseTable".equals(type)) {
            infoService = ServicesFactory.getCourseTableInfoService();
        }
        List list =  infoService.queryListBySearch("%" + searchParam.trim() + "%", page);
        if (list != null) {
            out.write(PrintJson.convertJson(list));
        }
    }
    //获取搜索结果返回的总页数
    private void queryPageSizeBySearch(HttpServletResponse response, PrintWriter out, String reqParam, InfoService infoService) {
        if (!reqParam.equals("")) {
            Integer pageSize = infoService.getPageSizeBySearch("%" + reqParam.trim() + "%");
            out.write(String.valueOf(pageSize));
        }
    }
    //查找所有信息
    private void queryAllInfo(InfoService infoService, PrintWriter out) {
        List list = infoService.queryList();
        if (list != null) {
            out.print(PrintJson.convertJson(list));
        }
    }
}