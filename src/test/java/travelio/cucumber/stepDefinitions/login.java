package travelio.cucumber.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import travelio.cucumber.configuration.environmentSetup;
import java.time.Duration;

public class login extends environmentSetup {
    @Given("travelio homepage")
    public void travelio_homepage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        driver = new ChromeDriver(opt);

        driver.manage().window().maximize();
        driver.get(baseURL);

        try{
            WebDriverWait wait;
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement modalBody = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.modal-body"))
            );

            WebElement closeModal = modalBody.findElement(By.cssSelector("i[data-dismiss='modal'][class='fa fa-close fa-lg close padding15']"));
            closeModal.click();
        } catch (TimeoutException e){
            System.out.println("Modal not found");
        } finally {
            String nonloginpageAssert = driver.findElement(By.xpath("//div[@id=\"loginBtn\"]")).getText();
            Assert.assertEquals(nonloginpageAssert,"Masuk");
        }

    }

    //Click Masuk
    @Then("user click login button")
    public void user_click_login_button() {
        driver.findElement(By.xpath("//div[@id=\"loginBtn\"]")).click();
    }

    //Input Email
    @When("user input email as email")
    public void user_input_email_as_email() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("shevanaufalrifqi28@gmail.com");
//        driver.findElement(By.id("login-email")).sendKeys("shevanaufalrifqi28@gmail.com");
    }

    //Input Password
    @And("user input password as password")
    public void user_input_password_as_password() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("TravelioIgnite99");
    }

    @And("user click masuk button")
    public void user_click_masuk_button() {
        driver.findElement(By.xpath("//button[@id=\"login-modal-btn\"]")).click();
    }

    @Then("user verify login")
    public void user_verify_status_login() {
        String loggedIn = driver.findElement(By.xpath("//span[contains(text(), 'Sheva')]")).getText();
        Assert.assertEquals(loggedIn, "Sheva");
//        WebElement loggedIn = driver.findElement(By.xpath("//span[@class=\"loggedin-username\"]"));
//        String Username = loggedIn.getAttribute("class");
//        Assert.assertTrue(Username.contains("loggedin-username"));

    }



}
