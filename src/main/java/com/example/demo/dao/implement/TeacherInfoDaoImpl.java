package com.example.demo.dao.implement;

import com.example.demo.dao.TeacherInfoDao;
import com.example.demo.domain.TeacherInfo;
import com.example.demo.util.JdbcUtils;

import java.util.List;

public class TeacherInfoDaoImpl implements TeacherInfoDao {
    @Override
    public List queryList() {
        String sql = "select no, name, dept, major, positionalTitle from teacher_info";
        return JdbcUtils.queryList(sql, TeacherInfo.class);
    }

    @Override
    public List queryList(Object... args) {
        String sql = "select * from teacher_info t, coursetable_info c where c.teacherNo=t.no and concat(no, cclass) like ? group by name";
        return JdbcUtils.queryList(sql, TeacherInfo.class, args);
    }

    @Override
    public int updateData(Object... args) {
        String sql = "update teacher_info set name=?,dept=?,major=?,positionalTitle=? where no=?";
        return JdbcUtils.update(sql, args);
    }

    @Override
    public Object queryOne(Object... args) {
        String sql = "select no, name, dept, major, positionalTitle from teacher_info where no=?";
        return JdbcUtils.queryOne(sql, TeacherInfo.class, args);
    }

    @Override
    public List queryListByPage(Object... args) {
        String sql = "select * from teacher_info limit ?, 13";
        return JdbcUtils.queryList(sql, TeacherInfo.class, args);
    }

    @Override
    public void delete(Object... args) {
        String sql = "delete from teacher_info where no=?";
        JdbcUtils.update(sql, args);
    }

    @Override
    public List queryListBySearch(Object... args) {
        String sql = "select * from teacher_info where concat(ifnull(no, ''), ifnull(name, ''), ifnull(dept, '')) like ? limit ?, 13";
        return JdbcUtils.queryList(sql, TeacherInfo.class, args);
    }

    @Override
    public List getPageSizeBySearch(Object... args) {
        String sql = "select * from teacher_info where concat(ifnull(no, ''), ifnull(name, ''), ifnull(dept, '')) like ?";
        return JdbcUtils.queryList(sql, TeacherInfo.class, args);
    }

    @Override
    public int insertData(Object... args) {
        String sql = "insert into teacher_info set no=?,name=?,dept=?,major=?,positionalTitle=?";
        return JdbcUtils.update(sql, args);
    }
}
