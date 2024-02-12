package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl service;
    @BeforeEach
    void setup() {
    }
    @Test
    void testCreate() {
        // Exercise
        service = new ProductServiceImpl();
        Product product = new Product();
        Product serviceProduct = service.create(product);

        // Verify
        assertEquals(product, serviceProduct);
    }

    @Test
    void testEdit() {
        // Exercise
        String productName = "Kecap Cap Austin";
        int productQuantity = 100;

        Product product = new Product();
        product.setProductName(productName);
        product.setProductQuantity(productQuantity);
        service.create(product);

        productQuantity = 20;

        product = service.edit(productName, productQuantity);

        assertEquals(productName, product.getProductName());
        assertEquals(productQuantity, product.getProductQuantity());
    }

    @Test
    void testDelete() {
        // Exercise
        String productName = "Kecap Cap Austin";
        int productQuantity = 100;

        Product product = new Product();
        product.setProductName(productName);
        product.setProductQuantity(productQuantity);
        service.create(product);

        product = service.delete(productName);

        // Verify
        assertEquals(productName, product.getProductName());
        assertEquals(productQuantity, product.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        // Exercise
        List<Product> productList = service.findAll();

        // Verify
        assertEquals(productList.size(), 0);
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        // Exercise
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        service.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0fgde46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        service.create(product2);

        // Verify
        List<Product> productList = service.findAll();
        assertEquals(productList.size(), 2);

        Product savedProduct = productList.get(0);
        assertEquals(savedProduct, product1);

        savedProduct = productList.get(1);
        assertEquals(savedProduct, product2);
    }

}