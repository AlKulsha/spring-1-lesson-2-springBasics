package ru.kulsha;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.kulsha.persist.Product;

import java.util.*;

@Component
@Scope("prototype")
public class Cart {
    private Set<Product> cart = new HashSet<>();

    public void add(Product product){
        cart.add(product);
    }

    public void remove(Product product){
        cart.remove(product);
    }

    public List<Product> getAllProduct(){
        System.out.println(Arrays.asList(new ArrayList(cart)));
        return new ArrayList<>(cart);
    }
}
