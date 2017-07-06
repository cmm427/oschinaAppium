package scenarios;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.NewsPage;

/**
 * Created by Administrator on 2017/7/3.
 */
public class NewsTest extends AndroidSetup {
    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void titleTest() throws InterruptedException {
        NewsPage np = new NewsPage(driver);
        np.testTitleText();
        np.testDefaultNav();
    }

    @Test
    public void searchTest() throws InterruptedException {
        NewsPage np = new NewsPage(driver);
        np.testTitleSearchIocn();
    }

    @Test
    public void addIconTest() throws InterruptedException {
        NewsPage np = new NewsPage(driver);
        np.testAddIconIsDisplayed();
    }

    @Test
    public void swipeTest() throws InterruptedException {
        NewsPage np = new NewsPage(driver);
        np.testSwipeNav();
    }

    @Test
    public void swipeImageTest() throws InterruptedException {
        NewsPage np = new NewsPage(driver);
        np.testSwipeImage();
    }

    @Test
    public void addItemTest() throws InterruptedException {
        NewsPage np = new NewsPage(driver);
        np.testAddIconAdding();
    }
}
