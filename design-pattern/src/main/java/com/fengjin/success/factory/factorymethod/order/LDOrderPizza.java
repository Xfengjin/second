package com.fengjin.success.factory.factorymethod.order;

import com.fengjin.success.factory.factorymethod.pizza.LDCheesePizza;
import com.fengjin.success.factory.factorymethod.pizza.LDPepperPizza;
import com.fengjin.success.factory.factorymethod.pizza.Pizza;

/**
 * @author: Arno.Feng
 * @date: 2021/7/23
 * @description:
 */
public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
