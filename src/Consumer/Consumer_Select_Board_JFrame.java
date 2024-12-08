package Consumer;

import javax.swing.*;
import DataBase_Enquiry.Enquiry_Board;
import DataBase_Update.Update_Board_Consumer;
import java.awt.event.*;

// 顾客选餐桌界面
public class Consumer_Select_Board_JFrame extends JFrame implements ActionListener {
    /*
     * 变量定义：
     * Board_Area -> 文本展示区域，将展示目前餐厅所有的餐桌情况
     * Board_ID_Text -> 餐桌文本输入区
     * Person_Number_Text -> 就餐人数文本输入区
     * Board_ID -> 中间变量用于记录餐桌号
     * Person_Number -> 中间变量用于记录就餐人数
     */
    JTextArea Board_Area = new JTextArea();
    JTextField Board_ID_Text = new JTextField(5);
    JTextField Person_Number_Text = new JTextField(5);
    String Board_ID;
    String Person_Number;

    public Consumer_Select_Board_JFrame() {
        Initialize();
        Initialize_Menu();
        this.setVisible(true);
    }

    // 窗口初始化
    void Initialize() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("餐桌选择");
        this.setBounds(200, 100, 600, 500);
        this.setLayout(null);
    }

    // 组件初始化
    void Initialize_Menu() {
        // 餐桌文本显示区
        Enquiry_Board Board_Text = new Enquiry_Board();
        Board_Area.append(Board_Text.Get_All());
        Board_Area.setBounds(0, 0, 600, 200);
        this.add(Board_Area);
        // label选择您的餐桌号
        JLabel Board_ID = new JLabel("请选择您的桌号:");
        Board_ID.setBounds(50, 300, 100, 20);
        this.add(Board_ID);
        // label请说明您的说明人数
        JLabel Person_Number = new JLabel("请说明您的人数:");
        Person_Number.setBounds(50, 350, 100, 20);
        this.add(Person_Number);
        // 餐桌号输入输入区
        Board_ID_Text.setBounds(150, 300, 100, 20);
        this.add(Board_ID_Text);
        // 人数输入区
        Person_Number_Text.setBounds(150, 350, 100, 20);
        this.add(Person_Number_Text);
        // 确定按钮
        JButton Confirm_Button = new JButton("确定");
        Confirm_Button.setBounds(250, 400, 80, 30);
        this.add(Confirm_Button);
        // 添加监听器
        Confirm_Button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // 读取两个输入并更新餐桌信息
        Board_ID = Board_ID_Text.getText().trim();
        Person_Number = Person_Number_Text.getText().trim();
        new Update_Board_Consumer(Person_Number, Board_ID);
        this.dispose();
        new Consumer_Select_Food_JFrame(this.Board_ID);
    }
}
