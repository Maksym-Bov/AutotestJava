package aptekiua;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;
import util.Constants;
import pages.Main;
import util.ListenersTestNG;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;

@Listeners(ListenersTestNG.class)
public class Search {
    Main main  = new Main();
    @BeforeMethod
    public void mainPages() {
        open("https://apteki.ua/");
    }
    @AfterMethod
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void searchInputTwoSymbol (){
        main.inputSearchDrags("Ас");
        main.checkMessagesHeadSearch(Constants.MESSAGES_HEAD_SEARCH);
    }

    @Test
    public void searchInputOneSymbol (){
        main.inputSearchDrags("А");
        main.checkMessagesHeadSearch(Constants.MESSAGES_HEAD_SEARCH);
    }

    @Test
    public void searchInputEmpty (){
        main.inputSearchDrags("");
        main.getSearchMessagesHead().shouldNot(exist);
    }

    @Test
    public void searchInputNotExitDrug (){
        main.inputSearchDrags("Операновпи");
        main.checkMessagesHeadSearch(Constants.NOT_EXIST_MESSAGES_HEAD_SEARCH);
    }


    @Test
    public void searchInputSpecialSymbols (){
        main.inputSearchDrags("~~``!@#$%^&*()");
        main.checkMessagesHeadSearch(Constants.NOT_EXIST_MESSAGES_HEAD_SEARCH);
    }

    @Test(dataProvider = "nameDrug")
    public void searchListDrug (String nameDrug){
        main.inputSearchDrags(nameDrug);
        main.getSearchMessagesHead().should(exist);;
    }

    @DataProvider( name = "nameDrug")
    public Object[][] credentials(){
        return new Object [][]  { {"Нурофен"},{"Гематоген"}};

    }
}
