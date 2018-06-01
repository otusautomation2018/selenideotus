package mail.ru.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmailMainPage {

    @FindBy(how = How.CSS, using = "b-letters")
    SelenideElement letters;

    public EmailMainPage checkVisible(){
        letters.should(Condition.visible);
        return this;
    }
}
