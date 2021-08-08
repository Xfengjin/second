package com.fengjin.success.factory.simplefactory.pizzatsore.simplefactory;

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

    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public void setFactory(SimpleFactory simpleFactory) {
        // 用户输入
        String orderType = "";
        this.simpleFactory = simpleFactory;
        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);
            if (pizza != null) {
                log.info("订购成功");
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                log.info("没有指定类型的披萨");
                break;
            }
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
