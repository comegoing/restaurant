package DataBase_Register;

import java.sql.*;

// 数据库登录
public class Login {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    // 数据库的用户名与密码
    static final String UserName = "root";
    static final String PassWord = "lvxin20020315";
    public Connection DataBase_Connection = null;
    public Statement DataBase_Statement = null;

    public void setting() {
        try {
            DataBase_Connection = DriverManager.getConnection(DB_URL, UserName, PassWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}