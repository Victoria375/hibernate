package app.controller;

import app.ProductNotFoundException;
import app.ProductsErrorResponse;
import app.model.Product;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/list")
//    public String showAll(Model model) {
//        model.addAttribute("productList", productService.findAll());
//        return "products";
//    }

    @GetMapping
    public List<Product> showAll() {
        return productService.findAll();
    }

//    @GetMapping("/show_form")
//    public String showFormPage() {
//        return "product_form";
//    }
//
//    @GetMapping("/show_delete_form")
//    public String showDeleteFormPage() {
//        return "product_delete_form";
//    }

//    @PostMapping("/add")
//    public String addProduct(@RequestParam String title, @RequestParam String cost) {
//        Product product = new Product(title, Integer.valueOf(cost));
//        productService.add(product);
//        return "redirect:/products/list";
//    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        product.setId(0L);
        return productService.saveOrUpdate(product);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProduct(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteById(id);
        //model.addAttribute("productList", productService.findAll());
        return "redirect:/products/list";
    }

//    @DeleteMapping(value = "deleteId/{id}")
//    public String deleteProductId(@PathVariable Long id) {
//        productService.deleteById(id);
//        return "redirect:/products/list";
//    }

    @DeleteMapping("/{id}")
    public int deleteProductId(@PathVariable Long id) {
        productService.deleteById(id);
        return HttpStatus.OK.value();
    }

    @ExceptionHandler
    public ResponseEntity<ProductsErrorResponse>
    handleException(ProductNotFoundException exc) {
        ProductsErrorResponse studentsErrorResponse = new
                ProductsErrorResponse();
        studentsErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentsErrorResponse.setMessage(exc.getMessage());
        studentsErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(studentsErrorResponse, HttpStatus.NOT_FOUND);
    }


}
