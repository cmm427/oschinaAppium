package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Administrator on 2017/6/23.
 */
public class LoginPage extends BasePage {
    By login_btn = By.id("bt_login_submit");
    By login = By.id("nav_item_tweet_pub");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage invalidLogin() {
        final WebDriverWait wait = new WebDriverWait(driver, 10);

        waitForVisibilityOf(login);
        driver.findElement(login).click();

        waitForVisibilityOf(login_btn);
        driver.findElement(login_btn).click();

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='请输入正确的手机号或邮箱...']")));
        System.out.println(element.getAttribute("text"));
        Assert.assertNotNull(element);

        return new LoginPage(driver);
    }

}
