package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
class ProductControllerTest {

    final private ProductController controller = new ProductController();
    private Model model = new ConcurrentModel();

    @BeforeEach
    void setup() {
    }

    @Test
    void testCreateProductPage() {
        // Exercise
        String returnValue = controller.createProductPage(model);

        // Verify
        assertEquals(returnValue, "createProduct");
    }

    @Test
    void testCreateProductPost() {
        // Exercise
        Product product = new Product();
        String returnValue = controller.createProductPost(product, model);

        // Verify
        assertEquals(returnValue, "redirect:list");
    }

    @Test
    void testEditProductPage() {
        // Exercise
        String returnValue = controller.editProductPage(model);

        // Verify
        assertEquals(returnValue, "editProduct");
    }

    @Test
    void testEditProductPost() {
        // Exercise
        Product product = new Product();
        String returnValue = controller.editProductPost(product, model);

        // Verify
        assertEquals(returnValue, "redirect:list");
    }

    @Test
    void testDeleteProductPage() {
        // Exercise
        String returnValue = controller.deleteProductPage(model);

        // Verify
        assertEquals(returnValue, "deleteProduct");
    }

    @Test
    void testDeleteProductPost() {
        // Exercise
        Product product = new Product();
        String returnValue = controller.deleteProductPost(product, model);

        // Verify
        assertEquals(returnValue, "redirect:list");
    }

    @Test
    void testProductListPage() {
        // Exercise
        String returnValue = controller.productListPage(model);

        // Verify
        assertEquals(returnValue, "productList");
    }

}