package Employer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Operation.Compare_Information;

// 此类用于老板登录
public class Employer_Login_JFrame extends JFrame implements ActionListener {
    JTextField Employer_Account_Text;// 新建账号文本区域
    JTextField Employer_PassWord_Text;// 新建密码文本区域
    JButton Button_Login;// 新建按钮区域
    String Employer_Account;
    String Employer_PassWord;

    public Employer_Login_JFrame() {
        // 设置嵌板布局为空
        Initialize();
        // 新建两个label并设置位置，添加到嵌板中
        // label记录账号
        Initialize_Menu();
        this.setVisible(true);
    }

    private void Initialize() {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(200, 100, 600, 500);
        this.setTitle("登录");
        this.setLayout(null);
    }

    private void Initialize_Menu() {
        JLabel Label_Account = new JLabel("账号:");
        Label_Account.setBounds(200, 200, 30, 20);
        this.add(Label_Account);
        // label记录密码
        JLabel Label_PassWord = new JLabel("密码:");
        Label_PassWord.setBounds(200, 240, 30, 20);
        this.add(Label_PassWord);
        // 新建两个文本区域并设置位置，添加到嵌板中
        // 账号
        Employer_Account_Text = new JTextField(11);
        Employer_Account_Text.setBounds(240, 200, 150, 20);
        this.add(Employer_Account_Text);
        // 密码
        Employer_PassWord_Text = new JTextField(11);
        Employer_PassWord_Text.setBounds(240, 240, 150, 20);
        this.add(Employer_PassWord_Text);
        // 新建一个按钮并设置位置，添加到嵌板中
        Button_Login = new JButton("登录");
        Button_Login.setBounds(250, 300, 80, 30);
        Button_Login.addActionListener(this);
        this.add(Button_Login);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Employer_Account = Employer_Account_Text.getText().trim();
        Employer_PassWord = Employer_PassWord_Text.getText().trim();
        Compare_Information Result_Compare = new Compare_Information(Employer_Account, Employer_PassWord, "Employer");
        if (Result_Compare.Account_State()) {
            this.dispose();
            new Employer_Selection();
        } else {
            // 登录失败报错
            JOptionPane.showMessageDialog(this, "账号或密码错误", "错误",
                    JOptionPane.WARNING_MESSAGE);
        }

    }
}
