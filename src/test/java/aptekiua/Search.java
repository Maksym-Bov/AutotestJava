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

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(driver.findElement(main.getSearchModalWindow()).isDisplayed()).isTrue();
        String titleModalWindowOrder = driver.findElement(main.getSearchMessagesHead()).getText();
        assertThat(titleModalWindowOrder).contains(Constants.MESSAGES_HEAD_SEARCH);
    }

    @Test
    public void searchInputOneSymbol (){
        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys("А");
        assertThat(driver.findElement(main.getSearchModalWindow()).isDisplayed()).isTrue();
        String titleModalWindowOrder = driver.findElement(main.getSearchMessagesHead()).getText();
        assertThat(titleModalWindowOrder).contains(Constants.MESSAGES_HEAD_SEARCH);
    }

    @Test
    public void searchInputEmpty (){
        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys("");
        assertThat(driver.findElement(main.getSearchModalWindow()).isDisplayed()).isTrue();
        assertThat(driver.findElements(main.getSearchMessagesHead()).isEmpty()).isTrue();
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
        assertThat(driver.findElement(main.getSearchModalWindow()).isDisplayed()).isTrue();
        assertThat(driver.findElements(main.getSearchMessagesHead()).isEmpty()).isTrue();
    }
}
