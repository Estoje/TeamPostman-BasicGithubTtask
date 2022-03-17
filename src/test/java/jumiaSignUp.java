import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class jumiaSignUp {
    private
    WebDriver driver;

@Test
    public void start() {

        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.jumia.com.ng/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div/div[2]/div[1]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"jm\"]/main/div/div[2]/div/a[1]/span")).click();
        driver.findElement(By.name("firstName")).sendKeys("Temitope");
        driver.findElement(By.name("lastName")).sendKeys("Okewande");
        driver.findElement(By.name("email")).sendKeys("temiijegede@outlook.com");
        driver.findElement(By.name("password")).sendKeys("temitope");
        driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[4]/div/label")).click();
        driver.findElement(By.xpath("//*[@id=\"authForm\"]/div[7]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div/div[2]/div[1]/label")).click();
    driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form")).click();
    driver.quit();

    }
}

