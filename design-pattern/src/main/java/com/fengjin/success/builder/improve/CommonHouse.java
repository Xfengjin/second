package com.fengjin.success.builder.improve;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Arno.Feng
 * @date: 2021/7/29
 * @description:
 */
@Slf4j
public class CommonHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        log.info("普通房子打地基5米");
    }

    @Override
    public void buildWall() {
        log.info("普通房子砌墙10cm");
    }

    @Override
    public void roofed() {
        log.info("普通房子封顶50cm");
    }
}
