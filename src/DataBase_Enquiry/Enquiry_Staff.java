package DataBase_Enquiry;

import java.sql.*;
import DataBase_Register.Login;

// 数据库查询所有员工信息
public class Enquiry_Staff {
    String Key;
    String Staff_Information_All = "";
    String Staff_Information_Person = "";

    public Enquiry_Staff() {
        enquiry();
    }

    public Enquiry_Staff(String s1) {
        this.Key = s1;
    }

    public void enquiry() {
        Login account = new Login();
        account.setting();
        try {
            account.DataBase_Statement = account.DataBase_Connection.createStatement();
            String MYSQL = "SELECT * FROM staff";
            ResultSet Result_MYSQL = account.DataBase_Statement.executeQuery(MYSQL);
            while (Result_MYSQL.next()) {
                String id = Result_MYSQL.getString("Staff_ID");
                String name = Result_MYSQL.getString("Staff_Name");
                String sex = Result_MYSQL.getString("Gender");
                int age = Result_MYSQL.getInt("Age");
                int salary = Result_MYSQL.getInt("Salary");
                if (id.equals(this.Key)) {
                    this.Staff_Information_Person = this.Staff_Information_Person + "工号:" + id + ", 姓名:" + name + ",性别:"
                            + sex + ",年龄:"
                            + age + ",工资:" + salary;
                }
                Staff_Information_All = Staff_Information_All + "工号:" + id + ", 姓名:" + name + ",性别:" + sex + ",年龄:"
                        + age + ",工资:" + salary
                        + "\n";
            }
            Result_MYSQL.close();
            account.DataBase_Statement.close();
            account.DataBase_Connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String Get_Information_All() {
        return Staff_Information_All;
    }

    public String Get_Information_Person() {
        return Staff_Information_Person;
    }
}
