package com.fengjin.success.adapter.objectAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author fengjin
 * @Data 2021/8/3
 * @Description 致敬大师，致敬未来的你
 */
@Slf4j
public class Phone {

    public void charging(Voltage5V voltage5V) {
        if (voltage5V.output5V() == 5) {
            log.info("电压为5V, 可以充电");
        } else if (voltage5V.output5V() > 5) {
            log.info("电压大于5V, 不可以充电");
        }
    }
}
