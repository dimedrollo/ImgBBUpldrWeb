package ru.dimedrollo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dimedrollo.models.Product;
import ru.dimedrollo.repositories.ProductRepository;

@Controller
public class ProductController {
    // DI
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public String addProduct(@RequestParam("description") String description,
                          @RequestParam("price") int price, @RequestParam("amount") int amount) {

        Product product = Product.builder()
                .description(description)
                .price(price)
                .amount(amount)
                .build();

       productRepository.save(product);

        return "redirect:/users_add.html";
    }
}

