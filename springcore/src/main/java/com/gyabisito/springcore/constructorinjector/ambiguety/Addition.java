package com.gyabisito.springcore.constructorinjector.ambiguety;

import com.gyabisito.springcore.constructorinjector.Address;

public class Addition {
    Addition(int a, double b){
        System.out.println("Inside Addition Double");
    }
//    Addition(int a, int b){
//        System.out.println("Inside Addition INT");
//    }
//    Addition(String a, String b){
//        System.out.println("Inside Addition String");
//    }
}
