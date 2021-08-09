package com.fengjin.success.facade;

/**
 * @author fengjin
 * @Data 2021/8/9
 * @Description 致敬大师，致敬未来的你
 */
public class DVDPlayer {

    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("dvd on");
    }

    public void off() {
        System.out.println("dvd off");
    }

    public void play() {
        System.out.println("dvd is playing");
    }

    public void pause() {
        System.out.println("dvd paused");
    }
}
