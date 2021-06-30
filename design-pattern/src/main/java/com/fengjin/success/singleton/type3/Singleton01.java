package com.fengjin.success.singleton.type3;

/**
 * @author: Arno.Feng
 * @date: 2021/6/30
 * @description:懒汉式(线程不安全)
 */
public class Singleton01 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }
}

class Singleton {
    private static Singleton singleton;

    private Singleton() {}

    /**
     * 只有当首次调用getInstance方法时
     * @return
     */
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
