package com.company;

/**
 * Created by Madzia on 2015-04-23.
 */
public class SuperClass implements InterfaceA{
    protected int a;
    protected int b;

    public SuperClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int getValue(int a) {
        return a;
    }
}
