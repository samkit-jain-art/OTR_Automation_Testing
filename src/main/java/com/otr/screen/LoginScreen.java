package com.otr.screen;

import com.otr.Action.ActionPage;
import com.otr.driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen extends ActionPage {

    @AndroidFindBy(id = "android:id/content")
    @iOSXCUITFindBy(accessibility = "")
    MobileElement splashScreen;


    public LoginScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(
                DriverManager.getWebDriver()),this);
    }

}
