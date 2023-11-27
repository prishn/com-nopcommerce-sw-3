package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.UUID;

/**
 * Create the class ElectronicsTest
 * Write the following test
 * 1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully()
 * 1.1 Mouse Hover on “Electronics” Tab
 * 1.2 Mouse Hover on “Cell phones” and click
 * 1.3 Verify the text “Cell phones”
 * 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()
 * 2.1 Mouse Hover on “Electronics” Tab
 * 2.2 Mouse Hover on “Cell phones” and click
 * 2.3 Verify the text “Cell phones”
 * 2.4 Click on List View Tab
 * 2.5 Click on product name “Nokia Lumia 1020” link
 * <p>
 * 2.6 Verify the text “Nokia Lumia 1020”
 * 2.7 Verify the price “$349.00”
 * 2.8 Change quantity to 2
 * 2.9 Click on “ADD TO CART” tab
 * 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar"
 * After that close the bar clicking on the cross button.
 * 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.12 Verify the message "Shopping cart"
 * 2.13 Verify the quantity is 2
 * 2.14 Verify the Total $698.00
 * 2.15 click on checkbox “I agree with the terms of service”
 * 2.16 Click on “CHECKOUT”
 * 2.17 Verify the Text “Welcome, Please Sign In!”
 * 2.18 Click on “REGISTER” tab
 * 2.19 Verify the text “Register”
 * 2.20 Fill the mandatory fields
 * 2.21 Click on “REGISTER” Button
 * 2.22 Verify the message “Your registration completed”
 * 2.23 Click on “CONTINUE” tab
 * 2.24 Verify the text “Shopping card”
 * 2.25 click on checkbox “I agree with the terms of service”
 * 2.26 Click on “CHECKOUT”
 * 2.27 Fill the Mandatory fields
 * 2.28 Click on “CONTINUE”
 * 2.29 Click on Radio Button “2nd Day Air ($0.00)”
 * 2.30 Click on “CONTINUE”
 * 2.31 Select Radio Button “Credit Card”
 * 2.32 Select “Visa” From Select credit card dropdown
 * 2.33 Fill all the details
 * 2.34 Click on “CONTINUE”
 * 2.35 Verify “Payment Method” is “Credit Card”
 * 2.36 Verify “Shipping Method” is “2nd Day Air”
 * 2.37 Verify Total is “$698.00”
 * 2.38 Click on “CONFIRM”
 * 2.39 Verify the Text “Thank You”
 * 2.40 Verify the message “Your order has been successfully processed!”
 * 2.41 Click on “CONTINUE”
 * 2.42 Verify the text “Welcome to our store”
 * 2.43 Click on “Logout” link
 * 2.44 Verify the URL is “https://demo.nopcommerce.com/”
 */
public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {

        // * 1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));

        // * 1.2 Mouse Hover on “Cell phones” and "Click"
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        // * 1.3 Verify the text “Cell phones”
        assertEqualsMethod("Incorrect Top Menu", "Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // * 2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
        Thread.sleep(2000);

        // * 2.2 Mouse Hover on “Cell phones” and "Click"
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));

        // * 2.3 Verify the text “Cell phones”
        assertEqualsMethod("Incorrect Top Menu", "Cell phones", By.xpath("//h1[normalize-space()='Cell phones']"));

        // * 2.4 Click on List View Tab
        clickOnElement(By.linkText("List"));
        Thread.sleep(2000);

        // * 2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.linkText("Nokia Lumia 1020"));

        // * 2.6 Verify the text “Nokia Lumia 1020”
        assertEqualsMethod("Incorrect message displayed!", "Nokia Lumia 1020",
                By.xpath("//h1[text() = 'Nokia Lumia 1020']"));

        // * 2.7 Verify the price “$349.00”
        Thread.sleep(2000);
        assertEqualsMethod("Incorrect Price", "$349.00", By.id("price-value-20"));

        // * 2.8 Change quantity to 2
        Thread.sleep(2000);
        clearTextField(By.id("product_enteredQuantity_20"));
        Thread.sleep(2000);
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");

        // * 2.9 Click on “ADD TO CART” tab
        Thread.sleep(2000);
        clickOnElement(By.id("add-to-cart-button-20"));

        // * 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(2000);
        assertEqualsMethod("", "The product has been added to your shopping cart",
                By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Thread.sleep(2000);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class = 'close']"));
        Thread.sleep(2000);

        // * 2.11 Then MouseHover on "Shopping cart"
        mouseHoverToElement(By.xpath("//a[@class='ico-cart']"));

        //Click on "GO TO CART" button.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[@class='cart-label']"));

        // * 2.12 Verify the message "Shopping cart"
        assertEqualsMethod("Incorrect message displayed!", "Shopping cart",
                By.xpath("//h1[normalize-space()='Shopping cart']"));
        Thread.sleep(2000);

        // * 2.13 Verify the quantity is 2
