package com.fengjin.success.adapter.objectAdapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author fengjin
 * @Data 2021/8/3
 * @Description 致敬大师，致敬未来的你
 */
@Slf4j
public class VoltageAdapter implements Voltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        /*;
        int dst = src / 44;*/
        int dst = 0;
        if (voltage220V != null) {
            int src = voltage220V.output220V();
            log.info("使用对象适配器进行适配");
            dst = src / 44;
            log.info("适配完成，输出的电压{}", dst);
        }
        return dst;
    }
}
