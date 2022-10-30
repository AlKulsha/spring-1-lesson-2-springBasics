package ru.kulsha;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kulsha.config.AppConfiguration;

import java.util.Scanner;

public class CartManager {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        System.out.println("Commands:\n" +
                "new  - create new cart\n" +
                "add  - add product with id\n" +
                "remove - remove product by id\n" +
                "show - show the products in the cart\n" +
                "exit - close console");
        Scanner scanner = new Scanner(System.in);
        CartService cartService = null;

        while (true){
            System.out.println("Enter command to operate with the cart");
            String command = scanner.next().toLowerCase().trim();

            switch (command){
                case "new": {
                    cartService = context.getBean(CartService.class);
                    break;
                }
                case "add":{
                    if (cartService==null){
                        System.out.println("Create the cart");
                        break;
                    }
                    System.out.println("Enter product id");
                    long id = scanner.nextLong();
                    cartService.addProductToCart(id);
                    break;
                }
                case "remove":{
                    if (cartService==null){
                        System.out.println("Create the cart");
                        break;
                    }
                    System.out.println("Enter product id you want to remove");
                    long id = scanner.nextLong();
                    cartService.removeProductFromCart(id);
                    break;
                }
                case "show":{
                    if (cartService==null){
                        System.out.println("Create the cart");
                        break;
                    }
                    cartService.getCartProduct().forEach(System.out::println);
                    System.out.println();
                    break;
                }
                case "exit":{
                    return;
                }
            }

        }


    }
}
