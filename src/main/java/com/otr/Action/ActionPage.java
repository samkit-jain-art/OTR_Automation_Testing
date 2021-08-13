package com.otr.Action;

import com.otr.driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class ActionPage {



    protected void chooseItemAndClick(String name, List<MobileElement> elements) {
        elements.parallelStream()
                .filter(mobileElement -> mobileElement.getText().contains(name))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    protected void click(MobileElement mobileElement, String elementName) {
        mobileElement.click();
        System.out.println(elementName + "is clicked successfully");
    }

    protected void click(By by, String elementName) {
        click((MobileElement) DriverManager.getWebDriver().findElement(by), elementName);
        System.out.println(elementName + "is clicked successfully");
    }

    protected void click(String locatorType, String value, String elementName) {
        if (locatorType.equalsIgnoreCase("xpath")) {
            click(By.xpath(value), elementName);
        }
        System.out.println(elementName + "is clicked successfully");
    }

    protected void scrollToSpecificElementAndClick(By by ) {
        while (DriverManager.getWebDriver().findElements(by).isEmpty()) {
            Dimension dimension = DriverManager.getWebDriver().manage().window().getSize();
            double screenHeightStart = dimension.getHeight() * 0.5;
            int scrollStart = (int) screenHeightStart;
            double screenHeightEnd = dimension.getHeight() * 0.2;
            int scrollEnd = (int) screenHeightEnd;
            int center = (int) (dimension.width * 0.5);
            new AndroidTouchAction((PerformsTouchActions) DriverManager.getWebDriver())
                    .press(PointOption.point(center, scrollStart))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(center, scrollEnd)).release().perform();
            if (!DriverManager.getWebDriver().findElements(by).isEmpty()) {
                DriverManager.getWebDriver().findElement(by).click();
            }
        }
    }

    protected void dragAndDrop(AndroidElement source, AndroidElement target) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getWebDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
    }

    protected void swipe(AndroidElement source, AndroidElement target){
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getWebDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
    }

    protected void longPress(AndroidElement androidElement){
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getWebDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(androidElement)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .perform();
    }

    protected void tap(AndroidElement androidElement){
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getWebDriver())
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(androidElement)))
                .perform();
    }
}
