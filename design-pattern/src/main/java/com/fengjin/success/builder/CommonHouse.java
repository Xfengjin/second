package com.fengjin.success.builder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Arno.Feng
 * @date: 2021/7/29
 * @description:
 */
@Slf4j
public class CommonHouse extends AbstractHouse {
    @Override
    public void buildBasic() {
       log.info("普通房子打地基");
    }

    @Override
    public void buildWalls() {
        log.info("普通房子砌墙");
    }

    @Override
    public void roofed() {
        log.info("普通房子封顶");
    }
}
