import blocks.Header;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.Basket;
import pages.CardPreparation;
import pages.Main;
import pages.PricesOfDrugs;
import util.Constants;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest {
    Main main  = new Main();
    CardPreparation cardPreparation = new CardPreparation();
    Header header = new Header();
    PricesOfDrugs pricesOfDrugs = new PricesOfDrugs();
    Basket basket = new Basket();

    String countDragBasket = "1";

    @Test
    public void orderPharmacy(){
        open("https://apteki.ua/");
        main.inputSearchDrags(Constants.DRAGS_NAME_NEMISIL);
        main.getSearchModalWindow().shouldBe(enabled);
        main.selectDrugsAtSearch(Constants.DRAGS_NAME_NEMISIL);
        cardPreparation.getBlockAboutPreparation().shouldBe(enabled);
        cardPreparation.clickButtonCountPharmacy();
        header.getLogoApteki().shouldBe(enabled);
        pricesOfDrugs.addCountDrags(1);
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
