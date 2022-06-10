package com.crlclm.lovestory.utils;

import java.util.Random;

/**
 * VerifyUtils
 *
 * @author CharonCat
 * @date 2022/6/9
 */
public class VerifyUtils {
    public static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    public static String captchaCode() {
        return "";
    }
}
