package Consumer;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import DataBase_Enquiry.Enquiry_Menu;

// 顾客点餐界面
public class Consumer_Select_Food_JFrame extends JFrame implements MouseListener {
    /*
     * 变量定义
     * Screen_Size -> 屏幕窗口对象，用于获取屏幕大小
     * width -> 屏幕大小
     * Left_Text -> 左侧文本展示区域
     * Button_Recommend -> 推荐按钮
     * Button_Reset -> 重置按钮
     * Button_Confirm -> 确定按钮
     * Food_Table -> 用于记录菜品信息的表单组件
     * Menu -> 数据库查询生成的对象
     * Data -> 用于存储菜品信息的二维字符串数组
     * Columns -> 用于保存Menu表属性的字符串数组
     * Sum_Price -> 记录点餐价格的中间变量
     */
    Dimension Screen_Size = Toolkit.getDefaultToolkit().getScreenSize();
    int width = Screen_Size.width;
    // 基本组件
    JTextArea Left_Text = new JTextArea();
    JButton Button_Recommend = new JButton("推荐");
    JButton Button_Reset = new JButton("重置");
    JButton Button_Confirm = new JButton("确定");
    JTable Food_Table;
    // 中间变量
    Enquiry_Menu Menu = new Enquiry_Menu();
    String[][] Data = Menu.Get_Data();
    String[] Columns = { "菜品编号", "菜品名称", "价格" };
    int Sum_Price = 0;
    String Board_ID;

    public Consumer_Select_Food_JFrame(String Board_ID) {
        this.Board_ID = Board_ID;
        Initialize();
        Initialize_Menu();
        this.setVisible(true);
    }

    void Initialize() {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("点餐界面");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    void Initialize_Menu() {
        // 顶部表单区
        Menu_Top();
        // 左侧的文本区
        Left_Text.setBounds(100, 520, 500, 100);
        this.add(Left_Text);
        // 右侧按钮区
        Menu_Right();
    }

    // 顶部表单显示区域
    void Menu_Top() {
        // 表单内容
        DefaultTableModel model = new DefaultTableModel(Data, Columns);
        Food_Table = new JTable(model);
        // 滑动组件
        JScrollPane Scroll = new JScrollPane(Food_Table);
        Scroll.setBounds(0, 0, width, 400);
        Food_Table.addMouseListener(this);
        this.add(Scroll);
    }

    // 右侧的按钮区域
    void Menu_Right() {
        // 推荐的按钮
        Button_Recommend.setBounds(700, 550, 100, 50);
        Button_Recommend.addMouseListener(this);
        this.add(Button_Recommend);
        // 重置的按钮
        Button_Reset.setBounds(810, 550, 100, 50);
        Button_Reset.addMouseListener(this);
        this.add(Button_Reset);
        // 确定的按钮
        Button_Confirm.setBounds(920, 550, 100, 50);
        Button_Confirm.addMouseListener(this);
        this.add(Button_Confirm);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object Event_Mouse = e.getSource();
        if (Event_Mouse == Button_Recommend) {

        } else if (Event_Mouse == Button_Reset) {
            // 设置为空串
            Left_Text.setText("");
            // 价格归零
            this.Sum_Price = 0;
        } else if (Event_Mouse == Button_Confirm) {
            this.dispose();
            new Consumer_Change_JFrame(this.Sum_Price,this.Board_ID);
        } else if (Event_Mouse == Food_Table) {
            int i = Food_Table.getSelectedRow();
            Left_Text.append(Data[i][1] + " ");
            Sum_Price += Integer.parseInt(Data[i][2]);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
