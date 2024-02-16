package id.ac.ui.cs.advprog.eshop.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
class MainControllerTest {

    final private MainController controller = new MainController();
    private Model model;

    @BeforeEach
    void setup() {
    }

    @Test
    void testMainPage() {
        // Exercise
        String returnValue = controller.mainPage(model);

        // Verify
        assertEquals("homePage", returnValue);
    }
}