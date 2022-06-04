package aptekiua;

import com.codeborne.selenide.Selenide;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.Main;
import util.Constants;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;

@RunWith(DataProviderRunner.class)
public class Search {
    Main main  = new Main();
    @Before
    public void mainPages() {
        open("https://apteki.ua/");
    }
    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    public void searchInputTwoSymbol (){
        main.inputSearchDrags("Ас");
        main.checkMessagesHeadSearch(Constants.MESSAGES_HEAD_SEARCH);
    }

    @Ignore
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

    @DataProvider
    public static Object[][] credentials(){
        return new Object [][]  { {"Нурофен"},{"Гематоген"}};

    }

    @Test
    @UseDataProvider("credentials")
    public void searchListDrug (String nameDrug){
        main.inputSearchDrags(nameDrug);
        main.getSearchMessagesHead().should(exist);;
    }


}
