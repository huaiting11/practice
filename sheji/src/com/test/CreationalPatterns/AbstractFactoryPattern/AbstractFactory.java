package com.test.CreationalPatterns.AbstractFactoryPattern;

import com.test.CreationalPatterns.Bean.Color;
import com.test.CreationalPatterns.Bean.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
