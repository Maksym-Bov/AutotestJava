package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import util.Constants;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class Main {



    private final SelenideElement searchField = $("[name=\"search\"]");
    private final SelenideElement searchModalWindow = $(".modal-overlay");

    public void selectDrugsAtSearch(String drag){
        $("[value=" + drag + "]").click();
    }
    public  void inputSearchDrags(String drag){
        searchField.click();
        searchField.setValue(drag);
    }

}
