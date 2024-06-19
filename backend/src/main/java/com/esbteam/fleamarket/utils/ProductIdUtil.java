package com.esbteam.fleamarket.utils;

import java.util.Random;

public class ProductIdUtil {

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return String.valueOf(number) + System.currentTimeMillis();
    }
}
