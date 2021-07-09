package com.fengjin.success.factory.simplefactory.pizzatsore.pizza;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Arno.Feng
 * @date: 2021/7/6
 * @description:
 */
@Slf4j
public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        log.info("给希腊披萨开始准备材料");
    }
}
