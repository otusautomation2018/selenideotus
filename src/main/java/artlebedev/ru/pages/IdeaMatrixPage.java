package artlebedev.ru.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;

public class IdeaMatrixPage {
    public static final String HEADER = "Матрица идей";

    @FindBy(how = How.CSS, using = "[class='input']")
    public SelenideElement searchField;

    public IdeaMatrixPage ideaMatrixPageHeaderIsCorrect(){
        $x("//div[contains(@class, 'title')]/h1")
                .shouldHave(Condition.text(HEADER));
        return this;
    }

    public IdeaMatrixPage search(String query){
        searchField.clear();
        searchField.setValue(query).pressEnter();
        return page(IdeaMatrixPage.class);
    }

    public boolean checkQueryResults(String query, int numberOfColumns){

        $$("div[class='als-columns text-double-margin']>div").shouldHave(size(numberOfColumns));
        $("input[value='"+query+"']").should(Condition.visible);

        return true;
    }
}
