package com.fengjin.success.factory.factorymethod.order;

import com.fengjin.success.factory.factorymethod.pizza.BJCheesePizza;
import com.fengjin.success.factory.factorymethod.pizza.BJPepperPizza;
import com.fengjin.success.factory.factorymethod.pizza.Pizza;

/**
 * @author: Arno.Feng
 * @date: 2021/7/23
 * @description:
 */
public class BJOrderPizza extends OrderPizza {

    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }

        return pizza;
    }
}
