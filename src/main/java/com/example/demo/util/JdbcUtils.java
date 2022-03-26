package com.example.demo.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
/**
 *  增删改：JDBCUtils.update(sql, 参数);
 * 	查询列表：JDBCUtils.queryList(sql, Product.class, 参数);
 * 	查询一个：JDBCUtils.queryOne(sql, Product.class, 参数);
*/

public class JdbcUtils {
    private static String url;
    private static String username;
    private static String password;
    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbcinfo");
        String driver = resourceBundle.getString("driver");
        try {
            Class.forName(driver);
            url = resourceBundle.getString("url");
            username = resourceBundle.getString("username");
            password = resourceBundle.getString("password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }

    public static PreparedStatement getStatement(String sql) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return preparedStatement;
    }

    public static void release(Connection connection, PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    public static void release(Connection connection, PreparedStatement preparedStatement,ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        release(connection, preparedStatement);
    }

    public static <T> List<T> queryList(String sql, Class<T> clazz, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> list = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            setStatement(preparedStatement, args);
            resultSet = preparedStatement.executeQuery();
            Field[] fields = clazz.getDeclaredFields();
            while (resultSet.next()) {
                T t = clazz.newInstance();
                for (Field field : fields) {
                    String property = field.getName();
                    String value = resultSet.getString(property);
                    field.setAccessible(true);
                    field.set(t, value);
                }
                list.add(t);
            }
        } catch (SQLException | InstantiationException | IllegalAccessException sqlException) {
            sqlException.printStackTrace();
        } finally {
            release(connection, preparedStatement, resultSet);
        }
        return list;
    }

    private static void setStatement(PreparedStatement preparedStatement, Object... args) throws SQLException {
        if (args != null) {
            for (int count = 0; count < args.length; count++) {
                preparedStatement.setObject(count + 1, args[count]);
            }
        }
    }

    public static <T> T queryOne(String sql, Class<T> clazz, Object... args) {
        List<T> list = queryList(sql, clazz, args);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public static int update(String sql, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int n = -1;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            setStatement(preparedStatement, args);
            n = preparedStatement.executeUpdate();
            return n;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            release(connection, preparedStatement);
        }
        return n;
    }
}
