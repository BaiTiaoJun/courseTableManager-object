package com.example.demo.dao.implement;

import com.example.demo.dao.UserInfoDao;
import com.example.demo.domain.UserInfo;
import com.example.demo.util.JdbcUtils;

import java.util.List;

public class UserInfoDaoImpl implements UserInfoDao {
    @Override
    public List queryList() {
        String sql = "select username,password,usertype from user_info";
        return JdbcUtils.queryList(sql, UserInfo.class);
    }

    @Override
    public List queryList(Object... args) {
        return null;
    }

    @Override
    public int updateData(Object... args) {
        String sql = "update user_info set password=? where username=?";
        return JdbcUtils.update(sql, args);
    }

    @Override
    public Object queryOne(Object... args) {
        String sql = "select username,password,usertype from user_info where password=?";
        return JdbcUtils.queryOne(sql, UserInfo.class, args);
    }

    @Override
    public List queryListByPage(Object... args) {
        String sql = "select * from user_info limit ?, 13";
        return JdbcUtils.queryList(sql, UserInfo.class, args);
    }

    @Override
    public void delete(Object... args) {
        String sql = "delete from user_info where username=?";
        JdbcUtils.update(sql, args);
    }

    @Override
    public List queryListBySearch(Object... args) {
        return null;
    }

    @Override
    public List getPageSizeBySearch(Object... args) {
        return null;
    }

    @Override
    public int insertData(Object... args) {
        String sql = "insert into user_info set username=?,password=?,usertype=?";
        return JdbcUtils.update(sql, args);
    }

    @Override
    public Object queryOneByUsername(String username) {
        String sql = "select username, password, usertype from user_info where username=?";
        return JdbcUtils.queryOne(sql, UserInfo.class, username);
    }

    @Override
    public Integer updateAllDataByUsername(Object... args) {
        String sql = "update user_info set password=?,usertype=? where username=?";
        return JdbcUtils.update(sql, args);
    }
}
