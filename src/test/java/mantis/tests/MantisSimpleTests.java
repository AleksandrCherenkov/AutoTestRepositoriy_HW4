package mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MantisSimpleTests {

    @Test
    public void successfulLoginTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://academ-it.ru/mantisbt/login_page.php");
        driver.manage().window().maximize();

        WebElement usernameInput = driver.findElement(By.cssSelector("#username"));
        usernameInput.sendKeys("admin");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.findElement(By.cssSelector("#password")).sendKeys("admin20");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        String actualUserName = driver.findElement(By.cssSelector("a[data-toggle='dropdown'] span")).getText();
        Assertions.assertEquals("admin", actualUserName);
        Assertions.assertEquals("https://academ-it.ru/mantisbt/my_view_page.php",
                driver.getCurrentUrl());

        List<WebElement> list = driver.findElements(By.cssSelector("#unassigned tr"));
        Assertions.assertEquals(10, list.size());

        Thread.sleep(3000);

        driver.quit();
    }
}
