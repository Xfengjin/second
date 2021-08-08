package com.fengjin.success.singleton.type8;

/**
 * @author: Arno.Feng
 * @date: 2021/7/1
 * @description:
 */
public class Singleton01 {

    public static void main(String[] args) {
        SingleTon instance = SingleTon.INSTANCE;
        SingleTon instance1 = SingleTon.INSTANCE;

        System.out.println(instance == instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());

    }
}

enum SingleTon {
    INSTANCE;

    public void method() {

    }
}
