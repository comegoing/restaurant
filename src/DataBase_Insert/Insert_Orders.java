package DataBase_Insert;

import java.text.SimpleDateFormat;
import DataBase_Enquiry.Enquiry_Orders;
import DataBase_Register.Login;

// 新建订单数据
public class Insert_Orders {
    String B_ID;
    int Price;
    int Pay;

    public Insert_Orders(String s1, int s2, int s3) {
        this.B_ID = s1;
        this.Price = s2;
        this.Pay = s3;
        Loading_Orders();
    }

    void Loading_Orders() {
        Login account = new Login();
        account.setting();
        Enquiry_Orders Records = new Enquiry_Orders();
        String Last_Oid = Records.Get_Last_OID();
        // 生成新的订单编号
        Last_Oid = Last_Oid.replaceAll("o", "");
        int Temp = Integer.parseInt(Last_Oid) + 1;
        String New_ID = "o" + Temp;

        // 获取当前时间
        SimpleDateFormat Time_Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Time_Now = Time_Format.format(System.currentTimeMillis());

        try {
            account.DataBase_Statement = account.DataBase_Connection.createStatement();
            String MYSQL = "INSERT INTO orders VALUES ('" + New_ID + "','" + Time_Now + "',"
                    + this.Pay + ",'" + this.B_ID + "'," + (this.Pay - this.Price) + "," + this.Price + ")";
            account.DataBase_Statement.executeUpdate(MYSQL);
            account.DataBase_Statement.close();
            account.DataBase_Connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
