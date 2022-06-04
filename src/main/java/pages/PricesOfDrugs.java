package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class PricesOfDrugs {

    private final SelenideElement plusDrags = $(".c-w-fraction-plus");
    private final SelenideElement buttonAddDragsInBasket = $("button.added");

    public void addCountDrags(int count){
        for(int i = 0; i < count; i++){
            plusDrags.click();
        }
    }
    public void addDragsInBasket(){
        buttonAddDragsInBasket.click();
    }
}
