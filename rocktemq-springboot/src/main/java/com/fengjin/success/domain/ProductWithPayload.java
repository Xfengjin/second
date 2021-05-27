package com.fengjin.success.domain;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author: Arno.Feng
 * @date: 2021/5/27
 * @description:
 */
@Data
@ToString
@Accessors(chain = true)
public class ProductWithPayload<T> {
    private String productName;
    private T payload;
}
