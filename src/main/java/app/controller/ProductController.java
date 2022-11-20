package app.controller;

import lesson5.Product;
import app.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductDao productDao;

    @Autowired
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("productList", productDao.findAll());
        return "products";
    }

    @GetMapping("/show_form")
    public String showFormPage() {
        return "product_form";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String title, @RequestParam String cost) {
        Product product = new Product(title, Integer.valueOf(cost));
        productDao.add(product);
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Long id, Model model) {
        productDao.deleteById(id);
        model.addAttribute("productList", productDao.findAll());
        return "redirect:/products";
    }
}
