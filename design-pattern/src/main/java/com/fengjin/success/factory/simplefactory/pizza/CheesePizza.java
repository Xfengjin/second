package com.fengjin.success.factory.simplefactory.pizza;

import com.fengjin.success.factory.simplefactory.pizzatsore.pizza.Pizza;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: Arno.Feng
 * @date: 2021/7/6
 * @description:
 */
@Slf4j
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        log.info("给奶酪披萨开始准备材料");
    }
}