//        String expectedQuantity = "(2)";
//        String actualQuantity = driver.findElement(By.xpath("//input[@class = 'qty-input']")).getAttribute("value");
        assertEqualsMethod("Incorrect quantity", "(2)", By.xpath("//span[contains(text(),'(2)')]"));

        // * 2.14 Verify the Total $698.00
        assertEqualsMethod("Incorrect Total price", "$698.00", By.xpath("//span[text() = '$698.00']"));
        Thread.sleep(2000);

        // * 2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        Thread.sleep(2000);

        // * 2.16 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);

        // * 2.17 Verify the Text “Welcome, Please Sign In!”
        assertEqualsMethod("Incorrect message displayed!", "Welcome, Please Sign In!",
                By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Thread.sleep(2000);

        // * 2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[@class = 'button-1 register-button']"));
        Thread.sleep(2000);

        // * 2.19 Verify the text “Register”
        assertEqualsMethod("", "Register", By.xpath("//h1[normalize-space()='Register']"));

        // * 2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "Robert");
        sendTextToElement(By.id("LastName"), "Jackson");
        sendTextToElement(By.name("DateOfBirthDay"), "18");
        sendTextToElement(By.name("DateOfBirthMonth"), "December");
        sendTextToElement(By.name("DateOfBirthYear"), "1990");
        final String randomEmail = randomEmail();
        sendTextToElement(By.id("Email"), randomEmail);
        sendTextToElement(By.name("Password"), "12345678");
        sendTextToElement(By.name("ConfirmPassword"), "12345678");

        // * 2.21 Click on “REGISTER” Button
        clickOnElement(By.name("register-button"));
        Thread.sleep(2000);

        // * 2.22 Verify the message “Your registration completed”
        assertEqualsMethod("Incorrect message displayed", "Your registration completed",
                By.className("result"));
        Thread.sleep(2000);

        // * 2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(2000);

        // * 2.24 Verify the text “Shopping cart”
        assertEqualsMethod("Incorrect Shopping Cart Text!", "Shopping cart", By.linkText("Shopping cart"));
        Thread.sleep(2000);

        //Click on login button
        clickOnElement(By.linkText("Log in"));

        //Verify the Text "Welcome, Please Sign In!"
        Thread.sleep(2000);
        assertEqualsMethod("Incorrect Welcome Text!", "Welcome, Please Sign In!",
                By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Thread.sleep(2000);

        //Enter Email into the email field
        sendTextToElement(By.id("Email"), randomEmail);

        //Enter Password into the password field
        sendTextToElement(By.name("Password"), "12345678");
        Thread.sleep(2000);

        //Click on Login button
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        Thread.sleep(2000);

        // * 2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(2000);

        // * 2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);

        // * 2.27 Fill the Mandatory fields
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "233");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.name("BillingNewAddress.Address1"), "Harry Porter Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "HP4 2PH");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07643667894");
        Thread.sleep(2000);

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class = 'button-1 new-address-next-step-button']"));
        Thread.sleep(2000);

        //* 2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //Select Radio Button “Credit Card
        clickOnElement(By.id("paymentmethod_1"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        // * 2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleFromDropDown(By.id("CreditCardType"), "Visa");

        // * 2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Robert Jackson");
        Thread.sleep(2000);
        sendTextToElement(By.id("CardNumber"), "0000 0000 0000 0000");
        clickOnElement(By.id("ExpireMonth"));
        selectByValueFromDropDown(By.id("ExpireMonth"), "10");
        selectByValueFromDropDown(By.id("ExpireYear"), "2026");
        Thread.sleep(2000);
        sendTextToElement(By.id("CardCode"), "526");

        // * 2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(2000);

        // * 2.35 Verify “Payment Method” is “Credit Card”
        assertEqualsMethod("Incorrect Card detail displayed.", "Payment Method: Credit Card",
                By.xpath("//li[@class='payment-method']"));
        Thread.sleep(2000);

        // * 2.36 Verify “Shipping Method” is “2nd Day Air”
        assertEqualsMethod("Incorrect message", "Shipping Method: 2nd Day Air",
                By.xpath("//li[@class='shipping-method']"));
        Thread.sleep(2000);

        // * 2.37 Verify Total is “$698.00”
        assertEqualsMethod("Incorrect total", "$698.00", By.xpath("//span[text() ='$698.00']"));
        Thread.sleep(2000);

        // * 2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        // * 2.39 Verify the Text “Thank You”
        assertEqualsMethod("Incorrect Message displayed", "Thank you", By.xpath("//h1[text() = 'Thank you']"));

        // * 2.40 Verify the message “Your order has been successfully processed!”
        assertEqualsMethod("Incorrect Message", "Your order has been successfully processed!",
                By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));

        // * 2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class = 'button-1 order-completed-continue-button']"));

        // * 2.42 Verify the text “Welcome to our store”
        assertEqualsMethod("Incorrect Welcome Text", "Welcome to our store",
                By.xpath("//h2[text() = 'Welcome to our store']"));

        // * 2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        // * 2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        System.out.println("Current Url: " + baseUrl);
    }

    private static String randomEmail() {

        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }

    public void tearDown() {
        closeBrowser();
    }
}
