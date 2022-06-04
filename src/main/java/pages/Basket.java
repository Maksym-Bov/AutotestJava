package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class Basket {

    private final SelenideElement buttonOrderDrugsBasket = $("button.basket-button");
    private final SelenideElement makingOrderFieldNumber = $("#phone");
    private final SelenideElement buttonOrderAtMakingOrder = $("button.btn-md");
    private final SelenideElement titleModalWindowOrderConfirmation = $x("//*[@id=\"basket\"]//div[2]/div[1]/span");

    public void toOrderDrugsInBasket(){
        buttonOrderDrugsBasket.click();
    }
    public void toOrderAtMakingOrder(){
        buttonOrderAtMakingOrder.click();
    }
}
