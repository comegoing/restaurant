package Staff;

import javax.swing.*;
import DataBase_Enquiry.Enquiry_Staff;
import java.awt.event.*;

// 员工查询个人信息界面
public class Staff_Information_Person_JFrame extends JFrame implements ActionListener {

    JTextArea Person_Area;
    JTextField Person_Key_Text;
    JTextField Person_Values_Text;
    JButton Button_Change;

    String Person_Key;
    String Person_Values;
    String Staff_ID;

    public Staff_Information_Person_JFrame(String s1) {
        this.Staff_ID = s1;
        Initialize();
        Initialize_Menu();
        this.setVisible(true);
    }

    void Initialize_Menu() {
        Person_Area = new JTextArea();
        Person_Area.setBounds(0, 0, 600, 200);
        Enquiry_Staff Staff_Person_Information = new Enquiry_Staff(this.Staff_ID);
        Person_Area.append(Staff_Person_Information.Get_Information_Person());
        this.add(Person_Area);
        // label输入工号
        JLabel j_person = new JLabel("请输入工号:");
        j_person.setBounds(50, 350, 100, 20);
        add(j_person);
        // 工号输入
        Person_Key_Text = new JTextField(5);
        Person_Key_Text.setBounds(150, 350, 100, 20);
        add(Person_Key_Text);
        // 按钮确定
        Button_Change = new JButton("确定");
        Button_Change.setBounds(250, 400, 80, 30);
        add(Button_Change);
        // 添加监听器
        Button_Change.addActionListener(this);
    }

    public void Initialize() {
        this.setLayout(null);
        this.setTitle("餐桌界面");
        this.setBounds(200, 100, 600, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new Staff_Information_Person_JFrame("2020211409");
    }

}
