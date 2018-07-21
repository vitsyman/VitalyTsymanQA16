import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogleTest {
WebDriver driver;
@BeforeMethod
public void setUp() {
    driver = new ChromeDriver();


}
@Test
public void siteOpeningTest(){
    driver.get("https://www.google.com/");
    }
    @AfterMethod
public void tearDown(){
    driver.quit();
}

}
