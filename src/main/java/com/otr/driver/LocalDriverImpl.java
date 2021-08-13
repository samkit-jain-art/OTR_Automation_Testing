package com.otr.driver;

import com.otr.constants.FrameworkConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;



public class LocalDriverImpl implements IDriver{
    @SneakyThrows
    @Override
    public WebDriver getDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.APP, FrameworkConstants.getInstance().getAPPPATH());
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT,"8200");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"crc641bd60ae683fa027d.LaunchView");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"air.au.com.ontherun");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"");
         return new AndroidDriver<AndroidElement>
                (new URL("http:/127.0.0.0.1:4273/wd/hub"),desiredCapabilities);
    }
}
