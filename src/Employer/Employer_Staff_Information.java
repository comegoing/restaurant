package Employer;

import javax.swing.*;
import DataBase_Enquiry.Enquiry_Staff;
import DataBase_Update.Update_Staff;

import java.awt.event.*;

// 老板修改工资界面
public class Employer_Staff_Information extends JFrame implements ActionListener {

    JTextArea Staff_Information_Area;
    JTextField Staff_ID_Text;
    JTextField Staff_Salary_Text;
    JButton Button_Change;

    String Staff_ID;
    String Staff_Salary;

    public Employer_Staff_Information() {
        Initialize();
        Initialize_Menu();
        this.setVisible(true);
    }

    private void Initialize_Menu() {
        // 往餐桌嵌板中添加组件
        // 所有员工信息
        Staff_Information_Area = new JTextArea();
        Enquiry_Staff Staff_Information_MYSQL = new Enquiry_Staff();
        Staff_Information_Area.append(Staff_Information_MYSQL.Get_Information_All());
        Staff_Information_Area.setBounds(0, 0, 600, 200);
        this.add(Staff_Information_Area);
        // label输入员工号
        JLabel Label_Staff_ID = new JLabel("请输入员工号:");
        Label_Staff_ID.setBounds(50, 300, 100, 20);
        this.add(Label_Staff_ID);
        // 员工号输入文本区
        Staff_ID_Text = new JTextField(5);
        Staff_ID_Text.setBounds(150, 300, 100, 20);
        this.add(Staff_ID_Text);
        // label说明输入工资
        JLabel Label_Staff_Salary = new JLabel("请输入工资:");
        Label_Staff_Salary.setBounds(50, 350, 100, 20);
        this.add(Label_Staff_Salary);
        // 工资输入文本区
        Staff_Salary_Text = new JTextField(5);
        Staff_Salary_Text.setBounds(150, 350, 100, 20);
        this.add(Staff_Salary_Text);
        // 按钮确定
        Button_Change = new JButton("修改");
        Button_Change.setBounds(250, 400, 80, 30);
        this.add(Button_Change);
        // 添加监听器
        Button_Change.addActionListener(this);
    }

    public void Initialize() {
        this.setTitle("员工信息");
        this.setBounds(200, 100, 600, 500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // 此监听器将会重新设置员工工资
    public void actionPerformed(ActionEvent e) {
        // 读取两个输入并更新员工信息
        Staff_ID = Staff_ID_Text.getText().trim();
        Staff_Salary = Staff_Salary_Text.getText().trim();
        new Update_Staff(Staff_Salary, Staff_ID);
        
    }

    public static void main(String[] args) {
        new Employer_Staff_Information();
    }
}
