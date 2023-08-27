package com.kesunorin.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerTest implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("事件被执行");
    }
}
