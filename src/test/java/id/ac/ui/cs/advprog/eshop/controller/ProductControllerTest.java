package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {
    @Mock
    private ProductService service;
    @Mock
    private Model model;
    @InjectMocks
    private ProductController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProductPage() {
        // Exercise
        String returnValue = controller.createProductPage(model);

        // Verify
        assertEquals("CreateProduct", returnValue);
    }

    @Test
    void testCreateProductPost() {
        // Exercise
        Product product = new Product();
        String returnValue = controller.createProductPost(product, model);

        // Verify
        assertEquals("redirect:list", returnValue);
    }

    @Test
    void testEditProductPage() {
        // Exercise
        String returnValue = controller.editProductPage(model);

        // Verify
        assertEquals("EditProduct", returnValue);
    }

    @Test
    void testEditProductPost() {
        // Exercise
        Product product = new Product();
        String returnValue = controller.editProductPost(product, model);

        // Verify
        assertEquals("redirect:list", returnValue);
    }

    @Test
    void testDeleteProductPage() {
        // Exercise
        String returnValue = controller.deleteProductPage(model);

        // Verify
        assertEquals("DeleteProduct", returnValue);
    }

    @Test
    void testDeleteProductPost() {
        // Exercise
        Product product = new Product();
        String returnValue = controller.deleteProductPost(product, model);

        // Verify
        assertEquals("redirect:list", returnValue);
    }

    @Test
    void testProductListPage() {
        // Exercise
        String returnValue = controller.productListPage(model);

        // Verify
        assertEquals("ProductList", returnValue);
    }

}