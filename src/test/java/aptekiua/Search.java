package aptekiua;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Main;
import util.Constants;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.samePropertyValuesAs;


public class Search {
    WebDriver driver;
    Main main;
    @BeforeMethod
    public void setUpDriver() {
        main = new Main();
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://apteki.ua/");
    }
    @AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void searchInputTwoSymbol (){
        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys("Ас");
        assertThat(true, equalTo(driver.findElement(main.getSearchModalWindow()).isDisplayed()));
        String titleModalWindowOrder = driver.findElement(main.getSearchMessagesHead()).getText();
        assertThat(titleModalWindowOrder,samePropertyValuesAs(Constants.MESSAGES_HEAD_SEARCH));
    }

    @Test
    public void searchInputOneSymbol (){
        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys("А");
        assertThat(true, equalTo(driver.findElement(main.getSearchModalWindow()).isDisplayed()));
        String titleModalWindowOrder = driver.findElement(main.getSearchMessagesHead()).getText();
        assertThat(titleModalWindowOrder,samePropertyValuesAs(Constants.MESSAGES_HEAD_SEARCH));
    }

    @Test
    public void searchInputEmpty (){
        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys("");
        assertThat(true, equalTo(driver.findElement(main.getSearchModalWindow()).isDisplayed()));
        assertThat(true, equalTo(driver.findElements(main.getSearchMessagesHead()).isEmpty()));
    }

    @Test(dataProvider = "nameDrug")
    public void searchListDrug (String nameDrug){
        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys(nameDrug);
        assertThat(true, equalTo(driver.findElement(main.getSearchModalWindow()).isDisplayed()));
        assertThat(true, equalTo(driver.findElements(main.getSearchMessagesHead()).isEmpty()));
    }

    @DataProvider( name = "nameDrug")
    public Object[][] credentials(){
        return new Object [][]  { {"Нурофен"},{"Гематоген"}};

    }

}
