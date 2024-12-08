package Employer;

import javax.swing.*;
import java.awt.event.*;

// 老板界面初始化
public class Employer_Selection extends JFrame implements ActionListener {

    JRadioButton Radio_Staff_Information;
    JRadioButton Radio_Orders_Information;

    public Employer_Selection() {
        Initialize();
        this.setVisible(true);
        Initialize_Menu();
    }

    // 窗口初始化
    public void Initialize() {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(200, 100, 600, 500);
        this.setTitle("功能选择");
    }

    public void Initialize_Menu() {
        // 新建单选按钮
        Radio_Staff_Information = new JRadioButton("员工信息");
        Radio_Orders_Information = new JRadioButton("订单信息");
        // 设置单选按钮位置
        Radio_Staff_Information.setBounds(200, 240, 80, 30);
        Radio_Orders_Information.setBounds(350, 240, 80, 30);
        // 新建单选按钮组
        ButtonGroup Radio_Group = new ButtonGroup();
        // 把单选按钮添加进按钮组
        Radio_Group.add(Radio_Staff_Information);
        Radio_Group.add(Radio_Orders_Information);
        // 添加单选按钮
        this.add(Radio_Staff_Information);
        this.add(Radio_Orders_Information);
        // 新建按钮并设置位置
        JButton Button_Confirm = new JButton("确定");
        Button_Confirm.setBounds(250, 300, 80, 30);
        // 嵌板添加按钮
        Button_Confirm.addActionListener(this);
        this.add(Button_Confirm);
    }

    public void actionPerformed(ActionEvent e) {
        
        
        if(Radio_Staff_Information.isSelected()){
            this.dispose();
            new Employer_Staff_Information();
        }
        else if(Radio_Orders_Information.isSelected()){
            this.dispose();
            new Employer_Orders_Information();
        }
    }
}
