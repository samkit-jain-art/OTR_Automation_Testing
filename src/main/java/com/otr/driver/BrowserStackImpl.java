package com.otr.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackImpl implements IDriver{
    @Override
    public WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"bs://c9e1a5ac4fb3f1fb4b5d0621967b3c838a0b4177");
        desiredCapabilities.setCapability("browserstack.user", "samkitjain2");
        desiredCapabilities.setCapability("browserstack.key", "yekMp3zM2DpAPAsqscgY");
        desiredCapabilities.setCapability("os_version", "9.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Google Pixel 3");
        desiredCapabilities.setCapability("project", "OTR_Automation");
        desiredCapabilities.setCapability("build", "Java Android");
        return new AndroidDriver<AndroidElement>
                (new URL("http:/hub.browserstack.com/wd/hub"),desiredCapabilities);

    }
}
