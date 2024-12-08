package Consumer;

import javax.swing.*;

import DataBase_Insert.Insert_Orders;

import java.awt.event.*;

// 计算支付界面
public class Consumer_Change_JFrame extends JFrame implements ActionListener {
    /*
     * 变量定义：
     * j_label_money_price ->label显示总价文字
     * money_price ->实际的菜品总价
     * j_label_bid->label显示餐桌号文字
     * bid -> 餐桌号
     * j_label_pay -> label显示支付
     * j_text_pay ->支付输入文本区域
     * pay -> 实际支付
     * j_text_back ->找零文本区域
     * j_label_back ->label找零文字显示
     * money_back -> 实际找零
     */
    // 基本组件
    JButton Button_Pay;
    JTextArea Pay_Text;
    JTextArea Change_Text;
    JTextArea Board_ID_Text;
    // 中间变量
    int Price = 0;
    int Pay = 0;
    int Change = 0;
    String bid;
    String Board_ID;
    public Consumer_Change_JFrame(int money,String Board_ID) {
        this.Price = money;
        this.Board_ID = Board_ID;
        // 设置布局为空
        Initialize();
        Initialize_Menu();
        this.setVisible(true);

    }

    void Initialize() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("支付界面");
        this.setBounds(200, 100, 600, 500);
        this.setLayout(null);
    }

    void Initialize_Menu() {
        // label总价
        JLabel Label_Price = new JLabel("总价:" + this.Price);
        Label_Price.setBounds(275, 100, 50, 30);
        this.add(Label_Price);
        // label桌号
        JLabel Label_Board_ID = new JLabel("桌号:"+this.Board_ID);
        Label_Board_ID.setBounds(270, 150, 80, 30);
        this.add(Label_Board_ID);
        // label支付
        JLabel Label_Pay = new JLabel("支付:");
        Label_Pay.setBounds(220, 200, 80, 20);
        this.add(Label_Pay);
        // 支付文本区
        Pay_Text = new JTextArea();
        Pay_Text.setBounds(260, 200, 100, 20);
        this.add(Pay_Text);
        // label找零
        JLabel Label_Change = new JLabel("找零:");
        Label_Change.setBounds(220, 250, 80, 20);
        this.add(Label_Change);
        // 找零输出区
        Change_Text = new JTextArea();
        Change_Text.setBounds(260, 250, 100, 20);
        this.add(Change_Text);
        // 支付按钮
        Button_Pay = new JButton("支付");
        Button_Pay.setBounds(250, 300, 80, 30);
        Button_Pay.addActionListener(this);
        this.add(Button_Pay);
    }

    public void actionPerformed(ActionEvent e) {
        // 计算找零
        Pay = Integer.parseInt(Pay_Text.getText().trim());
        Change = Pay - this.Price;
        Change_Text.append("" + Change);
        // 录入订单数据
        new Insert_Orders(this.Board_ID, this.Price, Pay);
    }
}
