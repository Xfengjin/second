package com.fengjin.success.facade;

/**
 * @author fengjin
 * @Data 2021/8/9
 * @Description 致敬大师，致敬未来的你
 */
public class Screen {

    private static Screen instance = new Screen();

    public static Screen getInstance() {
        return instance;
    }

    public void up() {
        System.out.println("Screen up");
    }

    public void down() {
        System.out.println("Screen down");
    }
}
