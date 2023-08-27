package com.kesunorin.test;

import java.util.Random;

public class RandomArrTest {
    public static void main(String[] args) {
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
        int[][] Arr = new int[4][4];
        int number = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Arr[i][j] = tempArr[number];
                number++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(Arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
