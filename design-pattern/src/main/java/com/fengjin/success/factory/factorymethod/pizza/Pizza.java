package com.fengjin.success.factory.factorymethod.pizza;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: Arno.Feng
 * @date: 2021/7/7
 * @description:
 */
@Data
@Slf4j
public abstract class Pizza {
    protected String name;

    public abstract void prepare();

    public void bake() {
        log.info(name + "baking;");
    }

    public void cut() {
        log.info(name + "cutting;");
    }

    public void box() {
        log.info(name + "boxing;");
    }
}
