package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.Iterator;
import java.util.List;

public interface ProductService {
    public Product create(Product product);
    public Product edit(String productName, int productQuantity);
    public Product delete(String productName);
    public List<Product> findAll();
}