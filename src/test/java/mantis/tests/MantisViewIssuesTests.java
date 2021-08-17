package mantis.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.List;

public class MantisViewIssuesTests {

    @Test
    public void countingViewIssuesTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://academ-it.ru/mantisbt/login_page.php");
        driver.manage().window().maximize();

        WebElement usernameInput = driver.findElement(By.cssSelector("#username"));
        usernameInput.sendKeys("admin");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.findElement(By.cssSelector("#password")).sendKeys("admin20");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        driver.findElement(By.cssSelector("a[href='/mantisbt/view_all_bug_page.php']")).click();

        List<WebElement> list = driver.findElements(By.xpath("//table[@id='buglist']/tbody/tr"));
        Assertions.assertEquals(50, list.size());

        driver.findElement(By.xpath("//div[@id='navbar-container']/div/a/span")).click();

        Thread.sleep(2311);

        driver.quit();
    }
}
