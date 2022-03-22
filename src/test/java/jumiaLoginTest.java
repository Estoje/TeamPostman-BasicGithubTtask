import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.cdimascio.dotenv.Dotenv;
import org.testng.internal.annotations.IBeforeTest;
/*
1. Verify that the user input the right page url and his on the right page
2. verify that the user is directed to the right sign up page
3. Verify that user can successfully log out

 */

public class jumiaLoginTest {
    private WebDriver driver;
    private Dotenv dotenv;



    @BeforeTest
    public void beforeTest () throws InterruptedException {
        //Configure environment variables to store email and password
        dotenv =  Dotenv.configure()
                .directory("./src/test/resources")
                .ignoreIfMalformed()
                .load();
        //locate where the chrome driver is
        System. setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //open the chrome browser
        driver= new ChromeDriver();
        //get the page url
        driver.get("https://www.jumia.com.ng/");

        //1. Verify that the user input the right page url and his on the right page
        if(driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
            System.out.println("correctUrl");
        else
            System.out.println("wrong url");

        driver.manage().window().maximize();
        Thread.sleep(5000);}



        @Test(priority = 0)
        public void positiveSignUp() throws InterruptedException{
        //click on account button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div/div[2]/div[1]/label")).click();
        //click on sign in button
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();

        //2.verify that the user is directed to the right sign up page
        String expectedUrl = "https://www.jumia.com.ng/customer/account/login/?return=%2F";
       if(driver.getCurrentUrl().contains(expectedUrl))
           System.out.println("right login url");
       else
           System.out.println("wrong login url");
       //Enter email
        driver.findElement(By.name("email")).sendKeys(dotenv.get("EMAIL"));
        //Enter the password
        driver.findElement(By.name("password")).sendKeys(dotenv.get("PASSWORD"));
        Thread.sleep(5000);
        //click on login
        driver.findElement(By.xpath("//*[@id=\"authForm\"]/button")).click();
        Thread.sleep(5000);};

        @Test(priority = 1)
        public void afterSignUp() throws InterruptedException {
        //click on "Hi,Temitope" button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div/div[2]/div[1]/label")).click();
        Thread.sleep(5000);};

        @Test(priority= 2)
        public void logOut(){
        //click on logout
        driver.findElement(By.xpath("/html/body/div[1]/header/section/div/div[2]/div[1]/div/div/form")).click();
        //3. Verify that user can successfully log out and directed to the home page
        String expectedUrl = "https://www.jumia.com.ng/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            System.out.println("successful");
        else
            System.out.println("Unsuccessful");

        };
        @Test(priority =3  )
    public void negativeSignUp() throws InterruptedException{
        //Verify that a user can signup with incorrect password
        //click on account button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div/div[2]/div[1]/label")).click();
        //click on sign in button
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
        //Enter email
        driver.findElement(By.name("email")).sendKeys(dotenv.get("EMAIL"));
        //Enter the password
        driver.findElement(By.name("password")).sendKeys(dotenv.get("WRONGPASSWORD"));
        Thread.sleep(5000);
        //click on login
        driver.findElement(By.xpath("//*[@id=\"authForm\"]/button")).click();
        Thread.sleep(5000);};

    @Test(priority =4)
    public void negative1SignUp() throws InterruptedException{
        //Verify that a user can signup with incorrect email
        //click on account button
        driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div/div[2]/div[1]/label")).click();
        //click on sign in button
        driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
        //Enter email
        driver.findElement(By.name("email")).sendKeys(dotenv.get("WRONGEMAIL"));
        //Enter the password
        driver.findElement(By.name("password")).sendKeys(dotenv.get("PASSWORD"));
        Thread.sleep(5000);
        //click on login
        driver.findElement(By.xpath("//*[@id=\"authForm\"]/button")).click();
        Thread.sleep(5000);};



        @AfterTest
         public void done() {
         driver.quit();
    };

}
