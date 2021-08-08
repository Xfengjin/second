package com.fengjin.success.factory.abstractfactory.order;

import com.fengjin.success.factory.abstractfactory.pizza.Pizza;

/**
 * @author: Arno.Feng
 * @description:抽象工厂接口
 * @date: 2020/12/15
 */
public interface AbsFactory {

    public Pizza createPizza(String orderType);
}
