import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GoogleTest {
 // this is a comment
    /**
     * @ThisIsAnAnnotation
     *
     * @BeforeAll run this method before all our test cases
     * @BeforeEach run this method before every test case
     * @AfterEach @AfterAll after test case complete
     * @Test indicates that this method is a single test case
     */

    WebDriver driver;
    String baseUrl = "https://google.com";

    @BeforeAll
    static void setupdriverManager(){
        // enable selenium webdriver to use specially downloaded http client
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        // setup chrome friver so we can control the chrome browser
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBeforeEachTestCase(){
        this.driver = new ChromeDriver();
        // so there is a brand new session for each test case
    }

    @Test
    public void canOpenGooglePage(){
        this.driver.get(this.baseUrl);
        // will open up the baseurl, or you can write any website that will open
        assertEquals(this.driver.getTitle(), "Google");
        assertNotEquals(this.driver.getTitle(), "Amazon");
        assertEquals(this.driver.getCurrentUrl(), "https://www.google.com/");
    }

    @AfterEach
    public void closeBrowser(){
        this.driver.quit();
    }

}
