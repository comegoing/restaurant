package DataBase_Update;

import DataBase_Register.Login;

// 更新父类，用以继承
public class Update {
    public String Table_Name;
    public String Key;
    public String Key_Values;
    public String Index;
    public String Index_Values;

    public Update(String s1, String s2, String s3, String s4, String s5) {
        Table_Name = s1;
        Key = s2;
        Key_Values = s3;
        Index = s4;
        Index_Values = s5;

        Update_MySql();
    }

    public void Update_MySql() {
        Login account = new Login();
        account.setting();
        try {
            account.DataBase_Statement = account.DataBase_Connection.createStatement();
            String sql = "UPDATE " + this.Table_Name + " SET " + this.Key + "=" + this.Key_Values + " WHERE "
                    + this.Index
                    + " = '" + this.Index_Values + "'";
            account.DataBase_Statement.executeUpdate(sql);
            account.DataBase_Statement.close();
            account.DataBase_Connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
