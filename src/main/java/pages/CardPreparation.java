package pages;


import lombok.Getter;
import org.openqa.selenium.By;


@Getter
public class CardPreparation {

    private final By blockAboutPreparation = By.cssSelector(".border-green-dark");
    private final By buttonCountPharmacy = By.cssSelector(".whitespace-nowrap > .btn-primary");
    private final By buttonCountPharmacyMore = By.cssSelector(".border-green-dark");

}
