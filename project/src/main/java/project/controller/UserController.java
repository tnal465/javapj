package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.model.Order;
import project.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public String getUserOrders(Model model) {
        List<Order> orders = service.findAll(); 
        model.addAttribute("orders", orders);
        return "user";
    }
}