package artlebedev.ru.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ToolPage {

    @FindBy(how = How.CSS, using = "#item-matrix")
    public SelenideElement MatrixButton;


    public ToolPage toolPageHeaderIsCorrect(){
        $x("//div[contains(@class, 'title')]/h1")
                .shouldHave(Condition.text("Полезные всякие штуки"));
        return this;
    }

    public IdeaMatrixPage goToMatrixPage(){
        MatrixButton.click();
        return page(IdeaMatrixPage.class);
    }
}
