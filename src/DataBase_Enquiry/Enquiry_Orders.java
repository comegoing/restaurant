package DataBase_Enquiry;

import java.sql.*;
import DataBase_Register.Login;

// 数据库查询订单
public class Enquiry_Orders {
    String[][] MYSQL_Data;
    String MYSQL_All = "";
    String MYSQL_OID_Last = "";
    int length = 0;

    public Enquiry_Orders() {
        enquiry();
    }

    public void enquiry() {
        String MYSQL = "SELECT * FROM orders";
        String MYSQL_Get_Rows = "SELECT COUNT(*) FROM orders";
        // 链接数据库

        Login account = new Login();
        account.setting();
        try {
            // 数据库查询
            account.DataBase_Statement = account.DataBase_Connection.createStatement();
            ResultSet Rows = account.DataBase_Statement.executeQuery(MYSQL_Get_Rows);
            while (Rows.next()) {
                length = Rows.getInt(1);
            }
            MYSQL_Data = new String[length][6];

            ResultSet Result_MYSQL_All = account.DataBase_Statement.executeQuery(MYSQL);
            int i = 0;
            // 获取信息并转化为string
            while (Result_MYSQL_All.next()) {
                String Orders_ID = Result_MYSQL_All.getString("Orders_ID");
                String Orders_Time = Result_MYSQL_All.getString("Orders_Time");
                String Board_ID = Result_MYSQL_All.getString("Board_ID");
                String Price = Result_MYSQL_All.getString("Price");
                String Pay = Result_MYSQL_All.getString("Pay");
                String Change = Result_MYSQL_All.getString("Change");
                MYSQL_Data[i][0] = Orders_ID;
                MYSQL_Data[i][1] = Orders_Time;
                MYSQL_Data[i][2] = Board_ID;
                MYSQL_Data[i][3] = Price;
                MYSQL_Data[i][4] = Pay;
                MYSQL_Data[i][5] = Change;

                MYSQL_All = MYSQL_All + "订单号:" + Orders_ID + ",日期:" + Orders_Time + ",餐桌号:" + Board_ID + ",总价:" + Price
                        + ",支付:" + Pay
                        + ",找回:"
                        + Change + "\n";
                MYSQL_OID_Last = Orders_ID;
                i++;
            }
            Rows.close();
            Result_MYSQL_All.close();
            account.DataBase_Statement.close();
            account.DataBase_Connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String Get_All() {
        return MYSQL_All;
    }

    public String Get_Last_OID() {
        return MYSQL_OID_Last;
    }

    public String[][] Get_Data() {
        return MYSQL_Data;
    }
}
