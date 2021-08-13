package com.otr.driver;

import com.otr.enums.Modes;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.function.Supplier;

public final class DriverFactory {
    private DriverFactory(){}
    private static final Supplier<WebDriver> LOCAL = ()-> new LocalDriverImpl().getDriver();

    public static WebDriver get(Modes modes) throws MalformedURLException {
        WebDriver driver = null;
        if (modes.equals(Modes.LOCAL)){
            driver = new  LocalDriverImpl().getDriver();
        }else if (modes.equals(Modes.BS)){
            driver = new BrowserStackImpl().getDriver();
        }else if (modes.equals(Modes.SAUCELABS)){
            driver = new SauceLabsImpl().getDriver();
        }
        return driver;
    }
}
