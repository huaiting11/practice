package com.test.creationalPatterns.abstractFactoryPattern;

import com.test.Bean.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
