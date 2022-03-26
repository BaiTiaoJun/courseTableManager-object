package com.example.demo.dao.implement;

import com.example.demo.dao.ClassBaseInfoDao;
import com.example.demo.domain.ClassBaseInfo;
import com.example.demo.util.JdbcUtils;

import java.util.List;

public class ClassBaseInfoDaoImpl implements ClassBaseInfoDao {
    @Override
    public List queryList() {
        String sql = "select classNo, dept, classNum, enYear, instructor from classbase_info";
        return JdbcUtils.queryList(sql, ClassBaseInfo.class);
    }

    @Override
    public List queryList(Object... args) {
        return null;
    }

    @Override
    public int updateData(Object... args) {
        String sql = "update classbase_info set dept=?,classNum=?,enYear=?,instructor=? where classNo=?";
        return JdbcUtils.update(sql, args);
    }

    @Override
    public Object queryOne(Object... args) {
        String sql = "select * from classbase_info where classNo=?";
        return JdbcUtils.queryOne(sql, ClassBaseInfo.class, args);
    }

    @Override
    public List queryListByPage(Object... args) {
        String sql = "select * from classbase_info limit ?, 13";
        return JdbcUtils.queryList(sql, ClassBaseInfo.class, args);
    }

    @Override
    public void delete(Object... args) {
        String sql = "delete from classbase_info where classNo=?";
        JdbcUtils.update(sql, args);
    }

    @Override
    public List queryListBySearch(Object... args) {
        String sql = "select * from classbase_info where concat(ifnull(classNo, ''), ifnull(dept, ''), ifnull(enYear, '')) like ? limit ?, 13";
        return JdbcUtils.queryList(sql, ClassBaseInfo.class, args);
    }

    @Override
    public List getPageSizeBySearch(Object... args) {
        String sql = "select * from classbase_info where concat(ifnull(classNo, ''), ifnull(dept, ''), ifnull(enYear, '')) like ?";
        return JdbcUtils.queryList(sql, ClassBaseInfo.class, args);
    }

    @Override
    public int insertData(Object... args) {
        String sql = "insert into classbase_info set classNo=?,dept=?,classNum=?,enYear=?,instructor=?";
        return JdbcUtils.update(sql, args);
    }
}