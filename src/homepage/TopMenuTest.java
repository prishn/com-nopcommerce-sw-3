package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * 1.3. create the @Test method name verifyPageNavigation.Use selectMenu method to
 * select the Menu and click on it and verify the page navigation.
 */
public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        //click on menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space() = '" + menu + "']"));
        //verify navigation of page
        String expected = menu;
       // String actual = getTextFromElement(By.xpath("//h1[contains(text(),'" + menu + "')]"));
        assertEqualsMethod("Incorrect Top menu", menu, By.xpath("//h1[contains(text(),'" + menu + "')]"));
    }

    @Test
    public void verifyPageNavigation() throws InterruptedException {

        selectMenu("Computers");
        verifyText("Computers", getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]")));
        Thread.sleep(2000);
        selectMenu("Electronics");
        verifyText("Electronics", getTextFromElement(By.xpath("//h1[contains(text(),'Electronics')]")));
        selectMenu("Apparel");
        verifyText("Apparel", getTextFromElement(By.xpath("//h1[contains(text(),'Apparel')]")));
        selectMenu("Digital downloads");
        verifyText("Digital downloads", getTextFromElement(By.xpath("//h1[contains(text(),'Digital downloads')]")));
        Thread.sleep(2000);
        selectMenu("Books");
        verifyText("Books", getTextFromElement(By.xpath("//h1[contains(text(),'Books')]")));
        selectMenu("Jewelry");
        verifyText("Jewelry", getTextFromElement(By.xpath("//h1[contains(text(),'Jewelry')]")));
        selectMenu("Gift Cards");
        verifyText("Gift Cards", getTextFromElement(By.xpath("//h1[contains(text(),'Gift Cards')]")));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
