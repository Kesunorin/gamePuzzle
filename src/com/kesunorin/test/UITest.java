package com.kesunorin.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UITest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(600,600);
        jFrame.setTitle("标题");
//        jFrame.setAlwaysOnTop(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        JButton jtb1 = new JButton("按钮");
        jtb1.setBounds(0,2,100,50);
        //添加事件
        //ActionListenerTest表示要监听什么事件
//        jtb.addActionListener(new ActionListenerTest());

        /*jtb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("使用了匿名内部类，重写事件执行");
            }
        });*/

        jtb1.addActionListener(e -> System.out.println("使用了匿名内部类，重写事件执行"));


        jFrame.getContentPane().add(jtb1);



        jFrame.setVisible(true);
    }
}
