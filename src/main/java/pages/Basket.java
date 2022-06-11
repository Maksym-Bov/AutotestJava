package pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class Basket {

    private final By buttonOrderDrugsBasket = By.cssSelector("button.basket-button");
    private final By makingOrderFieldNumber = By.cssSelector("#phone");
    private final By buttonOrderAtMakingOrder = By.cssSelector("button.btn-md");
    private final By titleModalWindowOrderConfirmation = By.xpath("//*[@id=\"basket\"]//div[2]/div[1]/span");


}
