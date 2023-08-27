package com.kesunorin.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    public LoginJFrame(){
        this.setSize(488,430);
        //标题
        this.setTitle("登录");
        //设置界面置顶
        //this.setAlwaysOnTop(true);
        //设置居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        //0关不掉 1隐藏 2全部窗口关闭才关闭虚拟机 3关掉任何一个窗口就终止虚拟机
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //显示界面，写在最后
        this.setVisible(true);
    }
}
