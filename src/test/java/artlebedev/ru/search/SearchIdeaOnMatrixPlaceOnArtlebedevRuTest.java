package artlebedev.ru.search;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static artlebedev.ru.pages.MainPage.enterToMainPage;

public class SearchIdeaOnMatrixPlaceOnArtlebedevRuTest {

    @DataProvider
    public Object[][] keyWords(){
        int numberOfColumns = 2;
        return new Object[][]{
                {"привет", numberOfColumns},
                {"hi", numberOfColumns},
                {"hello", numberOfColumns}
        };
    }

    @Test(dataProvider = "keyWords")
    public void searchByKeyWordTest(String keyWord, int numberOfColumns){
        enterToMainPage()
                .goToToolPageThroughMenu()
                .toolPageHeaderIsCorrect()
                .goToMatrixPage()
                .ideaMatrixPageHeaderIsCorrect()
                .search(keyWord)
                .checkQueryResults(keyWord, numberOfColumns);
    }
}
