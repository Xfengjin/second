package com.fengjin.success.factory.abstractfactory.order;

import com.fengjin.success.factory.abstractfactory.pizza.BJCheesePizza;
import com.fengjin.success.factory.abstractfactory.pizza.BJPepperPizza;
import com.fengjin.success.factory.abstractfactory.pizza.Pizza;

/**
 * @author: Arno.Feng
 * @date: 2021/7/23
 * @description:
 */
public class BJFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
