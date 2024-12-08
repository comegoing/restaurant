package DataBase_Enquiry;

import java.sql.*;
import DataBase_Register.Login;

// 数据库老板账号匹配操作
public class Enquiry_Employer_Account {
    String[] Employer_Account;
    String[] Employer_PassWord;
    int Rows_Length = 0;

    public Enquiry_Employer_Account() {
        enquiry();
    }

    public void enquiry() {
        Login account = new Login();
        account.setting();
        try {
            account.DataBase_Statement = account.DataBase_Connection.createStatement();
            String MYSQL_Records = "SELECT * FROM account_employer";
            String MYSQL_Rows = "SELECT COUNT(*) FROM account_employer";

            ResultSet Result_MYSQL_Rows = account.DataBase_Statement.executeQuery(MYSQL_Rows);
            while (Result_MYSQL_Rows.next()) {
                Rows_Length = Result_MYSQL_Rows.getInt(1);
            }
            Employer_Account = new String[Rows_Length];
            Employer_PassWord = new String[Rows_Length];
            int i = 0;
            ResultSet Result_MYSQL_Records = account.DataBase_Statement.executeQuery(MYSQL_Records);
            while (Result_MYSQL_Records.next()) {
                Employer_Account[i] = Result_MYSQL_Records.getString("Employer_Account");
                Employer_PassWord[i] = Result_MYSQL_Records.getString("Employer_PassWord");
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
        return Employer_Account;
    }

    public String[] Get_PassWord() {
        return Employer_PassWord;
    }
}
