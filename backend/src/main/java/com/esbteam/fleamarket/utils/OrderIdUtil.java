package com.esbteam.fleamarket.utils;

import java.util.Random;

public class OrderIdUtil {

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(90000) + 10000;

        return System.currentTimeMillis()+String.valueOf(number);
    }

}
