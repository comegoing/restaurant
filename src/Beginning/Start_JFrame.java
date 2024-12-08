package Beginning;

import javax.swing.*;
import Consumer.Consumer_Select_Board_JFrame;
import Employer.Employer_Login_JFrame;
import Staff.Staff_Login_JFrame;
import java.awt.event.*;

// 运行界面
public class Start_JFrame extends JFrame implements ActionListener {
    // 新建三个单选按钮
    JRadioButton Radio_Consumer = new JRadioButton("顾客");
    JRadioButton Radio_Staff = new JRadioButton("员工");
    JRadioButton Radio_Employer = new JRadioButton("老板");

    public Start_JFrame() {
        Initialize();
        Initialize_Menu();
        this.setVisible(true);
    }

    void Initialize() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("初始界面");
        this.setBounds(200, 100, 600, 500);
        this.setLayout(null);

    }

    void Initialize_Menu() {
        // 新建按钮组并添加
        ButtonGroup Button_Group = new ButtonGroup();
        Button_Group.add(Radio_Consumer);
        Button_Group.add(Radio_Staff);
        Button_Group.add(Radio_Employer);
        // 设定三单选按钮边界
        Radio_Consumer.setBounds(180, 200, 100, 30);
        Radio_Staff.setBounds(280, 200, 100, 30);
        Radio_Employer.setBounds(380, 200, 100, 30);
        // 嵌板添加三个单选按钮
        this.add(Radio_Consumer);
        this.add(Radio_Staff);
        this.add(Radio_Employer);
        // 添加确定按钮
        JButton Login_Button = new JButton("确定");
        Login_Button.setBounds(260, 300, 80, 30);
        this.add(Login_Button);
        Login_Button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // 判断哪个按钮被选中，开启对应的界面
        if (Radio_Consumer.isSelected()) {
            // 顾客
            new Consumer_Select_Board_JFrame();
            // 打开新窗口后关闭旧窗口
            this.dispose();

        } else if (Radio_Staff.isSelected()) {
            // 员工
            new Staff_Login_JFrame();
            // 打开新窗口后关闭旧窗口
            this.dispose();
        } else if (Radio_Employer.isSelected()) {
            // 老板
            new Employer_Login_JFrame();
            // 打开新窗口后关闭旧窗口
            this.dispose();
        }
    }

}
