package com.fengjin.success.prototype.clone.deepclone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: Arno.Feng
 * @date: 2021/7/28
 * @description:
 */
@Data
@AllArgsConstructor
@ToString
public class DeepCloneableTarget implements Serializable, Cloneable {

    private static final long serialVersionID = 1L;

    private String cloneName;

    private String cloneClass;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
