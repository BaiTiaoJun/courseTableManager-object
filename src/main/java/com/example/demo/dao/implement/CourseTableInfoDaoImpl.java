package com.example.demo.dao.implement;

import com.example.demo.dao.CourseTableInfoDao;
import com.example.demo.domain.CourseTableInfo;
import com.example.demo.util.JdbcUtils;

import java.util.List;

public class CourseTableInfoDaoImpl  implements CourseTableInfoDao {
    @Override
    public List queryList() {
        String sql = "select id, courseNo, cclass, teacherNo, time, site from coursetable_info";
        return JdbcUtils.queryList(sql, CourseTableInfo.class);
    }

    public List queryList(Object... obj) {
        String sql = "select id, courseNo, cclass, teacherNo, time, site from coursetable_info where time like ? and concat(teacherNo, cclass) like ?";
        return JdbcUtils.queryList(sql, CourseTableInfo.class, obj);
    }

    public List getWeek(Object... obj) {
        String sql = "select id, courseNo, cclass, teacherNo, time, site from coursetable_info where concat(teacherNo, cclass) like ?";
        return JdbcUtils.queryList(sql, CourseTableInfo.class, obj);
    }

    @Override
    public int updateData(Object... args) {
        String sql = "update coursetable_info set courseNo=?,cclass=?,teacherNo=?,time=?,site=? where id=?";
        return JdbcUtils.update(sql, args);
    }

    @Override
    public Object queryOne(Object... args) {
        String sql = "select id, courseNo, cclass, teacherNo, time, site from coursetable_info where id=?";
        return JdbcUtils.queryOne(sql, CourseTableInfo.class, args);
    }

    @Override
    public List queryListByPage(Object... args) {
        String sql = "select * from coursetable_info limit ?, 13";
        return JdbcUtils.queryList(sql, CourseTableInfo.class, args);
    }

    @Override
    public void delete(Object... args) {
        String sql = "delete from coursetable_info where id=?";
        JdbcUtils.update(sql, args);
    }

    @Override
    public List queryListBySearch(Object... args) {
        String sql = "select * from coursetable_info where concat(ifnull(courseNo,''),ifnull(cclass,''),ifnull(teacherNo,''),ifnull(time,'')) like ? limit ?, 13";
        return JdbcUtils.queryList(sql, CourseTableInfo.class, args);
    }

    @Override
    public List getPageSizeBySearch(Object... args) {
        String sql = "select * from coursetable_info where concat(ifnull(courseNo,''),ifnull(cclass,''),ifnull(teacherNo,''),ifnull(time,'')) like ?";
        return JdbcUtils.queryList(sql, CourseTableInfo.class, args);
    }

    @Override
    public int insertData(Object... args) {
        String sql = "insert into coursetable_info set courseNo=?, cclass=?, teacherNo=?, time=?, site=?";
        return JdbcUtils.update(sql, args);
    }
}