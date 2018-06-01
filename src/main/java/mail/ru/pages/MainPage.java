package mail.ru.pages;

import com.codeborne.selenide.SelenidePageFactory;
import mail.ru.data.CommonSiteData;
import mail.ru.pages.components.MailBoxBlock;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage extends BasePage<MainPage>{

    public MailBoxBlock mailBoxBlock;

    public MainPage enterToMainPage(){
        return open(CommonSiteData.BASE_URL, MainPage.class);
    }

    public EmailMainPage loginToEmail(String login, String password, String domain){
        mailBoxBlock.login(login, password, domain);
        return new EmailMainPage();
    }

    public void clickToSubmit(){
        mailBoxBlock.clickToSubmit();
    }
}
