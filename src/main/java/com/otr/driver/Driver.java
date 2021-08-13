package com.otr.driver;

import com.otr.enums.Modes;
import com.otr.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;


import static com.otr.driver.DriverManager.*;
import static java.util.Objects.*;


public final class Driver {
    private Driver() {
    }

    public static void initDriver() throws MalformedURLException {
        if (isNull(getWebDriver())) {
            String modeValue = PropertyUtils.getPropertyValue("mode");
            WebDriver driver = DriverFactory.get(Modes.valueOf(modeValue.toUpperCase()));
            setWebDriver(driver);
        }
    }

    public static void quitDriver() {
        if (nonNull(getWebDriver())) {
            getWebDriver().quit();
            unLoadWebDriver();
        }
    }
}
