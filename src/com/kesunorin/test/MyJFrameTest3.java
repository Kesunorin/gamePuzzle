package com.kesunorin.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrameTest3 extends JFrame implements KeyListener {
    public MyJFrameTest3(){
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

        this.addKeyListener(this);





        //显示界面，写在最后
        this.setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("正在输入");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("正在按住");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开了键");
        System.out.println(e.getKeyCode());
    }
}
