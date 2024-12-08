package DataBase_Update;

// 更新员工工资
public class Update_Staff extends Update {
    static String Table_Name_Staff = "staff";
    static String Key_Staff = "Salary";
    static String Index_Staff = "Staff_ID";

    public Update_Staff(String s1, String s2) {
        super(Table_Name_Staff, Key_Staff, s1, Index_Staff, s2);
    }
}
