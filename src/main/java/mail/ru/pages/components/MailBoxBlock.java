package mail.ru.pages.components;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import mail.ru.pages.EmailMainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MailBoxBlock extends ElementsContainer {
    private static final By LOGIN_CSS = By.cssSelector("#mailbox\\:login");
    private static final By PASSWORD_XPATH = By.xpath("//*[@id='mailbox:password']");
    private static final By SELECT_DOMAIN_CSS = By.cssSelector("select.o-control");
    private static final By SUBMIT_BTN_CSS = By.cssSelector("#mailbox\\:submit");


//    @FindBy(how = How.CSS, using = "#mailbox\\:login")
//    public SelenideElement login = $(LOGIN_CSS);
//
//    @FindBy(how = How.XPATH, using = "//*[@id='mailbox:password']")
//    public SelenideElement password = $x(PASSWORD_XPATH);
//
//    @FindBy(how = How.CSS, using = "select.o-control")
//    public SelenideElement selectDomain = $(SELECT_DOMAIN_CSS);
//
//    @FindBy(how = How.CSS, using = "#mailbox\\:submit")
//    public SelenideElement submitBrn = $(SUBMIT_BTN_CSS);

    public void inputToLogin(String login){
        $(LOGIN_CSS).setValue(login);
    }

    public void inputToPassword(String password){
        $(PASSWORD_XPATH).setValue(password);
    }

    public void chooseDomain(String domain){
        $(SELECT_DOMAIN_CSS).selectOptionContainingText(domain);
    }

    public void clickToSubmit(){
        $("#mailbox\\:submit").click();
    }

    public EmailMainPage login(String login, String password, String domain){
        inputToLogin(login);
        inputToPassword(password);
        chooseDomain(domain);
        clickToSubmit();
        return page(EmailMainPage.class);
    }
}
