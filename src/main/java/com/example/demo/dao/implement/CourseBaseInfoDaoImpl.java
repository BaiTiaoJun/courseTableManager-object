package com.example.demo.dao.implement;

import com.example.demo.dao.CourseBaseInfoDao;
import com.example.demo.domain.CourseBaseInfo;
import com.example.demo.util.JdbcUtils;

import java.util.List;

public class CourseBaseInfoDaoImpl  implements CourseBaseInfoDao {
    @Override
    public List queryList() {
        String sql = "select courseNo,cname,term,period,credit from coursebase_info";
        return JdbcUtils.queryList(sql, CourseBaseInfo.class);
    }

    @Override
    public List queryList(Object... args) {
        String sql = "select * from coursebase_info cb, coursetable_info ct where ct.courseNo = cb.courseNo and concat(teacherNo, cclass) like ? group by cname";
        return JdbcUtils.queryList(sql, CourseBaseInfo.class, args);
    }

    @Override
    public int updateData(Object... args) {
        String sql = "update coursebase_info set cname=?,term=?,period=?,credit=? where courseNo=?";
        return JdbcUtils.update(sql, args);
    }

    @Override
    public Object queryOne(Object... args) {
        String sql = "select * from coursebase_info where courseNo=?";
        return JdbcUtils.queryOne(sql, CourseBaseInfo.class, args);
    }

    @Override
    public List queryListByPage(Object... args) {
        String sql = "select * from coursebase_info limit ?, 13";
        return JdbcUtils.queryList(sql, CourseBaseInfo.class, args);
    }

    @Override
    public void delete(Object... args) {
        String sql = "delete from coursebase_info where courseNo=?";
        JdbcUtils.update(sql, args);
    }

    @Override
    public List queryListBySearch(Object... args) {
        String sql = "select * from coursebase_info where concat(ifnull(courseNo,''),ifnull(cname,'')) like ? limit ?, 13";
        return JdbcUtils.queryList(sql, CourseBaseInfo.class, args);
    }

    @Override
    public List getPageSizeBySearch(Object... args) {
        String sql = "select * from coursebase_info where concat(ifnull(courseNo,''),ifnull(cname,'')) like ?";
        return JdbcUtils.queryList(sql, CourseBaseInfo.class, args);
    }

    @Override
    public int insertData(Object... args) {
        String sql = "insert into coursebase_info set courseNo=?, cname=?,term=?,period=?,credit=?";
        return JdbcUtils.update(sql, args);
    }
}
