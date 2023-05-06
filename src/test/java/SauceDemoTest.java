import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SauceDemoTest {

    WebDriver driver;

    String baseUrl = "https://www.saucedemo.com";

    @BeforeAll
    static void setupDriverManager(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp(){
        this.driver = new ChromeDriver();
    }

    @Test
    public void canOpenWebpage(){
        this.driver.get(this.baseUrl);
        assertEquals(this.driver.getTitle(), "Swag Labs");
    }

    @Test
    @DisplayName("User with correct username and password can log in")
    public void userCanLoginWithCorrectUserAndPass(){
        this.driver.get(this.baseUrl);
        this.driver.findElement(By.id("user-name")).sendKeys("standard_user");
        this.driver.findElement(By.id("password")).sendKeys("secret_sauce");

        this.driver.findElement(By.id("login-button")).click();

        assertEquals(this.driver.findElement(By.className("app_logo")).getText(), "Swag Labs");
        assertEquals(this.driver.findElement(By.className("title")).getText(), "Products");


    }

    @AfterEach
    void tearDown(){
        this.driver.quit();
    }
}
