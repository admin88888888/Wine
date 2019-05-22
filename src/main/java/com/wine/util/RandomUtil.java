package com.wine.util;

import java.util.Random;

/**
 * Created by Administrator on 2019/5/5.
 */
public class RandomUtil {
    //生成指定位数的随机数字  4   1000-9999
    public static int createNum(int len){
        Random random=new Random();
        return (int)(random.nextInt((int)(Math.pow(10,len)-Math.pow(10,len-1)))+Math.pow(10,len-1));
    }
}
