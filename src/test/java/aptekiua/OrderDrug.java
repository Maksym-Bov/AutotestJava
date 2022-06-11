package aptekiua;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Basket;
import pages.CardPreparation;
import pages.Main;
import pages.PricesOfDrugs;
import util.Constants;

import java.time.Duration;


public class OrderDrug {



    WebDriver driver;
    Main main;
    PricesOfDrugs pricesOfDrugs;
    CardPreparation cardPreparation;
    Basket basket;

    @Before
    public void setUpDriver(){
        main = new Main();
        cardPreparation = new CardPreparation();
        pricesOfDrugs = new PricesOfDrugs();
        basket = new Basket();
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://apteki.ua/");
    }

    @After
    public void setDownDriver() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void ordersToDoseDragsPharmacy(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys(Constants.DRAGS_NAME_NEMISIL);
        Assert.assertTrue(driver.findElement(main.getSearchModalWindow()).isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value=" + Constants.DRAGS_NAME_NEMISIL + "]")));
        driver.findElement(main.selectDrugsAtSearch(Constants.DRAGS_NAME_NEMISIL)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cardPreparation.getButtonCountPharmacy()));
        driver.findElement(cardPreparation.getButtonCountPharmacy()).click();
        wait.until(ExpectedConditions.elementToBeClickable(pricesOfDrugs.getPlusDrags()));
        driver.findElement(pricesOfDrugs.getPlusDrags()).click();
        driver.findElement(pricesOfDrugs.getPlusDrags()).click();
        wait.until(ExpectedConditions.elementToBeClickable(pricesOfDrugs.getButtonAddDragsInBasket()));
        driver.findElement(pricesOfDrugs.getButtonAddDragsInBasket()).click();
        Assert.assertTrue(driver.findElement(basket.getButtonOrderDrugsBasket()).isDisplayed());
        driver.findElement(basket.getButtonOrderDrugsBasket()).click();
        Assert.assertTrue(driver.findElement(basket.getMakingOrderFieldNumber()).isDisplayed());
        driver.findElement(basket.getMakingOrderFieldNumber()).sendKeys(Constants.NUMBER_PHONE_KYIVSTAR_NOMASK_CONTRY);
        driver.findElement(basket.getButtonOrderAtMakingOrder()).click();
        Assert.assertTrue(driver.findElement(basket.getTitleModalWindowOrderConfirmation()).isDisplayed());
        String titleModalWindowOrder = driver.findElement(basket.getTitleModalWindowOrderConfirmation()).getText();
        Assert.assertEquals(titleModalWindowOrder, Constants.TITLE_CONFIRMATION_UKRAINE);
    }

    @Test
    public void orderPharmacy(){

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(main.getSearchField()).click();
        driver.findElement(main.getSearchField()).sendKeys(Constants.DRAGS_NAME_NEMISIL);
        Assert.assertTrue(driver.findElement(main.getSearchModalWindow()).isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[value=" + Constants.DRAGS_NAME_NEMISIL + "]")));
        driver.findElement(main.selectDrugsAtSearch(Constants.DRAGS_NAME_NEMISIL)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cardPreparation.getButtonCountPharmacy()));
        driver.findElement(cardPreparation.getButtonCountPharmacy()).click();
        wait.until(ExpectedConditions.elementToBeClickable(pricesOfDrugs.getPlusDrags()));
        driver.findElement(pricesOfDrugs.getPlusDrags()).click();
        wait.until(ExpectedConditions.elementToBeClickable(pricesOfDrugs.getButtonAddDragsInBasket()));
        driver.findElement(pricesOfDrugs.getButtonAddDragsInBasket()).click();
        Assert.assertTrue(driver.findElement(basket.getButtonOrderDrugsBasket()).isDisplayed());
        driver.findElement(basket.getButtonOrderDrugsBasket()).click();
        Assert.assertTrue(driver.findElement(basket.getMakingOrderFieldNumber()).isDisplayed());
        driver.findElement(basket.getMakingOrderFieldNumber()).sendKeys(Constants.NUMBER_PHONE_KYIVSTAR_NOMASK_CONTRY);
        driver.findElement(basket.getButtonOrderAtMakingOrder()).click();
        Assert.assertTrue(driver.findElement(basket.getTitleModalWindowOrderConfirmation()).isDisplayed());
        String titleModalWindowOrder = driver.findElement(basket.getTitleModalWindowOrderConfirmation()).getText();
        Assert.assertEquals(titleModalWindowOrder, Constants.TITLE_CONFIRMATION_UKRAINE);
    }
}
