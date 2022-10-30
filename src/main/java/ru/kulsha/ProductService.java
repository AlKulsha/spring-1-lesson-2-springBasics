package ru.kulsha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kulsha.persist.Product;
import ru.kulsha.persist.ProductRepository;

import javax.annotation.PostConstruct;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init(){
        System.out.println("PostConstruct method has been done");
    }

    public void insert(Product product) {
        if(product.getType().equals("DIET") || product.getType().equals("HEALTH")) {
            this.productRepository.insert(product);
        } else {
            throw new IllegalArgumentException("Incorrect type");
        }
    }

    public int findAll(){
        return this.productRepository.findAll().size();
    }
}
