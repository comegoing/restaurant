// 注释请查看enquiry_menu.java，这两个同理
package DataBase_Enquiry;

import java.sql.*;
import DataBase_Register.Login;

// 数据库查询餐桌信息
public class Enquiry_Board {
    String MYSQL_All = "";

    public Enquiry_Board() {
        Enquiry_All();
    }

    public void Enquiry_All() {
        Login account = new Login();
        account.setting();
        try {
            account.DataBase_Statement = account.DataBase_Connection.createStatement();
            String MYSQL = "SELECT * FROM board";
            ResultSet Result_MYSQL = account.DataBase_Statement.executeQuery(MYSQL);

            while (Result_MYSQL.next()) {
                String Board_ID = Result_MYSQL.getString("Board_ID");
                int Board_Person_Number = Result_MYSQL.getInt("Board_Person_Number");
                String Staff_ID = Result_MYSQL.getString("Staff_ID");
                MYSQL_All = MYSQL_All + "餐桌编号:" + Board_ID + " 就餐人数:" + Board_Person_Number + " 服务员工:" + Staff_ID + "\n";
            }
            Result_MYSQL.close();
            account.DataBase_Statement.close();
            account.DataBase_Connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String Get_All() {
        return MYSQL_All;
    }
}
