package DataBase_Update;

// 更新餐桌信息
public class Update_Board_Consumer extends Update {
    static String Table_Name_Board = "board";
    static String Key_Board = "Board_Person_Number";
    static String Index_Board = "Board_ID";

    public Update_Board_Consumer(String s1, String s2) {
        super(Table_Name_Board, Key_Board, s1, Index_Board, s2);
        super.Update_MySql();
    }
}
