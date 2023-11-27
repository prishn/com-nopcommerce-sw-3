package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Create class “TestSuite”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Click on Computer Menu.
 * 1.2 Click on Desktop
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Click on Computer Menu.
 * 2.2 Click on Desktop
 * 2.3 Select Sort By position "Name: A to Z"
 * 2.4 Click on "Add To Cart"
 * 2.5 Verify the Text "Build your own computer"
 * 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
 * 2.7.Select "8GB [+$60.00]" using Select class.
 * 2.8 Select HDD radio "400 GB [+$100.00]"
 * 2.9 Select OS radio "Vista Premium [+$60.00]"
 * 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
 * 2.11 Verify the price "$1,475.00"
 * 2.12 Click on "ADD TO CARD" Button.
 * 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
 * After that close the bar clicking on the cross button.
 * 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
 * 2.15 Verify the message "Shopping cart"
 * 2.16 Change the Qty to "2" and Click on "Update shopping cart"
 * 2.17 Verify the Total"$2,950.00"
 * 2.18 click on checkbox “I agree with the terms of service”
 * 2.19 Click on “CHECKOUT”
 * 2.20 Verify the Text “Welcome, Please Sign In!”
 * 2.21Click on “CHECKOUT AS GUEST” Tab
 * 2.22 Fill the all mandatory field
 * 2.23 Click on “CONTINUE”
 * 2.24 Click on Radio Button “Next Day Air($0.00)”
 * 2.25 Click on “CONTINUE”
 * 2.26 Select Radio Button “Credit Card”
 * 2.27 Select “Master card” From Select credit card dropdown
 * 2.28 Fill all the details
 * 2.29 Click on “CONTINUE”
 * 2.30 Verify “Payment Method” is “Credit Card”
 * 2.32 Verify “Shipping Method” is “Next Day Air”
 * 2.33 Verify Total is “$2,950.00”
 * 2.34 Click on “CONFIRM”
 * 2.35 Verify the Text “Thank You”
 * 2.36 Verify the message “Your order has been successfully processed!”
 * 2.37 Click on “CONTINUE”
 * 2.37 Verify the text “Welcome to our store”
 */
public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Click on Computer Menu.
        String menu = "Computers";
        clickOnElement(By.xpath("//a[text()='Computers ']"));

        //1.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleFromDropDown(By.id("products-orderby"), "Name: Z to A");

        //1.4 Verify the Product will arrange in Descending order.
        assertEqualsMethod("Not in reverse order", "Name: Z to A", By.xpath("//option[normalize-space()='Name: Z to A']"));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        String menu = "Computers";
        clickOnElement(By.xpath("//a[text()='Computers ']"));

        //2.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        Thread.sleep(2000);

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleFromDropDown(By.id("products-orderby"), "Name: A to Z");
        Thread.sleep(2000);

        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//a[text() = 'Build your own computer']"));
        Thread.sleep(2000);

        //2.5 Verify the Text "Build your own computer"
        assertEqualsMethod("Not in reverse order", "Build your own computer",
                By.xpath("//h1[normalize-space()='Build your own computer']"));
        Thread.sleep(2000);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        clickOnElement(By.id("product_attribute_1"));
        selectByVisibleFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        Thread.sleep(2000);

        //2.7.Select "8GB [+$60.00]" using Select class.
        clickOnElement(By.id("product_attribute_2"));
        selectByVisibleFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");
        Thread.sleep(2000);

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));
        Thread.sleep(2000);

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        Thread.sleep(2000);

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));
        Thread.sleep(2000);

        //2.11 Verify the price "$1,475.00"
        assertEqualsMethod("Incorrect Total", "$1,475.00", By.id("price-value-1"));
        Thread.sleep(2000);

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        Thread.sleep(2000);

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        assertEqualsMethod("Incorrect Message", "The product has been added to your shopping cart",
                By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Thread.sleep(2000);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class = 'close']"));
        Thread.sleep(2000);

        //2.14 Then MouseHover on "Shopping cart"
        mouseHoverToElement(By.xpath("//a[@class='ico-cart']"));

        //Click on "GO TO CART" button.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[@class='cart-label']"));

        //2.15 Verify the message "Shopping cart"
        assertEqualsMethod("Incorrect message displayed!", "Shopping cart",
                By.xpath("//h1[normalize-space()='Shopping cart']"));
        Thread.sleep(2000);

        //2.16 Change the Qty to "2"
        clearTextField(By.xpath("//input[@class='qty-input']"));
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        Thread.sleep(2000);

        //Click on "Update shopping cart"
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        Thread.sleep(2000);

        //2.17 Verify the Total"$2,950.00"
        assertEqualsMethod("Incorrect total price", "$2,950.00", By.xpath("//span[@class='product-subtotal']"));
        Thread.sleep(2000);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(2000);

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        Thread.sleep(2000);

        //2.20 Verify the Text “Welcome, Please Sign In!”
        assertEqualsMethod("Incorrect message displayed!", "Welcome, Please Sign In!",
                By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Thread.sleep(2000);

        //2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        Thread.sleep(2000);

        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Robert");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Jackson");
        sendTextToElement(By.name("BillingNewAddress.Email"), "robert_jackson@gmail.com");
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "233");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.name("BillingNewAddress.Address1"), "Harry Porter Road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "HP4 2PH");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07643667894");
        Thread.sleep(2000);

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[text() = 'Continue']"));
        Thread.sleep(2000);

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));
        Thread.sleep(2000);

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.27 Select “Master card” From Select credit card dropdown
        selectByVisibleFromDropDown(By.id("CreditCardType"), "Master card");

        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Robert Jackson");
        Thread.sleep(2000);
        sendTextToElement(By.id("CardNumber"), "0000 0000 0000 0000");
        clickOnElement(By.id("ExpireMonth"));
        selectByValueFromDropDown(By.id("ExpireMonth"), "10");
        selectByValueFromDropDown(By.id("ExpireYear"), "2026");
        Thread.sleep(2000);
        sendTextToElement(By.id("CardCode"), "526");

        //2.29 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is “Credit Card”
        assertEqualsMethod("Incorrect Card detail displayed.", "Payment Method: Credit Card",
                By.xpath("//li[@class='payment-method']"));

        //2.32 Verify “Shipping Method” is “Next Day Air”
        assertEqualsMethod("Incorrect Shipping method", "Shipping Method: Next Day Air",
                By.xpath("//li[@class = 'shipping-method']"));

        //2.33 Verify Total is “$2,950.00”
        assertEqualsMethod("Incorrect total", "$2,950.00", By.xpath("//span[text() ='$2,950.00']"));

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));

        //2.35 Verify the Text “Thank you”
        assertEqualsMethod("Incorrect Message displayed", "Thank you", By.xpath("//h1[text() = 'Thank you']"));

        //2.36 Verify the message “Your order has been successfully processed!”
        assertEqualsMethod("Incorrect message", "Your order has been successfully processed!",
                By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class = 'button-1 order-completed-continue-button']"));

        //2.37 Verify the text “Welcome to our store”
        assertEqualsMethod("Incorrect Welcome Text", "Welcome to our store",
                By.xpath("//h2[text() = 'Welcome to our store']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

