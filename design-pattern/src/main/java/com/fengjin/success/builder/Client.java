package com.fengjin.success.builder;

/**
 * @author: Arno.Feng
 * @date: 2021/7/29
 * @description:
 */
public class Client {

    public static void main(String[] args) {
        AbstractHouse house = new CommonHouse();
        house.build();
    }
}
