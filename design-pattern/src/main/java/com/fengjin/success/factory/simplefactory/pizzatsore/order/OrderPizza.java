package com.fengjin.success.factory.simplefactory.pizzatsore.order;

import com.fengjin.success.factory.simplefactory.pizzatsore.pizza.CheesePizza;
import com.fengjin.success.factory.simplefactory.pizzatsore.pizza.GreekPizza;
import com.fengjin.success.factory.simplefactory.pizzatsore.pizza.Pizza;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: Arno.Feng
 * @date: 2021/7/6
 * @description:
 */
@Slf4j
public class OrderPizza {

    public OrderPizza() {
        Pizza pizza = null;
        String orderType; // 订购披萨的类型
        do {
            orderType = getType();
            if (orderType.equals("greek")) {
                pizza = new GreekPizza();
            } else if (orderType.equals("cheese")) {
                pizza = new CheesePizza();
            } else {
                break;
            }
            pizza.setName(orderType);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }

    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
