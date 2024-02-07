package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {
    /*
     * The port number assigned to the running application during test execution.
     * Set automatically during each test run by Spring Framework's test context.
     */
    @LocalServerPort
    private int serverPort;

    /*
     * The base URL for testing. Default to {@code http://localhost}.
     */
    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d/product/create", testBaseUrl, serverPort);
    }

    @Test
    void pageTitle_isCorrect(ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);
        String pageTitle = driver.getTitle();

        // Verify
        assertEquals("Create New Product", pageTitle);
    }

    @Test
    void createProductFunction_isCorrect(ChromeDriver driver) throws Exception {
        // Exercise
        driver.get(baseUrl);

        WebElement nameInput = driver.findElement(By.id("nameInput"));
        nameInput.clear();
        String productName = "Sampo Cap Bambang";
        nameInput.sendKeys(productName);

        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        quantityInput.clear();
        String productQuantity = "100";
        quantityInput.sendKeys(productQuantity);

        WebElement submitButton = driver.findElement(By.id("submitButton"));
        submitButton.click();

        // Verify
        String createdProductName = driver.findElement(By.id("productName")).getText();
        assertEquals(productName, createdProductName);

        String createdProductQuantity = driver.findElement(By.id("productQuantity")).getText();
        assertEquals(productQuantity, createdProductQuantity);
    }
}