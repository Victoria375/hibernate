package app.controller;

import app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public String showAll(Model model) {
        model.addAttribute("ordersList", orderService.findAll());
        return "orders";
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

}
