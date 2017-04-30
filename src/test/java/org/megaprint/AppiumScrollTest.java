package org.megaprint;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Baurz on 4/18/2017.
 */
public class AppiumScrollTest {
    DesiredCapabilities cap=new DesiredCapabilities();
    AndroidDriver<AndroidElement> driver;
    @BeforeMethod
    public void init() throws MalformedURLException {
        File path=new File("data");
        File file=new File(path,"ApiDemos-debug.apk");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Demo");
        cap.setCapability(MobileCapabilityType.APP,file.getAbsolutePath());
        driver=new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),cap);
    }
    @Test
    public void scroll(){
        driver.findElementByXPath("//*[@text='Views']").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));").click();

    }
}
