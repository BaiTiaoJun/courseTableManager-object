package com.example.demo.web.controller;

import com.example.demo.domain.StudentInfo;
import com.example.demo.domain.TeacherInfo;
import com.example.demo.domain.UserInfo;
import com.example.demo.service.InfoService;
import com.example.demo.util.ServicesFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/login.do")
public class LogServlet extends HttpServlet {
    private final InfoService userInfoService = ServicesFactory.getUserInfoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if(session.getAttribute("userType").equals("学生") || session.getAttribute("userType").equals("老师")) {
                response.sendRedirect("/myweb/UserPassUpdateJsp.jsp");
            }
        } else {
            response.sendRedirect("/myweb/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        String flag = (String) session.getAttribute("isFlag");
        String isLogin = req.getParameter("isLogin");
        String userType;
        resp.setContentType("text/html;charset=utf-8");
        Iterator iterator = userInfoService.queryList().iterator();
        List list;
        if ("isLogin".equals(isLogin)) {
            String type = (String) session.getAttribute("userType");
            resp.getWriter().print(type);
            return;
        }
        while (iterator.hasNext()) {
            UserInfo logInfo =(UserInfo) iterator.next();
            if (logInfo.getUsername().equals(username) && logInfo.getPassword().equals(password)) {
                if (flag == null) {
                    userType = logInfo.getUsertype().trim();
                    if (userType.equals("老师")) {
                        list = ServicesFactory.getTeacherInfoService().queryList();
                        for (Object obj : list) {
                            if (((TeacherInfo) obj).getNo().equals(username)) {
                                session.setAttribute("name", ((TeacherInfo) obj).getName());
                                break;
                            }
                        }
                    } else if (userType.equals("学生")) {
                        list = ServicesFactory.getStudentInfoService().queryList();
                        for (Object obj : list) {
                            if (((StudentInfo) obj).getNo().equals(username)) {
                                session.setAttribute("name", ((StudentInfo) obj).getName());
                                break;
                            }
                        }
                    }
                    session.setAttribute("isFlag", "true");
                    session.setAttribute("username", username);
                    session.setAttribute("password", password);
                    session.setAttribute("userType", userType);
                    resp.getWriter().print(userType);
                }
                return;
            }
        }
        if ("true".equals(flag)){
            doGet(req, resp);
        }
    }
}
