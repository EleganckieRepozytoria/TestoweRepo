package com.company;

/**
 * Created by Madzia on 2015-04-23.
 */
public class Class extends SuperClass {
    public int c;
    public Class(int a, int b, int c){
        super(a,b);
        this.c = c;
    }

    @Override
    public int getValue(int a) {
        return super.getValue(a);
    }
}
