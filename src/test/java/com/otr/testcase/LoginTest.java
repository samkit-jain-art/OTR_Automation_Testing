package com.otr.testcase;


import com.otr.Listeners.ListenersClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Listeners(ListenersClass.class)
public class LoginTest extends BaseTest {

    @Test()
    public void verifySplashScreen()  {
        System.out.println("App has started");


    }




}
