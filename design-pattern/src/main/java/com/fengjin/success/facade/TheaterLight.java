package com.fengjin.success.facade;

/**
 * @author fengjin
 * @Data 2021/8/9
 * @Description 致敬大师，致敬未来的你
 */
public class TheaterLight {

    private static TheaterLight instance = new TheaterLight();

    public static TheaterLight getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("TheaterLight on");
    }

    public void off() {
        System.out.println("TheaterLight off");
    }

    public void dim() {
        System.out.println("TheaterLight dim");
    }

    public void bright() {
        System.out.println("TheaterLight bright");
    }
}
