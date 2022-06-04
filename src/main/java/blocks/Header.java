package blocks;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class Header {

    private final SelenideElement logoApteki = $("#g_logo");
    private final SelenideElement basketIcon = $x("//*[@id=\"__layout\"]//nav/a/span[1]/span");

    public void verifyCountDragInBasket(String countDrag){
        basketIcon.shouldHave(text(countDrag));
    }
}
