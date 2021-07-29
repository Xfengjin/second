package com.fengjin.success.builder.improve;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Arno.Feng
 * @date: 2021/7/29
 * @description:
 */
@Data
@AllArgsConstructor
public class HouseDirector {
    HouseBuilder houseBuilder = null;

    public House constructHouse() {
        houseBuilder.buildBasic();
        houseBuilder.buildWall();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
