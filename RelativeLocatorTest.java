import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorTest {
    private static ChromeDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.get("https://dgotlieb.github.io/RelativeLocator/index.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void aboveTest() {
        driver.findElement(with(By.tagName("input")).above(By.id("myButton"))).sendKeys("above");
    }

    @Test
    public void belowTest() {
        driver.findElement(with(By.tagName("input")).below(By.id("myButton"))).sendKeys("below");
    }

    @Test
    public void rightOFTest() {
        driver.findElement(with(By.tagName("input")).toRightOf(By.id("myButton"))).sendKeys("rightOf");
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }
}
