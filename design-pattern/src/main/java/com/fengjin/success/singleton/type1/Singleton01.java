package com.fengjin.success.singleton.type1;

/**
 * @author: Arno.Feng
 * @date: 2021/6/30
 * @description: 饿汉式(静态常量)
 */
public class Singleton01 {
    public static void main(String[] args) {
        SingleTon instance = SingleTon.getInstance();
        SingleTon instance1 = SingleTon.getInstance();
        System.out.println(instance == instance1);
    }
}

class SingleTon {
    /**
     * 构造器私有化（防止new）
     */
    private SingleTon() {}

    /**
     *
     *
     * 类的内部创建对象
     */
    private final static SingleTon instance = new SingleTon();

    /**
     * 向外暴露一个公共的静态方法
     */
    public static SingleTon getInstance() {
        return instance;
    }
}
