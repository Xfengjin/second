package com.fengjin.success.facade;

/**
 * @author fengjin
 * @Data 2021/8/9
 * @Description 致敬大师，致敬未来的你
 */
public class Client {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.ready();
        System.out.println("=============================================");
        facade.play();
        System.out.println("=============================================");
        facade.pause();
        System.out.println("=============================================");
        facade.end();
    }
}
