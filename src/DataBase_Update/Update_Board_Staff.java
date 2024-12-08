package DataBase_Update;

public class Update_Board_Staff extends Update {
    static String Table_Name_Board = "board";
    static String Key_Board = "Staff_ID";
    static String Index_Board = "Board_ID";

    public Update_Board_Staff(String s1, String s2) {
        super(Table_Name_Board, Key_Board, s1, Index_Board, s2);
        super.Update_MySql();
    }
}
