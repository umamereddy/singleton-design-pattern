package com.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) throws CloneNotSupportedException, InvocationTargetException, InstantiationException, IllegalAccessException {
        LazySingleTon instance1  = LazySingleTon.getInstance();
        //LazySingleTon instance2  = LazySingleTon.getInstance();
        System.out.println("instance1: " + instance1.hashCode());
        //System.out.println("instance2: " + instance2.hashCode());

        //with clone method there is chance of creating new instance for singleton class.
        //to restrict this we should override the clone method and thrown amn exception from it.
       // LazySingleTon instance2  = (LazySingleTon) instance1.clone();
        //System.out.println("instance2: " + instance2.hashCode());

        // By using reflection we can create a second instance for singleton
        // to restrict through reflection please throw a exception from private constructor
        // if(instance!=null){
        //      throw new IllegalStateException("Object can't create a by using reflection");
        //    }
        LazySingleTon reflectionInstance = null;
        Constructor[] constructors = LazySingleTon.class.getDeclaredConstructors();

        for(Constructor constructor : constructors){
            constructor.setAccessible(true);
            reflectionInstance = (LazySingleTon) constructor.newInstance();
        }

        System.out.println("reflectionInstance: " + reflectionInstance.hashCode());



    }
}
