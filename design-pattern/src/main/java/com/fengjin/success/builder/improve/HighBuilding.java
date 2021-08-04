package com.fengjin.success.builder.improve;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: Arno.Feng
 * @date: 2021/7/29
 * @description:
 */
@Slf4j
public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        log.info("高楼打地基50米");
    }

    @Override
    public void buildWall() {
        log.info("高楼砌墙100cm");
    }

    @Override
    public void roofed() {
        log.info("高楼封顶500cm");
    }
}
