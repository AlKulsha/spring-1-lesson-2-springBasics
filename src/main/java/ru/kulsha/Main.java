package ru.kulsha;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kulsha.config.AppConfiguration;
import ru.kulsha.persist.Product;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
//        context.getBean("productService", ProductService.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        ProductService productService = context.getBean("productService", ProductService.class);
        Cart cart = context.getBean("cart", ru.kulsha.Cart.class);
        cart.add(new Product(1L, "milk", 150));
        cart.getAllProduct();

//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("Enter product name: ");
//            String productName = scanner.nextLine();
//
//            System.out.println("Enter product type: ");
//            String type = scanner.nextLine();
//
//            productService.insert(new Product(productName, type));
//
//            System.out.println("New product has been added. Current users count: " + productService.findAll());
//
//            System.out.println("Enter \"end\" to exit");
//            if (scanner.nextLine().equals("end")) {
//                return;
//            }
//        }
    }
}
