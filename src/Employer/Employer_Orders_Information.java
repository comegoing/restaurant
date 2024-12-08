package Employer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DataBase_Enquiry.Enquiry_Orders;

// 此类用于老板查询订单信息
public class Employer_Orders_Information extends JFrame {
    String[] Columns = { "订单编号", "订单时间", "餐桌号","总价","支付","找零" };
    String[][] Data;
    JTable Food_Table;

    public Employer_Orders_Information() {
        Initialize();
        Initialize_Menu();
        this.setVisible(true);
        // 往餐桌嵌板中添加组件
        // 所有员工信息

    }

    private void Initialize_Menu() {
        Enquiry_Orders Orders_MYSQL = new Enquiry_Orders();
        this.Data = Orders_MYSQL.Get_Data();
        DefaultTableModel model = new DefaultTableModel(Data, Columns);
        Food_Table = new JTable(model);
        // 滑动组件
        JScrollPane Scroll = new JScrollPane(Food_Table);
        Scroll.setBounds(0, 0, 600, 500);
        this.add(Scroll);
    }

    public void Initialize() {
        this.setTitle("订单界面");
        this.setBounds(200, 100, 600, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
