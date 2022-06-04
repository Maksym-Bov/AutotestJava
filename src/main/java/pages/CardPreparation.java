package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class CardPreparation {


    private final SelenideElement blockAboutPreparation = $(".border-green-dark");
    private final SelenideElement buttonCountPharmacy = $(".whitespace-nowrap > .btn-primary");
    private final SelenideElement buttonCountPharmacyMore = $(".border-green-dark");


    public void clickButtonCountPharmacy(){
        buttonCountPharmacy.click();
    }

}
