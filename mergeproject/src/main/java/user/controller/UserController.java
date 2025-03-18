package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import user.model.User;
import user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService; 

    @GetMapping("/mypage")
    public String mypage(Model model) {
    	User user = userService.findNicknameById("user1");
        if (user == null) {
            System.out.println(">>>>>>>>>>>>>>>>>>User not found");
        } else {
            System.out.println(">>>>>>>>>>>>>>User found: " + user.getNickname());
        }
        model.addAttribute("user", user);
        return "mypage";
    }
    
    @GetMapping("/edit")
    public String editUser() {
        return "/user/userEditForm";  
    }
    
    
   
}
