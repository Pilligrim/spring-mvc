package com.geekbrains.app.controller;

import com.geekbrains.app.model.Product;
import com.geekbrains.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/show_all")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productService.getAll());
        return "products";
    }

    @GetMapping("/show/{id}")
    public String showProductsPage(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.findById(id));
        return "product_info";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create_product";
    }

    @PostMapping("/create")
    public String saveProduct(@RequestParam String title, @RequestParam Integer cost) {
        Product product = new Product(null,title, cost);
        productService.save(product);
        return "redirect:/products/show_all";
    }
}
