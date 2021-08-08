package com.fengjin.success.singleton.type4;


/**
 * @author: Arno.Feng
 * @date: 2021/6/30
 * @description:懒汉式(线程安全，同步方法)
 */
public class Singleton01 {
    public static void main(String[] args) {
        SingleTon instance = SingleTon.getInstance();
        SingleTon instance1 = SingleTon.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }
}
class SingleTon {

    private static SingleTon singleTon;

    private SingleTon() {}

    public static synchronized SingleTon getInstance() {
        if (singleTon == null) {
            singleTon = new SingleTon();
        }

        return singleTon;
    }
}
