package com.fengjin.rabbitmq.success.workqueue;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author fengjin
 * @Data 2021/5/9
 * @Description 致敬大师，致敬未来的你
 */
@Data
@AllArgsConstructor
public class SMS {
    private String name;
    private String mobile;
    private String content;
}
