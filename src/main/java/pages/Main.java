package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class Main {



    private final SelenideElement searchField = $("[name=\"search\"]");
    private final SelenideElement searchModalWindow = $(".modal-overlay");
    private final SelenideElement searchMessagesHead = $("span.text-secondary");

    public void selectDrugsAtSearch(String drag){
        $("[value=" + drag + "]").click();
    }

    public  void inputSearchDrags(String drag){
        searchField.click();
        searchField.setValue(drag);
    }
    public void checkMessagesHeadSearch(String message){
        searchMessagesHead.shouldHave(text(message));

    }
}
