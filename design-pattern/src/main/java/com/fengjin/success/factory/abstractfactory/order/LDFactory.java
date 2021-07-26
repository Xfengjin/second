package com.fengjin.success.factory.abstractfactory.order;

import com.fengjin.success.factory.abstractfactory.pizza.LDCheesePizza;
import com.fengjin.success.factory.abstractfactory.pizza.LDPepperPizza;
import com.fengjin.success.factory.abstractfactory.pizza.Pizza;

/**
 * @author: Arno.Feng
 * @date: 2021/7/23
 * @description:
 */
public class LDFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
