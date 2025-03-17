package user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import order.model.Order;
import user.service.UserService;
@RequestMapping("/user")
@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;

	@RequestMapping("")
	public String userInfo(Model model) { 
	    List<Order> orders = userService.getOrderList();
	    model.addAttribute("orders", orders); 
	    return "user"; 
	}

	
	
	/*
	@RequestMapping("user")
	public String user() {
		return "user";
	}
	
	
    @PostMapping("/save")
    public String saveProfile(@RequestParam String nickname) {
        System.out.println("���옣�맂 �땳�꽕�엫: " + nickname);
        return "redirect:/user/success";
    }

    @GetMapping("/success")
    public String successPage() {
        return "success"; 
    }
    */
}
