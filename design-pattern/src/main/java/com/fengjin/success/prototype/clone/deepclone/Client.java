package com.fengjin.success.prototype.clone.deepclone;

/**
 * @author: Arno.Feng
 * @date: 2021/7/28
 * @description:
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType deepProtoType = new DeepProtoType("proto", new DeepCloneableTarget("s", "a"));

        /*DeepProtoType clone = (DeepProtoType) deepProtoType.clone();*/
        DeepProtoType clone = (DeepProtoType) deepProtoType.deepClone();

        System.out.println(deepProtoType == clone);
        System.out.println(deepProtoType.getDeepCloneableTarget() == clone.getDeepCloneableTarget());
    }
}
