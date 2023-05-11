import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class SeleniumWebSignupTest {
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open the Chrome browser
        driver = new ChromeDriver();

        //2. Input your selenium Demopage URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);

        //3. Maximise the page
        driver.manage().window().maximize();

        //4. Click on the signup button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

     @Test (priority = 0)

      public void positiveSignup() throws InterruptedException {

            //5. Input your username in the username field
            driver.findElement(By.id("user_username")).sendKeys("Fatima22222");

            //6. Locate the email address field and input an email address in the email field
            driver.findElement(By.id("user_email")).sendKeys("fumoru22222@mailinator.com");

            //7. Locate the password field and input your password on the username field
            driver.findElement(By.id("user_password")).sendKeys("passcode22222");
            Thread.sleep(3000);

            //8. click on the signup button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);

        }

        @Test (priority = 1)
        public void clickUser1Item() throws InterruptedException {

            //9. click on meaghan item on the list page
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
            Thread.sleep(5000);

            //verify that when a user clicks on signup button, the user is directed to signup page

            String expectedurl = "https://selenium-blog.herokuapp.com";
            String actualurl = driver.getCurrentUrl();
            if(actualurl.contains(expectedurl))
                //pass
                System.out.println("Correct Webpage");

            else
                //fail
                System.out.println("Wrong Webpage");

        }

        @Test (priority = 2)
        public void verifyitem() throws InterruptedException {
            //10. Search for an item using python with selenium and confirm it is present
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            Thread.sleep(5000);

            String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
            String actualPageUrl = driver.getTitle();
            if (actualPageUrl.contains(expectedPageUrl))
                //pass
                System.out.println("Correct User1page");

            else
                //fail
                System.out.println("Wrong User1page");

            //11. click logout
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
            Thread.sleep(5000);

            // verify that when a user logout, he/she is directed to the homepage
            String expectedTitle = "AlphaBlog";
            String actualTitle = driver.getTitle();
            if(expectedTitle.contains(actualTitle))
                //pass
                System.out.println("Correct User1page");

            else
                //fail
                System.out.println("Wrong User1page");

            //11b. click on the signup page
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
            Thread.sleep(5000);
           }


         @Test (priority = 3)
         public void invalidusername() throws InterruptedException {

        // verify that user can not register with username less than three characters

        //12. locate username field and enter an invalid username less than three characters
        driver.findElement(By.id("user_username")).sendKeys("fa");

        //13. locate email field and enter a valid email address
        driver.findElement(By.id("user_email")).sendKeys("fumoru22111111111@mailinator.com");

        //14. locate password field and enter a valid password
             driver.findElement(By.id("user_password")).sendKeys("passcode2211111111");
             Thread.sleep(3000);

             //15. click on the signup button
             driver.findElement(By.id("submit")).click();
             Thread.sleep(5000);

         //16. reload the signup page
         driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
         Thread.sleep(5000);
         }


    @Test (priority = 4)
    public void invalidemail()  throws InterruptedException {

        // verify that user can not register with invalid email

        //17. locate username field and enter a valid username
        driver.findElement(By.id("user_username")).sendKeys("fumoru222222");

        //18. locate email field and enter an invalid email address
        driver.findElement(By.id("user_email")).sendKeys("fumoru22111111111!mailinator.com");

        //19. locate password field and enter a valid password
        driver.findElement(By.id("user_password")).sendKeys("passcode221111");
        Thread.sleep(3000);

        //20. click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

        //21. reload the signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    public void invalidpassword()  throws InterruptedException {

        // verify that user can not register with an invalid password

        //22. locate username field and enter a valid username
        driver.findElement(By.id("user_username")).sendKeys("fumoru222222");

        //23. locate email field and enter a valid email address
        driver.findElement(By.id("user_email")).sendKeys("fumoru22111111111@mailinator.com");

        //24. locate password field and enter an invalid password
        driver.findElement(By.id("user_password")).sendKeys("p");
        Thread.sleep(3000);

        //25. click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

        //26. reload the signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
    }


    @Test (priority = 6)
    public void emptyusernamefield() throws InterruptedException {

        // verify that user can not register when username field is empty

        //23. locate username field and leave it empty
        driver.findElement(By.id("user_username")).sendKeys("");

        //24. locate email field and enter a valid email address
        driver.findElement(By.id("user_email")).sendKeys("fumoru22111111111@mailinator.com");

        //24. locate password field and enter a valid password
        driver.findElement(By.id("user_password")).sendKeys("passcode221111");
        Thread.sleep(3000);

        //25. click on the signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

        //26. reload the signup page
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
    }


    @AfterTest
    public void closebrowser(){
        // Quit the browser
        driver.quit();

           }


}


