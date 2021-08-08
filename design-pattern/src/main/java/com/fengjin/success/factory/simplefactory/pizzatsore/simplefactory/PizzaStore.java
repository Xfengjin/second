package com.fengjin.success.factory.simplefactory.pizzatsore.simplefactory;

/**
 * @author: Arno.Feng
 * @date: 2021/7/6
 * @description:
 */
public class PizzaStore {
    public static void main(String[] args) {
        OrderPizza orderPizza = new OrderPizza(new SimpleFactory());
    }
}
