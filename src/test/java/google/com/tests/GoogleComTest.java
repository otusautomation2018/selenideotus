package google.com.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import data.CommonSitesData;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;

public class GoogleComTest {

    private static final String BASE_URL = "http://google.com";
    private static final By INPUT = By.cssSelector("input[id='lst-ib']");
    private static final int RESULTS_NUMBERS = 10;
    private static final String QUERY = "selenide";

    @BeforeTest
    public void before(){
        Configuration.browser = "firefox";
    }

    @Test
    public void searchTest(){
        open(BASE_URL);
        /* SearchPage */
        $(INPUT).setValue(QUERY).pressEnter();
        /* ResultPage */
        $("div[id='res']").should(Condition.visible);
        $$x("//div[@class='g']").shouldHaveSize(RESULTS_NUMBERS);
        $$x("//div[@class='g']")
                .get(CommonSitesData.FIRST_ENTITY_IN_RESULT_LIST)
                .should(Condition.matchesText(QUERY));
    }
}
