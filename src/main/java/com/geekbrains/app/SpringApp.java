package com.geekbrains.app;

import com.geekbrains.app.config.AppConfig;
import com.geekbrains.app.service.CartService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CartService cart1 = context.getBean("cartService", CartService.class);
        for (long i = 0; i < 5; i++) {
            cart1.addProduct(i);
        }

        cart1.deleteProduct(0L);
        System.out.println(cart1.getProducts());

        CartService cart2 = context.getBean("cartService", CartService.class);
        for (long i = 0; i < 4; i++) {
            cart2.addProduct(i);
        }
        cart2.deleteProduct(0L);
        cart2.deleteProduct(1L);
        cart2.deleteProduct(2L);
        System.out.println(cart2.getProducts());

    }
}
