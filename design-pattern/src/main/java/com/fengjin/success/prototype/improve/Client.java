package com.fengjin.success.prototype.improve;

/**
 * @author fengjin
 * @Data 2021/7/27
 * @Description 致敬大师，致敬未来的你 - 原型模式
 */
public class Client {

    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom", 1, "白色");

        Sheep clone = (Sheep) sheep.clone();
        Sheep clone2 = (Sheep) sheep.clone();
        Sheep clone3 = (Sheep) sheep.clone();
        Sheep clone4 = (Sheep) sheep.clone();
    }
}
