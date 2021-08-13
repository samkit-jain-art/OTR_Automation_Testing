package com.otr.facade;

import com.github.javafaker.Faker;

public class FakerFacade {


    public static void getPersonName(){
        new Faker().name().fullName();
    }

}
