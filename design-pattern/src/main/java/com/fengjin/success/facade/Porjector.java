package com.fengjin.success.facade;

/**
 * @author fengjin
 * @Data 2021/8/9
 * @Description 致敬大师，致敬未来的你
 */
public class Porjector {

    private static Porjector instance = new Porjector();

    public static Porjector getInstance() {
        return instance;
    }

    public void on() {
        System.out.println("porjector on");
    }

    public void off() {
        System.out.println("porjector off");
    }

    public void focus() {
        System.out.println("prjector is focus");
    }
}
