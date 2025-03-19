package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import user.model.User;
import user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService; 

	// 세션에서 user 정보 가져옴
	private User getUserFromSession(HttpServletRequest request) {
	    HttpSession session = request.getSession();
	    String userId = (String) session.getAttribute("user");
	    return userService.findUserById(userId);
	}

	@GetMapping("/mypage")
	public String mypage(Model model, HttpServletRequest request) {
	    User user = getUserFromSession(request); 
	    model.addAttribute("user", user);
	    return "mypage";
	}

	@GetMapping("/edit")
	public String editUser(Model model, HttpServletRequest request) {
	    User user = getUserFromSession(request);
	    model.addAttribute("user", user);
	    return "/user/userEditForm";  
	}
	
	/*
 	@GetMapping("/mypage")
    public String mypage(Model model,HttpServletRequest request) {
    	HttpSession session=request.getSession();
    	session.setAttribute("user","user1");	//다른곳에서 세션 저장하면 이 줄은 삭제
    	//User user = userService.findUserById("user1");
    	User user = userService.findUserById((String)session.getAttribute("user"));
        model.addAttribute("user", user);
        return "mypage";
    }
    
    @GetMapping("/edit")
    public String editUser(Model model,HttpServletRequest request) {
    	HttpSession session=request.getSession();
    	session.setAttribute("user","user1");	//다른곳에서 세션 저장하면 이 줄은 삭제
    	//User user = userService.findUserById("user1");
    	User user = userService.findUserById((String)session.getAttribute("user"));
        model.addAttribute("user", user);
        return "/user/userEditForm";  
    }
	 */

    
	@PostMapping("/userEditSuccess")
	public String updateUser(@ModelAttribute User user, HttpServletRequest request, Model model) {
		    // 세션에서 사용자 정보 가져오기
		User userSession = getUserFromSession(request);
		
		// 수정된 닉네임과 배송지 반영
		userSession.setNickname(user.getNickname());
		userSession.setAddress(user.getAddress());
		
		// 비밀번호 수정이 필요한 경우 처리 (비밀번호도 수정하려면 추가 로직 필요)
		// if(user.getPassword() != null && !user.getPassword().isEmpty()) {
		//     existingUser.setPassword(user.getPassword());
		// }
		
		// 업데이트된 사용자 정보를 DB에 저장
		userService.updateUser(userSession);
	
		model.addAttribute("user", userSession);
		return "redirect:/user/mypage";
	}

	@GetMapping("/editPassword")
	public String changePasswordForm(Model model, HttpServletRequest request) {
	    // 사용자 정보 세션에서 가져오기
	    User user = getUserFromSession(request);
	    model.addAttribute("user", user);
	    return "/user/editPassword";  // 비밀번호 수정 페이지
	}
	
	@PostMapping("/editPassword")
	public String changePassword(@RequestParam("currentPassword") String currentPassword,
	                             @RequestParam("newPassword") String newPassword,
	                             @RequestParam("confirmPassword") String confirmPassword,
	                             HttpServletRequest request, Model model) {

		User user = getUserFromSession(request);

	    // 현재 비밀번호 확인
	    if (!userService.checkPassword(user, currentPassword)) {
	        model.addAttribute("currentPasswordError", "현재 비밀번호가 올바르지 않습니다.");
	        return "user/editPassword"; // 오류 메시지와 함께 폼으로 돌아감
	    }

	    // 새 비밀번호와 확인 비밀번호가 일치하는지 확인
	    if (!newPassword.equals(confirmPassword)) {
	        model.addAttribute("passwordMismatchError", "새 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
	        return "user/editPassword"; // 오류 메시지와 함께 폼으로 돌아감
	    }

	    // 비밀번호 변경
	    user.setPassword(newPassword);
	    userService.updateUser(user); // 사용자 정보 업데이트

	    model.addAttribute("user", user);
	    return "redirect:/user/mypage"; // 변경 후 마이페이지로 리다이렉트
	}

    
   
}
