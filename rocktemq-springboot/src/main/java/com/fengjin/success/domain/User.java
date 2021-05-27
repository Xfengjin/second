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
public class User {
    private String userName;
    private Byte userAge;
}
