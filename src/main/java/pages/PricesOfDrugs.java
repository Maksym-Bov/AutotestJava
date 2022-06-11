package pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class PricesOfDrugs {

    private final By plusDrags = By.cssSelector(".c-w-fraction-plus");
    private final By buttonAddDragsInBasket = By.cssSelector("button.added");


}
