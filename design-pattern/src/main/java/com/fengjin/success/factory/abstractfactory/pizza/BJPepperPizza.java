package com.fengjin.success.factory.abstractfactory.pizza;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Arno.Feng
 * @date: 2021/7/7
 * @description:
 */
@Slf4j
public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京胡椒披萨");
        log.info("北京胡椒披萨开始准备原材料");
    }
}
