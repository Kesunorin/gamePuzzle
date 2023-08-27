package com.kesunorin.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class GameJFrame extends JFrame {
    //提前准备好图片序号数组
    int[][] data = new int[4][4];

    //JFrame 表示界面
    //继承之后 子类也表示界面  即该类也是界面
    //所以GameJFrame表示界面。
    public GameJFrame() {
        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //打乱图片
        initData();
        //初始化放图片的Label
        initImage();


        //显示界面，要写在最后，因为要前面设置好，才显示出来
        this.setVisible(true);
    }

    private static final int ICON_WIDTH = 105;
    private static final int ICON_HEIGHT = 105;
    private static final int IMAGE_NUMBER = 3;


    private void initImage() {
        Random rd = new Random();
        int imgNum = rd.nextInt(IMAGE_NUMBER);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建一个图片ImageIcon
                ImageIcon icon = new ImageIcon("D:\\IdeaProjects\\gamePuzzle\\anime" + imgNum + "\\" + data[i][j] + ".jpg");
                //转换Image，便于处理
                Image img = icon.getImage();
                //缩放大小修正适应JLabel的大小
                img = img.getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_DEFAULT);
                //再装回ImageIcon
                icon.setImage(img);
                //创建一个JLabel
                JLabel jLabel = new JLabel(icon);
                //指定位置
                jLabel.setBounds(105 * j, 105 * i, 105, 105);
                //JLabel添加到界面
                //this.add(jLabel);
                this.getContentPane().add(jLabel);
            }
        }
    }

    private void initData() {
        //打乱一维数组，生成二维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random rd = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = rd.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        /*for (int j : tempArr) {
            System.out.println(j);
        }*/
        int number = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                data[i][j] = tempArr[number];
                number++;
            }
        }
        /*for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(date[i][j]+" ");
            }
            System.out.println();
        }*/
    }

    private void initJMenuBar() {
        //初始化菜单
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单上面的两个选项
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于");
        //创建选项拉取的条目
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem aboutItem = new JMenuItem("微信公众号");

        //选项添加条目
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(aboutItem);

        //菜单添加选项
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //界面宽高
        this.setSize(603, 680);
        //标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        //this.setAlwaysOnTop(true);
        //设置居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        //0关不掉 1隐藏 2全部窗口关闭才关闭虚拟机 3关掉任何一个窗口就终止虚拟机
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认居中放置
        this.setLayout(null);
    }
}
