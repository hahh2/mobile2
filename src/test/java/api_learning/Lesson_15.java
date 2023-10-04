package api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import platform.Platform;

import java.util.concurrent.TimeUnit;

import static driver.DriverFactory.getDriver;

public class Lesson_15 {
    public static void main(String[] args){
        AppiumDriver<MobileElement> appiumDriver = getDriver(Platform.ANDROID);

        try {
            MobileElement navLoginScreenBtn = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLoginScreenBtn.click();

            MobileElement emailInput = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passInput = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginBtn = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            emailInput.sendKeys("hahh@gmail.com");
            passInput.sendKeys("12345678");
            loginBtn.click();
            WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, 5);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("android:id/alertTitle")));
            MobileElement alertSuccess = appiumDriver.findElement(MobileBy.id("android:id/alertTitle"));
            System.out.println("Get text success login " + alertSuccess.getText());

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(appiumDriver != null) appiumDriver.quit();
    }
}
