package artlebedev.ru.pages;

import artlebedev.ru.data.CommonSiteData;
import artlebedev.ru.pages.sections.MenuBlock;

import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BasePage<MainPage> {

    MenuBlock menuBlock;

    public static MainPage enterToMainPage(){
        return open(CommonSiteData.BASE_URL, MainPage.class);
    }

    public ToolPage goToToolPageThroughMenu(){
       return menuBlock.clickOnToolsBtn();
    }
}
