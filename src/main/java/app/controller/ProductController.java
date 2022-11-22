package app.controller;

import app.model.Product;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String showAll(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "products";
    }

    @GetMapping("/show_form")
    public String showFormPage() {
        return "product_form";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String title, @RequestParam String cost) {
        Product product = new Product(title, Integer.valueOf(cost));
        productService.add(product);
        return "redirect:/products/list";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Long id, Model model) {
        productService.deleteById(id);
        model.addAttribute("productList", productService.findAll());
        return "redirect:/products/list";
    }
}
