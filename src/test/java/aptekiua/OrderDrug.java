package aptekiua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Basket;
import pages.CardPreparation;
import pages.Main;
import pages.PricesOfDrugs;
import util.Constants;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.samePropertyValuesAs;


public class OrderDrug {



    WebDriver driver;
    Main main;
    PricesOfDrugs pricesOfDrugs;
    CardPreparation cardPreparation;
    Basket basket;

    @BeforeMethod
    public void setUpDriver(){
        main = new Main();
        cardPreparation = new CardPreparation();
        pricesOfDrugs = new PricesOfDrugs();
        basket = new Basket();
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://apteki.ua/");
    }

    @AfterMethod
    public void setDownDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void ordersToDoseDragsPharmacy(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys(Constants.DRAGS_NAME_NEMISIL);
        assertThat(true, equalTo(driver.findElement(main.getSearchModalWindow()).isDisplayed()));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value=" + Constants.DRAGS_NAME_NEMISIL + "]")));
        driver.findElement(main.selectDrugsAtSearch(Constants.DRAGS_NAME_NEMISIL)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cardPreparation.getButtonCountPharmacy()));
        driver.findElement(cardPreparation.getButtonCountPharmacy()).click();
        wait.until(ExpectedConditions.elementToBeClickable(pricesOfDrugs.getPlusDrags()));
        driver.findElement(pricesOfDrugs.getPlusDrags()).click();
        driver.findElement(pricesOfDrugs.getPlusDrags()).click();
        wait.until(ExpectedConditions.elementToBeClickable(pricesOfDrugs.getButtonAddDragsInBasket()));
        driver.findElement(pricesOfDrugs.getButtonAddDragsInBasket()).click();
        assertThat(true, equalTo(driver.findElement(basket.getButtonOrderDrugsBasket()).isDisplayed()));
        driver.findElement(basket.getButtonOrderDrugsBasket()).click();
        assertThat(true, equalTo(driver.findElement(basket.getMakingOrderFieldNumber()).isDisplayed()));
        driver.findElement(basket.getMakingOrderFieldNumber()).sendKeys(Constants.NUMBER_PHONE_KYIVSTAR_NOMASK_CONTRY);
        driver.findElement(basket.getButtonOrderAtMakingOrder()).click();
        assertThat(true, equalTo(driver.findElement(basket.getTitleModalWindowOrderConfirmation()).isDisplayed()));
        String titleModalWindowOrder = driver.findElement(basket.getTitleModalWindowOrderConfirmation()).getText();
        assertThat(titleModalWindowOrder,samePropertyValuesAs(Constants.TITLE_CONFIRMATION_UKRAINE));
    }

    @Test
    public void orderPharmacy(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys(Constants.DRAGS_NAME_NEMISIL);
        assertThat(true, equalTo(driver.findElement(main.getSearchModalWindow()).isDisplayed()));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value=" + Constants.DRAGS_NAME_NEMISIL + "]")));
        driver.findElement(main.selectDrugsAtSearch(Constants.DRAGS_NAME_NEMISIL)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cardPreparation.getButtonCountPharmacy()));
        driver.findElement(cardPreparation.getButtonCountPharmacy()).click();
        wait.until(ExpectedConditions.elementToBeClickable(pricesOfDrugs.getPlusDrags()));
        driver.findElement(pricesOfDrugs.getPlusDrags()).click();
        driver.findElement(pricesOfDrugs.getPlusDrags()).click();
        wait.until(ExpectedConditions.elementToBeClickable(pricesOfDrugs.getButtonAddDragsInBasket()));
        driver.findElement(pricesOfDrugs.getButtonAddDragsInBasket()).click();
        assertThat(true, equalTo(driver.findElement(basket.getButtonOrderDrugsBasket()).isDisplayed()));
        driver.findElement(basket.getButtonOrderDrugsBasket()).click();
        assertThat(true, equalTo(driver.findElement(basket.getMakingOrderFieldNumber()).isDisplayed()));
        driver.findElement(basket.getMakingOrderFieldNumber()).sendKeys(Constants.NUMBER_PHONE_KYIVSTAR_NOMASK_CONTRY);
        driver.findElement(basket.getButtonOrderAtMakingOrder()).click();
        assertThat(true, equalTo(driver.findElement(basket.getTitleModalWindowOrderConfirmation()).isDisplayed()));
        String titleModalWindowOrder = driver.findElement(basket.getTitleModalWindowOrderConfirmation()).getText();
        assertThat(titleModalWindowOrder,samePropertyValuesAs(Constants.TITLE_CONFIRMATION_UKRAINE));
    }
}
