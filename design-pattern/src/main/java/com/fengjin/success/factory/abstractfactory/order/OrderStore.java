package com.fengjin.success.factory.abstractfactory.order;

/**
 * @author: Arno.Feng
 * @date: 2021/7/23
 * @description:
 */
public class OrderStore {
    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }
}
