package ru.tb.service;

import ru.tb.products.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductList();

    void saveOrUpdate(Product product);

    Product getProductById(Long id);

    void deleteById(Long id);

}
