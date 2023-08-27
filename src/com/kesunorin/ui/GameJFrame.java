package com.kesunorin.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;


public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //提前准备好图片序号数组
    int[][] data = new int[4][4];

    //记录空白方块的坐标，初始化
    int x = 0;
    int y = 0;

    //随机图片
    private static final int IMAGE_NUMBER = 3;
    Random rd = new Random();
    int imgNum = rd.nextInt(IMAGE_NUMBER);

    //记录图片路径
    String imgPath = "anime" + imgNum + "\\";
    //记录背景图路径
    final String BG_PATH = "UI\\background.jpg";
    //记录胜利图路径
    final String WIN_PATH = "UI\\win.png";
    //记录公众号图片路径
    final String ABOUT_PATH = "UI\\schale.png";

    //记录一个正确的二维数组，用于判断是否胜利
    int[][] winArr = {
            {0, 1, 2, 3},
            {4, 5, 6, 7},
            {8, 9, 10, 11},
            {12, 13, 14, 15}
    };

    //计步
    int step = 0;

    //初始化菜单
    JMenuBar jMenuBar = new JMenuBar();
    //创建菜单上面的两个选项
    JMenu functionJMenu = new JMenu("功能");
    JMenu aboutJMenu = new JMenu("关于");
    //创建选项拉取的条目
    JMenuItem replayItem = new JMenuItem("重启游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem aboutItem = new JMenuItem("微信公众号");

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


    private void initImage() {

        //每次初始化清空
        this.getContentPane().removeAll();

        //判断是否胜利
        if(victory()){
            ImageIcon winImg = new ImageIcon(WIN_PATH);
            //转换Image，便于处理
            Image img = winImg.getImage();
            //缩放大小修正适应JLabel的大小
            img = img.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            //再装回ImageIcon
            winImg.setImage(img);
            //创建一个JLabel
            JLabel win = new JLabel(winImg);
            //指定位置
            win.setBounds(200, 200, 200, 200);
            this.getContentPane().add(win);


        }

        JLabel stepCount = new JLabel("步数:"+step);
        stepCount.setBounds(50,10,100,20);
        this.getContentPane().add(stepCount);


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建一个图片ImageIcon
                ImageIcon icon = new ImageIcon(imgPath + data[i][j] + ".jpg");
                //转换Image，便于处理
                Image img = icon.getImage();
                //缩放大小修正适应JLabel的大小
                img = img.getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_DEFAULT);
                //再装回ImageIcon
                icon.setImage(img);
                //创建一个JLabel
                JLabel jLabel = new JLabel(icon);
                //指定位置
                jLabel.setBounds(105 * j + 80, 105 * i + 100, 105, 105);
                //给拼图添加一个边框
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                //JLabel添加到界面
                //this.add(jLabel);
                this.getContentPane().add(jLabel);
            }
        }


        //添加背景
        ImageIcon bgImage = new ImageIcon(BG_PATH);
        JLabel background = new JLabel(bgImage);
        background.setBounds(40, 40, 500, 500);
        //把背景图片添加界面里
        this.getContentPane().add(background);

        //刷新界面
        this.getContentPane().repaint();

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

        /*int number = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                data[i][j] = tempArr[number];
                number++;
            }
        }*/

        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 15) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];
        }

        /*for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(date[i][j]+" ");
            }
            System.out.println();
        }*/
    }

    private void initJMenuBar() {


        //绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        aboutItem.addActionListener(this);

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
        //给界面添加键盘监听
        this.addKeyListener(this);
    }

    private boolean victory() {
        return Arrays.deepToString(data).equals(Arrays.deepToString(winArr));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(victory()){
            //胜利则游戏结束，直接结束方法
            return;
        }
        int code = e.getKeyCode();
//        System.out.println(code);
//        a:65 w:87
        if (code == 65) {
            this.getContentPane().removeAll();
            //创建一个图片ImageIcon
            ImageIcon icon = new ImageIcon(imgPath + "all.jpg");
            //转换Image
            Image img = icon.getImage();
            //缩放大小修正适应JLabel的大小
            img = img.getScaledInstance(105 * 4, 105 * 4, Image.SCALE_DEFAULT);
            //再装回ImageIcon
            icon.setImage(img);

            //创建一个JLabel
            JLabel all = new JLabel(icon);
            all.setBounds(80, 100, 105 * 4, 105 * 4);
            this.getContentPane().add(all);

            //添加背景
            ImageIcon bgImage = new ImageIcon(BG_PATH);
            JLabel background = new JLabel(bgImage);
            background.setBounds(40, 40, 500, 500);
            //把背景图片添加界面里
            this.getContentPane().add(background);

            this.getContentPane().repaint();
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(victory()){
            //胜利则游戏结束，直接结束方法
            return;
        }
        //左 37 上 38 右 39 下 40
        int code = e.getKeyCode();
        if (code == 37) {
            if (y < 3) {
                data[x][y] = data[x][y + 1];
                data[x][y + 1] = 15;
                y++;
                step++;
                initImage();
            }
        } else if (code == 38) {
            if (x < 3) {
                data[x][y] = data[x + 1][y];
                data[x + 1][y] = 15;
                x++;
                step++;
                initImage();
            }
        } else if (code == 39) {
            if (y > 0) {
                data[x][y] = data[x][y - 1];
                data[x][y - 1] = 15;
                y--;
                step++;
                initImage();
            }
        } else if (code == 40) {
            if (x > 0) {
                data[x][y] = data[x - 1][y];
                data[x - 1][y] = 15;
                x--;
                step++;
                initImage();
            }
        } else if (code == 87) {
            int number = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    data[i][j] = number;
                    number++;
                }
            }
            x = 3;
            y = 3;
            initImage();
        } else {
            initImage();
        }
//        System.out.println("data:" + Arrays.deepToString(data));
//        System.out.println("winArr:" + Arrays.deepToString(winArr));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //执行事件
        if(e.getSource() == replayItem){
//            System.out.println("点击了重新开始");
            initData();
            step = 0;
            initImage();
        }
        else if(e.getSource() == reLoginItem){
            this.setVisible(false);
            new LoginJFrame();
        }
        else if(e.getSource() == closeItem){
            System.exit(0);
        }
        else if(e.getSource() == aboutItem){
            JDialog about = new JDialog();
            about.setTitle("公众号");
            ImageIcon aboutImg = new ImageIcon(ABOUT_PATH);
            //转换Image，便于处理
            Image img = aboutImg.getImage();
            //缩放大小修正适应JLabel的大小
            img = img.getScaledInstance(256, 256, Image.SCALE_DEFAULT);
            //再装回ImageIcon
            aboutImg.setImage(img);
            JLabel jLabel = new JLabel(aboutImg);
            jLabel.setBounds(10,10,256,256);
            about.getContentPane().add(jLabel);
            about.setSize(400,400);
            about.setAlwaysOnTop(true);
            about.setLocationRelativeTo(null);
            //弹窗不关闭则无法操作下面的界面
            about.setModal(true);
            //弹窗显示
            about.setVisible(true);
        }

    }
}
