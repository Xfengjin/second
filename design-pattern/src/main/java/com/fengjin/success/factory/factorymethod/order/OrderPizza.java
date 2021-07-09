package com.fengjin.success.factory.factorymethod.order;

import com.fengjin.success.factory.factorymethod.pizza.Pizza;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: Arno.Feng
 * @date: 2021/7/7
 * @description:
 */
@Slf4j
public abstract class OrderPizza {

    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {

        } while (true);
    }

    /**
     * 定义一个抽象方法
     * @param orderType
     * @return
     */
    abstract Pizza createPizza(String orderType);

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
