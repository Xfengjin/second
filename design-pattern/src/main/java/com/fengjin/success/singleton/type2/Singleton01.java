package com.fengjin.success.singleton.type2;

/**
 * @author: Arno.Feng
 * @date: 2021/6/30
 * @description:
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
     * 在静态代码块中创建单例对象
     */
    static {
        instance = new SingleTon();
    }

    private static SingleTon instance;

    /**
     * 向外暴露一个公共的静态方法
     * @return
     */
    public static SingleTon getInstance() {
        return instance;
    }
}
