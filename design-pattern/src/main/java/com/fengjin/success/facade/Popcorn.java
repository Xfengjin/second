package com.fengjin.success.facade;

/**
 * @author fengjin
 * @Data 2021/8/9
 * @Description 致敬大师，致敬未来的你
 */
public class Popcorn {

    private static Popcorn instance = new Popcorn();

    public static Popcorn getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("popcorn on");
    }

    public void off() {
        System.out.println("popcorn off");
    }

    public void play() {
        System.out.println("popcorn is poping");
    }

}
