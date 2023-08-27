package com.kesunorin.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrameTest extends JFrame implements ActionListener {
    public MyJFrameTest(){
        this.setSize(600,600);
        //标题
        this.setTitle("标题");
        //设置界面置顶
        //this.setAlwaysOnTop(true);
        //设置居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        //0关不掉 1隐藏 2全部窗口关闭才关闭虚拟机 3关掉任何一个窗口就终止虚拟机
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        JButton jtb1 = new JButton("按钮");
        jtb1.setBounds(0,2,100,50);
        jtb1.addActionListener(this);
        this.getContentPane().add(jtb1);


        //显示界面，写在最后
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("事件执行");
    }
}
