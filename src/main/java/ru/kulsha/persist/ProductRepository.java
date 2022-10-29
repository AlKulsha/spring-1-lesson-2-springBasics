package ru.kulsha.persist;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void addProduct(Long id, Product product);

    Product findById(long id);

    void update(Product product);

    void delete(Long id);

    long getCount();

    void insert(Product product);
}
