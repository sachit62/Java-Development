package com.example.myApp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    @Autowired  // field injection
    private Laptop l;

//    public Dev(Laptop l){
//        this.l = l;
//    } // constructor injection

//    @Autowired
//    public void setL(Laptop l){
//        this.l = l;
//    } // setter injection

    public void build(){
        l.compile();
        System.out.println("working");
    }
}
