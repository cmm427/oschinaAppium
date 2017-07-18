package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Administrator on 2017/7/3.
 */
public class NewsPage extends BasePage{
    By tv_title = By.id("net.oschina.app:id/tv_title");
    By iv_icon = By.id("net.oschina.app:id/iv_icon");
    By nav = By.className("android.support.v7.app.a$f");
    By iv_arrow_down = By.id("net.oschina.app:id/iv_arrow_down");
    By tv_done = By.id("net.oschina.app:id/tv_done");
    By items = By.className("android.widget.FrameLayout");
    By search = By.id("net.oschina.app:id/tv_cancel");
    By iv_banner = By.id("net.oschina.app:id/iv_banner");

    By recycler = By.id("net.oschina.app:id/view_recycler_active");

    public NewsPage(WebDriver driver){
        super(driver);
    }

    public NewsPage testTitleText() {
        waitForVisibilityOf(tv_title);
        WebElement element = driver.findElement(tv_title);
        System.out.println(element.getText());
        Assert.assertEquals("综合", element.getText());

        return new NewsPage(driver);
    }

    public NewsPage testTitleSearchIocn() {
        waitForVisibilityOf(iv_icon);
        WebElement element = driver.findElement(iv_icon);
        Assert.assertEquals(true, element.isDisplayed());
        element.click();
        waitForVisibilityOf(search);
        driver.findElement(search).click();
        //((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

        return new NewsPage(driver);
    }

    public NewsPage testDefaultNav() {
        waitForVisibilityOf(nav);
        /*waitForVisibilityOf(iv_arrow_down);
        (driver.findElement(iv_arrow_down)).click();
        waitForVisibilityOf(tv_done);
        (driver.findElement(tv_done)).click();
        WebElement rc = driver.findElement(recycler);
        List<WebElement> els = rc.findElements(By.className("android.widget.FrameLayout"));
        for(WebElement el : els) {
            WebElement tmp = el.findElement(By.className("android.widget.TextView"));
            String str = tmp.getText();
            System.out.println(str);
        }
        (driver.findElement(iv_arrow_down)).click();*/


        List<WebElement> elements = driver.findElements(nav);
        final String[] strs = {"开源资讯","推荐博客","技术问答","每日一博"};
        int idx = 0;
        for(WebElement el : elements){
            WebElement tmp = el.findElement(By.className("android.widget.TextView"));
            String str = tmp.getText();
            System.out.println(str);
            if(idx < 4){
                Assert.assertEquals(strs[idx], str);
            }
            idx++;
        }

        return new NewsPage(driver);
    }

    public NewsPage testAddIconIsDisplayed() {
        WebElement element = driver.findElement(iv_arrow_down);
        Assert.assertEquals(true, element.isDisplayed());

        return new NewsPage(driver);
    }

    public NewsPage testAddIconAdding() {
        WebElement element = driver.findElement(iv_arrow_down);
        element.click();
        waitForVisibilityOf(tv_done);
        List<WebElement> elements = driver.findElements(items);
        for(WebElement el : elements) {
            //System.out.println(el.findElement(By.className("android.widget.TextView")).getText());
        }
        WebElement narrow_down = driver.findElement(iv_arrow_down);
        narrow_down.click();

        return new NewsPage(driver);
    }

    public NewsPage testSwipeNav() {
        List<WebElement> elements = driver.findElements(nav);
        WebElement start = (elements.get(1)).findElement(By.className("android.widget.TextView"));
        WebElement end = (elements.get(3)).findElement(By.className("android.widget.TextView"));
        int startX = start.getLocation().getX();
        int startY = start.getLocation().getY();
        int endX = end.getLocation().getX();
        int endY = end.getLocation().getY();
        ((AndroidDriver) driver).swipe(endX, endY, startX, startY, 1000);
        ((AndroidDriver) driver).swipe(startX, startY, endX, endY, 1000);

        return new NewsPage(driver);
    }

    public NewsPage testSwipeImage() {
        WebElement element = driver.findElement(iv_banner);

        int startx = element.getLocation().getX() + element.getSize().getWidth() / 8;
        int starty = element.getLocation().getY() + element.getSize().getHeight() / 2;
        int endx = element.getLocation().getX() + 7 * (element.getSize().getWidth()) / 8;
        int endy = element.getLocation().getY() + element.getSize().getHeight() / 2;

        for(int i = 0; i < 10; i++){
            ((AndroidDriver) driver).swipe(startx, starty, endx, endy, 2000);
        }

        return new NewsPage(driver);
    }
}
