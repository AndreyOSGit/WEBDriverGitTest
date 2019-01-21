import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testCreateRepo {

   static WebDriver driver;

    @BeforeClass
    public static void IPrepareTests() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://github.com/login");
        driver.findElement(By.id("login_field")).sendKeys("AndreyQA28@i.ua");
        driver.findElement(By.id("password")).sendKeys("!PassWord#123");
        driver.findElement(By.name("commit")).click();
        Thread.sleep(2000);
//DElete account
     try {
         driver.get("https://github.com/AndreyGitTest/repo145/settings");
         driver.findElements(By.cssSelector("[class=\"btn btn-danger boxed-action\"]")).get(3).click();
         Thread.sleep(2000);
         driver.findElement(By.cssSelector("#options_bucket > div.Box.Box--danger > ul > li:nth-child(4) > details > details-dialog > div.Box-body.overflow-auto > form > p > input")).sendKeys("repo145");
         Thread.sleep(2000);
         driver.findElement(By.cssSelector("form.js-normalize-submit:nth-child(3) > button")).click();
         Thread.sleep(2000);
     } catch (Exception e){
         System.out.println("No git repository - all clear!!! ");
     }
        driver.close();
        driver.quit();

    }


    @Before
    public void IStartTest() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        driver.findElement(By.id("login_field")).sendKeys("AndreyQA28@i.ua");
        driver.findElement(By.id("password")).sendKeys("!PassWord#123");
        driver.findElement(By.name("commit")).click();
        Thread.sleep(2000);

    }


    @Test
    public void ICreatREpoWithNameRepo() throws InterruptedException {

        driver.get("https://github.com/new");
        Thread.sleep(1000);
        driver.findElement(By.id("repository_name")).sendKeys("repo145");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[data-disable-with=\"Creating repository…\"]")).click();
        Thread.sleep(4000);

        Assert.assertTrue(
            driver.findElement(By.id("empty-setup-push-repo-echo")  ).getText().contains("repo145.git"))
        ;

    }

    @After
    public void IEndhTest(){

        driver.close();
        driver.quit();

    }


}
