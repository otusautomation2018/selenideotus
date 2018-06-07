package mail.ru.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import data.CommonSitesData;
import mail.ru.data.CommonSiteData;
import mail.ru.data.UserData;
import mail.ru.enums.DomainOptions;
import mail.ru.pages.EmailMainPage;
import mail.ru.pages.MainPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Selenide.*;

public class MailRuTest {
    private static final int QTTY_LETTERS = 3;
    private static final String EXPECTED_TEXT = "15 мая\n" +
            "Mail.Ru – больше, чем почта. Познакомьтесь с проектами Mail.Ru GroupЗдравствуйте, " +
            "Test! Mail.Ru – ваш проводник в интернет. Узнайте больше о проектах Mail.Ru Group. Под\n" +
            "Команда Почты Mail.Ru";

    @BeforeTest
    public void before(){
        Configuration.browser = "chrome";
    }

    @Test
    public void mailRuLoginTest(){
        open(CommonSiteData.BASE_URL);
        $("#mailbox\\:login").setValue(UserData.email);
        $x("//*[@id='mailbox:password']").setValue(UserData.password);
        $("select.o-control").selectOptionContainingText(DomainOptions.BK_RU.toString());
        $(By.cssSelector("#mailbox\\:submit")).click();
        $(By.id("b-letters")).should(Condition.visible);

        $$(By.cssSelector("#b-letters .b-datalist__body > div")).shouldHaveSize(QTTY_LETTERS);
        $$(By.cssSelector("#b-letters .b-datalist__body > div"))
                .get(CommonSitesData.FIRST_ENTITY_IN_RESULT_LIST)
                .should(matchesText(EXPECTED_TEXT));
    }

    @Test
    public void pageObjectTest(){
        MainPage mainPage = new MainPage();
        mainPage.enterToMainPage();
        mainPage.clickToSubmit();
        /* ToDo See example https://github.com/otus-qa/selenide-mail */
    }
}
