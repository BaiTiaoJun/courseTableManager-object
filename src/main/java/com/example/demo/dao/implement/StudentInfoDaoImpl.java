package com.example.demo.dao.implement;

import com.example.demo.dao.StudentInfoDao;
import com.example.demo.domain.StudentInfo;
import com.example.demo.util.JdbcUtils;

import java.util.List;

public class StudentInfoDaoImpl implements StudentInfoDao {
    @Override
    public List queryList() {
        String sql = "select no,name,sex,birthdate,dept,sclass,address,contact from student_info";
        return JdbcUtils.queryList(sql, StudentInfo.class);
    }

    @Override
    public List queryList(Object... args) {
        return null;
    }


    @Override
    public int updateData(Object... args) {
        String sql = "update student_info set name=?,sex=?,birthdate=?,dept=?,sclass=?,address=?,contact=? where no=?";
        return JdbcUtils.update(sql, args);
    }

    @Override
    public Object queryOne(Object... args) {
        String sql = "select no,name,sex,birthdate,dept,sclass,address,contact from student_info where no=?";
        return JdbcUtils.queryOne(sql, StudentInfo.class, args);
    }

    @Override
    public List queryListByPage(Object... args) {
        String sql = "select * from student_info limit ?, 13";
        return JdbcUtils.queryList(sql, StudentInfo.class, args);
    }

    @Override
    public void delete(Object... args) {
        String sql = "delete from student_info where no=?";
        JdbcUtils.update(sql, args);
    }

    @Override
    public List queryListBySearch(Object... args) {
        String sql = "select * from student_info where concat(no, name) like ? limit ?, 13";
        return JdbcUtils.queryList(sql, StudentInfo.class, args);
    }

    @Override
    public List getPageSizeBySearch(Object... args) {
        String sql = "select * from student_info where concat(no, name) like ?";
        return JdbcUtils.queryList(sql, StudentInfo.class, args);
    }

    @Override
    public int insertData(Object... args) {
        String sql = "insert into student_info set no=?,name=?,sex=?,birthdate=?,dept=?,sclass=?,address=?,contact=?";
        return JdbcUtils.update(sql, args);
    }
}