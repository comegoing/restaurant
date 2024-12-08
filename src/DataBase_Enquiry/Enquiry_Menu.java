package DataBase_Enquiry;

import java.sql.*;
import DataBase_Register.Login;

// 数据库查询菜单
public class Enquiry_Menu {
    int Records = 0;
    String[][] Data;

    public Enquiry_Menu() {
        Enquiry_Data();
    }

    public void Enquiry_Data() {
        String SQL_Get_Rows = "SELECT COUNT(*) FROM menu";
        String SQL_Records = "SELECT * FROM menu";
        int i = 0;
        // 链接数据库
        Login account = new Login();
        account.setting();
        try {
            // 初始化结构数组
            account.DataBase_Statement = account.DataBase_Connection.createStatement();
            ResultSet Rows = account.DataBase_Statement.executeQuery(SQL_Get_Rows);
            while (Rows.next()) {
                Records = Rows.getInt(1);
            }
            Data = new String[Records][3];
            ResultSet Data_Records = account.DataBase_Statement.executeQuery(SQL_Records);
            // 获取信息并转化为string，存储结构化数据
            while (Data_Records.next()) {
                String id = Data_Records.getString("Menu_ID");
                String name = Data_Records.getString("Menu_Name");
                String price = "" + Data_Records.getInt("Price");

                Data[i][0] = id;
                Data[i][1] = name;
                Data[i][2] = price;
                i++;

            }
            Rows.close();
            Data_Records.close();
            account.DataBase_Statement.close();
            account.DataBase_Connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[][] Get_Data() {
        return Data;
    }
}
