package com.example.demo.domain;

public class Single {

    public static Single single;

    public synchronized Single getSingle(){

        if(single == null){
            return new Single();
        }
        return single;
    }
}
