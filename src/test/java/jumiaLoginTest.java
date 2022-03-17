import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.cdimascio.dotenv.Dotenv;
import org.testng.internal.annotations.IBeforeTest;

public class jumiaLoginTest {
    private WebDriver driver;
    private Dotenv dotenv;



    @BeforeTest
    public void beforeTest (){
        //Configure environment variables to store email and password
        dotenv =  Dotenv.configure()
                .directory("./src/test/resources")
                .ignoreIfMalformed()
                .load();
    }



    @Test
    public void begin() throws InterruptedException {

        System. setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.jumia.com.ng/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //click on account button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div/div[2]/div[1]/label")).click();
        //click on sign in button
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
        //Enter email
        driver.findElement(By.name("email")).sendKeys(dotenv.get("EMAIL"));
        //Enter the password
        driver.findElement(By.name("password")).sendKeys(dotenv.get("PASSWORD"));
        Thread.sleep(5000);
        //click on login
        driver.findElement(By.xpath("//*[@id=\"authForm\"]/button")).click();
        Thread.sleep(10000);
        //click on "Hi,Temitope" button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div/div[2]/div[1]/label")).click();
        Thread.sleep(5000);
        //click on logout
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div/div[2]/div[1]/div/div/form")).click();
    };
    @AfterTest
    public void done() {
        driver.quit();
    };

}
