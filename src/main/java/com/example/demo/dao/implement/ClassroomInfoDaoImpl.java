package com.example.demo.dao.implement;

import com.example.demo.dao.ClassroomInfoDao;
import com.example.demo.domain.ClassroomInfo;
import com.example.demo.util.JdbcUtils;

import java.util.List;

public class ClassroomInfoDaoImpl implements ClassroomInfoDao {
    @Override
    public List queryList() {
        String sql = "select classroomNo, isMulClassroom, capacity, status from classroom_info";
        return JdbcUtils.queryList(sql, ClassroomInfo.class);
    }

    @Override
    public List queryList(Object... args) {
        return null;
    }

    @Override
    public int updateData(Object... args) {
        String sql = "update classroom_info set capacity=?,isMulClassroom=?,status=? where classroomNo=?";
        return JdbcUtils.update(sql, args);
    }

    @Override
    public Object queryOne(Object... args) {
        String sql = "select * from classroom_info where classroomNo=?";
        return JdbcUtils.queryOne(sql, ClassroomInfo.class, args);
    }

    @Override
    public List queryListByPage(Object... args) {
        String sql = "select * from classroom_info limit ?, 13";
        return JdbcUtils.queryList(sql, ClassroomInfo.class, args);
    }

    @Override
    public void delete(Object... args) {
        String sql = "delete from classroom_info where classroomNo=?";
        JdbcUtils.update(sql, args);
    }

    @Override
    public List queryListBySearch(Object... args) {
        String sql = "select * from classroom_info where concat(ifnull(classroomNo,''),capacity,isMulClassroom,status) like ? limit ?, 13";
        return JdbcUtils.queryList(sql, ClassroomInfo.class, args);
    }

    @Override
    public List getPageSizeBySearch(Object... args) {
        String sql = "select * from classroom_info where concat(ifnull(classroomNo,''),capacity,isMulClassroom,status) like ?";
        return JdbcUtils.queryList(sql, ClassroomInfo.class, args);
    }

    @Override
    public int insertData(Object... args) {
        String sql = "insert into classroom_info set classroomNo=?, capacity=?, isMulClassroom=?, status=?";
        return JdbcUtils.update(sql, args);
    }
}