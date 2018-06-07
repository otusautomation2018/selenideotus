package artlebedev.ru.pages.sections;

import artlebedev.ru.pages.ToolPage;
import com.codeborne.selenide.ElementsContainer;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MenuBlock extends ElementsContainer {

    private static final By TOOLS_BUTTON = By.xpath("//a[@href='/tools/']");

    public ToolPage clickOnToolsBtn(){
        $(TOOLS_BUTTON).click();
        return page(ToolPage.class);
    }
}
