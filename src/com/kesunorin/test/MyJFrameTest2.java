package com.kesunorin.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrameTest2 extends JFrame implements MouseListener {
    public MyJFrameTest2(){
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
        jtb1.addMouseListener(this);

        this.getContentPane().add(jtb1);




        //显示界面，写在最后
        this.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("长按");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
