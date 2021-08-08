package com.fengjin.success.factory.abstractfactory.order;

import com.fengjin.success.factory.abstractfactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: Arno.Feng
 * @date: 2021/7/23
 * @description:
 */
public class OrderPizza {

    AbsFactory absFactory;

    public OrderPizza(AbsFactory absFactory) {
        setAbsFatory(absFactory);
    }

    private void setAbsFatory(AbsFactory absFatory) {
        Pizza pizza = null;
        String orderType = "";
        this.absFactory = absFatory;

        do {
            orderType = getType();
            pizza = absFatory.createPizza(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败");
                break;
            }
        } while (true);
    }

    private String getType() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类：");
            String s = bufferedReader.readLine();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
