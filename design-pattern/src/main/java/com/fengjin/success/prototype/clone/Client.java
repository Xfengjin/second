package com.fengjin.success.prototype.clone;


/**
 * @author: Arno.Feng
 * @date: 2021/7/28
 * @description:浅拷贝
 */
public class Client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom", 1, "白色", new Sheep("jack", 2, "黑色", null));

        Sheep clone = (Sheep) sheep.clone();

        System.out.println(clone == sheep);
        System.out.println(sheep.getFriend().hashCode());
        System.out.println(clone.getFriend().hashCode());
        System.out.println(sheep.getFriend() == clone.getFriend());
    }
}
