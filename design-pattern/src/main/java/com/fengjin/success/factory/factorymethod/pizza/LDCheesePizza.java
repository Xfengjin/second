package com.fengjin.success.factory.factorymethod.pizza;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Arno.Feng
 * @date: 2021/7/7
 * @description:
 */
@Slf4j
public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦奶酪披萨");
        log.info("伦敦奶酪披萨开始准备原材料");
    }
}
