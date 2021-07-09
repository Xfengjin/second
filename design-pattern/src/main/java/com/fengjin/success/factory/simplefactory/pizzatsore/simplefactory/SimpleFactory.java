package com.fengjin.success.factory.simplefactory.pizzatsore.simplefactory;

import com.fengjin.success.factory.simplefactory.pizzatsore.pizza.GreekPizza;
import com.fengjin.success.factory.simplefactory.pizzatsore.pizza.Pizza;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: Arno.Feng
 * @date: 2021/7/6
 * @description:简单工厂模式
 */
@Slf4j
public class SimpleFactory {

    // 根据指定类型，返回指定的披萨
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        log.info("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        } else if (orderType.equals("cheese")) {
            pizza = new com.fengjin.success.factory.simplefactory.pizza.CheesePizza();
            pizza.setName("奶酪披萨");
        }

        return pizza;
    }
}
