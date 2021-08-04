package com.fengjin.success.prototype.clone.deepclone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * @author: Arno.Feng
 * @date: 2021/7/28
 * @description:
 */
@Data
@AllArgsConstructor
public class DeepProtoType implements Serializable, Cloneable {

    private String name;

    private DeepCloneableTarget deepCloneableTarget;

    /**
     * 深拷贝的第一种方式，重写clone方法
     * @return
     * @throws CloneNotSupportedException
     */
    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        DeepProtoType deep = null;
        deep = (DeepProtoType) super.clone();
        deep.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
        return deep;
    }*/

    /**
     * 深拷贝的第一种方式，序列化（推荐）
     * @return
     */
    public Object deepClone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType object = (DeepProtoType) ois.readObject();

            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
