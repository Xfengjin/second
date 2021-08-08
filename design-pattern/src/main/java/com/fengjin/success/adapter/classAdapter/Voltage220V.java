package com.fengjin.success.adapter.classAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author fengjin
 * @Data 2021/8/3
 * @Description 致敬大师，致敬未来的你
 */
@Slf4j
public class Voltage220V {

    public int output220V() {
        int src = 220;
        log.info("电压={}V", src);
        return src;
    }
}
