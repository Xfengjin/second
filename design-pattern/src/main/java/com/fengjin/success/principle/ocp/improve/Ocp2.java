package com.fengjin.success.principle.ocp.improve;

/**
 * @author: Arno.Feng
 * @date: 2021/6/29
 * @description: 开闭原则
 */
class Ocp1 {

    public static void main(String[] args) {
        GraphicEditor1 graphicEditor = new GraphicEditor1();
        graphicEditor.drawShape(new Rectangle1());
        graphicEditor.drawShape(new Circle1());
    }
}

class GraphicEditor1{
    public void drawShape(Shape1 shape) {
        shape.draw();
    }
}

abstract class Shape1 {
    int mType;
    abstract void draw();
}

class Rectangle1 extends Shape1 {
    Rectangle1() {
        super.mType = 1;
    }

    @Override
    void draw() {
        System.out.println("矩形");
    }
}

class Circle1 extends Shape1 {
    Circle1() {
        super.mType = 2;
    }

    @Override
    void draw() {
        System.out.println("圆形");
    }
}