package Staff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Operation.Compare_Information;

// 员工登录界面
public class Staff_Login_JFrame extends JFrame implements ActionListener {

    JTextField Staff_Account_Text;
    JTextField Staff_PassWord_Text;
    JButton Button_Login;
    String Staff_Account;
    String Staff_PassWord;

    public Staff_Login_JFrame() {
        Initialize();
        Initialize_Menu();
        this.setVisible(true);
    }

    private void Initialize() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(200, 100, 600, 500);
        this.setTitle("登录");
        this.setLayout(null);
    }

    void Initialize_Menu() {
        JLabel Label_Account = new JLabel("账号:");
        Label_Account.setBounds(200, 200, 30, 20);
        this.add(Label_Account);
        // 账号输入
        Staff_Account_Text = new JTextField(11);
        Staff_Account_Text.setBounds(240, 200, 150, 20);
        this.add(Staff_Account_Text);
        // label密码
        JLabel Label_PassWord = new JLabel("密码:");
        Label_PassWord.setBounds(200, 240, 30, 20);
        this.add(Label_PassWord);
        // 密码输入
        Staff_PassWord_Text = new JTextField(11);
        Staff_PassWord_Text.setBounds(240, 240, 150, 20);
        this.add(Staff_PassWord_Text);
        // 按钮
        Button_Login = new JButton("确定");
        Button_Login.setBounds(250, 300, 80, 30);
        this.add(Button_Login);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Staff_Account = Staff_Account_Text.getText().trim();
        Staff_PassWord = Staff_PassWord_Text.getText().trim();
        Compare_Information Result_Compare = new Compare_Information(Staff_Account, Staff_PassWord, "Staff");
        if (Result_Compare.Account_State()) {
            this.dispose();
            new Staff_Select_Board_JFrame(Staff_Account);
        } else {
            // 登录失败报错
            JOptionPane.showMessageDialog(this, "账号或密码错误", "错误",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Staff_Login_JFrame();
    }
}
