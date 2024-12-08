package Staff;

import javax.swing.*;
import DataBase_Enquiry.Enquiry_Board;
import DataBase_Update.Update_Board_Staff;
import java.awt.event.*;

// 员工选择餐桌界面
public class Staff_Select_Board_JFrame extends JFrame implements ActionListener {

    JTextArea Board_Information_Area;
    JTextField Board_ID_Text;
    JButton Button_Confirm;
    JMenu Function = new JMenu("功能");
    JMenuItem Re_Login = new JMenuItem("重新登录");
    JMenuItem Person_Information = new JMenuItem("个人信息");

    String Board_ID;
    String Staff_ID;

    public Staff_Select_Board_JFrame(String s1) {
        this.Staff_ID = s1;
        Initialize();
        Initialize_Menu();
        this.setVisible(true);
    }

    void Initialize_Menu() {
        // 创建菜单对象
        JMenuBar Menu_Bar = new JMenuBar();
        this.setJMenuBar(Menu_Bar);
        Function.add(Re_Login);
        Function.add(Person_Information);
        Menu_Bar.add(Function);
        Re_Login.addActionListener(this);
        Person_Information.addActionListener(this);

        Board_Information_Area = new JTextArea();
        Enquiry_Board Board_Information_MYSQL = new Enquiry_Board();
        Board_Information_Area.append(Board_Information_MYSQL.Get_All());
        Board_Information_Area.setBounds(0, 0, 600, 200);
        this.add(Board_Information_Area);
        // label选择您的餐桌号
        JLabel Label_Board_ID = new JLabel("请选择服务的桌号:");
        Label_Board_ID.setBounds(150, 300, 120, 20);
        this.add(Label_Board_ID);
        // 餐桌号输入
        Board_ID_Text = new JTextField(5);
        Board_ID_Text.setBounds(280, 300, 100, 20);
        this.add(Board_ID_Text);
        // 按钮确定
        Button_Confirm = new JButton("确定");
        Button_Confirm.setBounds(250, 400, 80, 30);
        Button_Confirm.addActionListener(this);
        this.add(Button_Confirm);
    }

    public void Initialize() {
        this.setTitle("餐桌界面");
        this.setBounds(200, 100, 600, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
    }

    public void actionPerformed(ActionEvent e) {
        Object Action_Source = e.getSource();
        if (Action_Source == Button_Confirm) {
            Board_ID = Board_ID_Text.getText().trim();
            new Update_Board_Staff(Staff_ID, Board_ID);
            this.dispose();
            new Staff_Select_Board_JFrame(this.Staff_ID);
        }
        else if(Action_Source == Re_Login){
            this.dispose();
            new Staff_Login_JFrame();
        }
        else if(Action_Source == Person_Information){
            this.dispose();
            new Staff_Information_Person_JFrame(this.Staff_ID);
        }

    }
}
