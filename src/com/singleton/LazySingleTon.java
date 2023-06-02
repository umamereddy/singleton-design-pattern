package com.singleton;

import java.io.Serializable;

public class LazySingleTon extends MyClone  {

    private static LazySingleTon instance;
    private LazySingleTon(){
        if(instance!=null){
            throw new IllegalStateException("Object can't create a by using reflection");
        }

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
         throw  new CloneNotSupportedException();
    }

    public static synchronized LazySingleTon getInstance(){
        if(instance == null) {
            return instance = new LazySingleTon();
        } else {
            return instance;
        }
    }
}
