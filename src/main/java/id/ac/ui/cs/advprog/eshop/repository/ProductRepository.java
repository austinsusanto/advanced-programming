package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Product edit(String productName, int productQuantity) {
        for (Product product: productData) {
            if (product.getProductName() != null && product.getProductName().equals(productName)) {
                product.setProductQuantity(productQuantity);
                return product;
            }
        }
        return null;
    }

    public Product delete(String productName) {
        for (Product product: productData) {
            if (product.getProductName().equals(productName)) {
                productData.remove(product);
                return product;
            }
        }
        return null;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }
}