package aptekiua;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Main;
import util.Constants;

@RunWith(DataProviderRunner.class)
public class Search {
    WebDriver driver;
    Main main;
    @Before
    public void setUpDriver() {
        main = new Main();
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://apteki.ua/");
    }
    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void searchInputTwoSymbol (){
        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys("Ас");
        Assert.assertTrue(driver.findElement(main.getSearchModalWindow()).isDisplayed());
        String titleModalWindowOrder = driver.findElement(main.getSearchMessagesHead()).getText();
        Assert.assertEquals(titleModalWindowOrder, Constants.MESSAGES_HEAD_SEARCH);
    }

    @Test
    public void searchInputOneSymbol (){
        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys("А");
        Assert.assertTrue(driver.findElement(main.getSearchModalWindow()).isDisplayed());
        String titleModalWindowOrder = driver.findElement(main.getSearchMessagesHead()).getText();
        Assert.assertEquals(titleModalWindowOrder, Constants.MESSAGES_HEAD_SEARCH);
    }

    @Test
    public void searchInputEmpty (){
        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys("");
        Assert.assertTrue(driver.findElement(main.getSearchModalWindow()).isDisplayed());
        Assert.assertTrue(driver.findElements(main.getSearchMessagesHead()).isEmpty());
    }

    @DataProvider
    public static Object[][] credentials(){
        return new Object [][]  { {"Нурофен"},{"Гематоген"}};

    }

    @Test
    @UseDataProvider("credentials")
    public void searchListDrug (String nameDrug){

        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys(nameDrug);
        Assert.assertTrue(driver.findElement(main.getSearchModalWindow()).isDisplayed());
        Assert.assertTrue(driver.findElements(main.getSearchMessagesHead()).isEmpty());
    }
}
