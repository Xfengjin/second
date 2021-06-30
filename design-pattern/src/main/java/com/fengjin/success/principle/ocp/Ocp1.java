package com.fengjin.success.principle.ocp;

/**
 * @author: Arno.Feng
 * @date: 2021/6/29
 * @description: 开闭原则
 */
public class Ocp1 {

    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
    }
}

class GraphicEditor{
    public void drawShape(Shape shape) {
        if (shape.mType == 1) {
            drawRectangle(shape);
        } else if (shape.mType == 2) {
            drawCircle(shape);
        }
    }

    public void drawRectangle(Shape shape) {
        System.out.println("矩形");
    }
    
    public void drawCircle(Shape shape) {
        System.out.println("圆形");
    }
}

class Shape {
    int mType;
}

class Rectangle extends Shape {
    Rectangle() {
        super.mType = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.mType = 2;
    }
}