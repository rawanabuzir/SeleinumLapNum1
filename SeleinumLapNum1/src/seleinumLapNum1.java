import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test1 {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
       
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

  
        driver = new ChromeDriver();

    
        driver.get("https://www.almosafer.com");
        driver.manage().window().maximize();

  
        List<WebElement> popups = driver.findElements(By.className("cta__continue"));
        if (!popups.isEmpty()) {
            popups.get(0).click();
        }
    }

    @Test
    public void testLanguage() {
        WebElement languageElement = driver.findElement(By.className("jJNggu"));
        String languageText = languageElement.getText();
        SoftAssert softAssert = new SoftAssert();
        String expectedValue = "العربية";
        softAssert.assertEquals(languageText, expectedValue, "Language is not in Arabic.");
        softAssert.assertAll();
    }

    @Test
    public void testCurrency() {
        WebElement currencyElement = driver.findElement(By.className("fPnvOO"));
        String currencyText = currencyElement.getText();
        SoftAssert softAssert = new SoftAssert();
        String expectedCurrency = "SAR";
        softAssert.assertEquals(currencyText, expectedCurrency, "Currency is not in SAR.");
        softAssert.assertAll();
    }

    @Test
    public void testHotelTab() {
        WebElement hotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
        String ariaSelectedValue = hotelTab.getAttribute("aria-selected");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(ariaSelectedValue, "false", "Hotel tab is selected.");
        softAssert.assertAll();
    }

    @AfterTest
    public void tearDown() {
 
        if (driver != null) {
            driver.quit();
        }
    }
}
