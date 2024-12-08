package DataBase_Enquiry;

import java.sql.*;

import DataBase_Register.Login;

// 数据库员工账号匹配操作
public class Enquiry_Staff_Account {
    String[] Staff_Account;
    String[] Staff_PassWord;
    int Rows_Length = 0;

    public Enquiry_Staff_Account() {
        enquiry();
    }

    public void enquiry() {
        Login account = new Login();
        account.setting();
        try {
            account.DataBase_Statement = account.DataBase_Connection.createStatement();
            String MYSQL_Records = "SELECT * FROM account_staff";
            String MYSQL_Rows = "SELECT COUNT(*) FROM account_staff";

            ResultSet Result_MYSQL_Rows = account.DataBase_Statement.executeQuery(MYSQL_Rows);
            while (Result_MYSQL_Rows.next()) {
                Rows_Length = Result_MYSQL_Rows.getInt(1);
            }
            Staff_Account = new String[Rows_Length];
            Staff_PassWord = new String[Rows_Length];
            int i = 0;
            ResultSet Result_MYSQL_Records = account.DataBase_Statement.executeQuery(MYSQL_Records);
            while (Result_MYSQL_Records.next()) {
                Staff_Account[i] = Result_MYSQL_Records.getString("Staff_Account");
                Staff_PassWord[i] = Result_MYSQL_Records.getString("Staff_PassWord");
                i++;
            }
            Result_MYSQL_Records.close();
            account.DataBase_Statement.close();
            account.DataBase_Connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String[] Get_Account() {
        return Staff_Account;
    }

    public String[] Get_PassWord() {
        return Staff_PassWord;
    }
}
