package com.swy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
    /**
     * JDBC的URL
     */
    private static final String create_tabel_url = "jdbc:mysql:localhost:3306/java_api_interfacz?useUnicode=true%characterEncoding=UTF-8";
    /**
     * 加载驱动程序
     */
    private static final String name = "com.mysql.jdbc.Driver";
    //数据库账号
    private static final String user = "yeshuwei";
    //数据库密码
    private static final String password = "960911";

    private Connection connection = null;
    public PreparedStatement preparedStatement = null;

    public DBHelper(String sql) {
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName(name);
            System.out.println("成功加载MySQL驱动！");
            connection = DriverManager.getConnection(create_tabel_url, user, password);
            //创建Statement对象
            preparedStatement = (PreparedStatement) connection.createStatement();
            System.out.print("成功连接到数据库！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.connection.close();
            this.preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
