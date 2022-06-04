package aptekiua;

import blocks.Header;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;
import pages.Basket;
import pages.CardPreparation;
import pages.Main;
import pages.PricesOfDrugs;
import util.Constants;
import util.ListenersTestNG;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

@Listeners(ListenersTestNG.class)

public class OrderDrug {
    Main main  = new Main();
    CardPreparation cardPreparation = new CardPreparation();
    Header header = new Header();
    PricesOfDrugs pricesOfDrugs = new PricesOfDrugs();
    Basket basket = new Basket();

    String countDragBasket = "1";

    @BeforeMethod
    public void mainPages() {
        open("https://apteki.ua/");
    }
    @AfterMethod
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }



    @Test
    public void ordersToDoseDragsPharmacy(){

        main.inputSearchDrags(Constants.DRAGS_NAME_NEMISIL);
        main.getSearchModalWindow().shouldBe(enabled);
        main.selectDrugsAtSearch(Constants.DRAGS_NAME_NEMISIL);
        cardPreparation.getBlockAboutPreparation().shouldBe(enabled);
        cardPreparation.clickButtonCountPharmacy();
        header.getLogoApteki().shouldBe(enabled);
        pricesOfDrugs.addCountDrags(2);
        header.verifyCountDragInBasket(countDragBasket);
        pricesOfDrugs.addDragsInBasket();
        basket.getButtonOrderDrugsBasket().shouldBe(enabled);
        basket.toOrderDrugsInBasket();
        basket.getMakingOrderFieldNumber().setValue(Constants.NUMBER_PHONE_KYIVSTAR_NOMASK_CONTRY);
        basket.toOrderAtMakingOrder();
        basket.getTitleModalWindowOrderConfirmation().shouldBe(enabled);
        basket.getTitleModalWindowOrderConfirmation().shouldHave(text(Constants.TITLE_CONFIRMATION_UKRAINE));
    }

    @Test
    public void orderPharmacy(){

        main.inputSearchDrags(Constants.DRAGS_NAME_NEMISIL);
        main.getSearchModalWindow().shouldBe(enabled);
        main.selectDrugsAtSearch(Constants.DRAGS_NAME_NEMISIL);
        cardPreparation.getBlockAboutPreparation().shouldBe(enabled);
        cardPreparation.clickButtonCountPharmacy();
        header.getLogoApteki().shouldBe(enabled);
        pricesOfDrugs.addCountDrags(2);
        header.verifyCountDragInBasket(countDragBasket);
        pricesOfDrugs.addDragsInBasket();
        basket.getButtonOrderDrugsBasket().shouldBe(enabled);
        basket.toOrderDrugsInBasket();
        basket.getMakingOrderFieldNumber().setValue(Constants.NUMBER_PHONE_KYIVSTAR_NOMASK_CONTRY);
        basket.toOrderAtMakingOrder();
        basket.getTitleModalWindowOrderConfirmation().shouldBe(enabled);
        basket.getTitleModalWindowOrderConfirmation().shouldHave(text(Constants.TITLE_CONFIRMATION_UKRAINE));
    }
}
