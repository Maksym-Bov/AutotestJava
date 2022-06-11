package pages;

import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class Main {

    private final By searchField = By.cssSelector("[name='search']");
    private final By searchModalWindow = By.cssSelector(".modal-overlay");
    private final By searchMessagesHead = By.cssSelector("span.text-secondary.text-sm");
    private final By searchSpin = By.cssSelector(".animate-spin");


    public By selectDrugsAtSearch(String drag){
        return By.cssSelector("[value=" + drag + "]");
    }

}
