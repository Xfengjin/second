package com.fengjin.success.factory.simplefactory.pizzatsore.pizza;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: Arno.Feng
 * @date: 2021/7/6
 * @description:
 */
@Slf4j
@Data
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
