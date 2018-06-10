package com.torrres.utils;

/**
 * Created by Torres
 * 2018-06-10 10:46
 */
public class Test {

    // 测试主函数
    public static void main(String args[]) {
        // 原文
        String plaintext = "config";
        //  plaintext = "123456";
        System.out.println("原始：" + plaintext);
        System.out.println("普通MD5后：" + MD5Util.MD5(plaintext));

        // 获取加盐后的MD5值
        String ciphertext = MD5Util.generate(plaintext);
        System.out.println("加盐后MD5：" + ciphertext);
        System.out.println("是否是同一字符串:" + MD5Util.verify(plaintext, ciphertext));

    }
}