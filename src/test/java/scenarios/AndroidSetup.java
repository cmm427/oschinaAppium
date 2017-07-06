package scenarios;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/6/23.
 */
public class AndroidSetup {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        //capabilities.setCapability(AndroidMobileCapabilityType.NO_SIGN, "true");
        capabilities.setCapability("appiumVersion", "1.6.5");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("platform", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion","8.0.0");
        capabilities.setCapability("deviceName", "Nexus_5X_API_26_x86");
        capabilities.setCapability("appPackage", "net.oschina.app");
        capabilities.setCapability("appActivity", "net.oschina.app.LaunchActivity");
        capabilities.setCapability("app", "E:\\workspace\\oschinaProject\\apps\\osc-android-v2.8.6-release.apk");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }
}
