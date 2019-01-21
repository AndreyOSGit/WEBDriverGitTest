import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainDriver {


    public static void main(String[] args) throws InterruptedException {

        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://github.com/login");
        driver.findElement(By.id("login_field")).sendKeys("AndreyQA28@i.ua");
        driver.findElement(By.id("password")).sendKeys("!PassWord#123");
        driver.findElement(By.name("commit")).click();
        Thread.sleep(2000);
//
//
        driver.get("https://github.com/new");

        driver.findElement(By.id("repository_name")).sendKeys("repo145");

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[data-disable-with=\"Creating repository…\"]")).click();

        Thread.sleep(4000);  // Let the user actually see something!

        driver.get("https://github.com/AndreyGitTest/repo145/settings");
        driver.findElements(By.cssSelector("[class=\"btn btn-danger boxed-action\"]")).get(3).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#options_bucket > div.Box.Box--danger > ul > li:nth-child(4) > details > details-dialog > div.Box-body.overflow-auto > form > p > input")).sendKeys("repo145");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("form.js-normalize-submit:nth-child(3) > button")).click();
        Thread.sleep(2000);

        driver.close();
        driver.quit();
    }


}
