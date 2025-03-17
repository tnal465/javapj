package member.controller;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import member.model.Member;
import member.model.MemberForm;
import member.service.MemberService;

@RestController
@RequestMapping("/restapi")
public class APIMemberController {

	@Autowired
	MemberService service;

	
	@PostMapping("member")
	//문자열로 보내지만 data정보가 있을 경우 @RequestBody사용
	public int insert(@RequestBody MemberForm form) {
		System.out.println(form);
		return service.insert(form);
	}
	
	@GetMapping("members")
	public List<Member> findAll() {
	   return service.findAll();
	}
	
	@GetMapping("member")
	public Member findByIdParam(@Param("username") String username) {
		System.out.println(username);
		return service.findById(username);
	}
	
	@GetMapping("member/{username}")
	public Member findByIdPath(@PathVariable("username") String username) {
		System.out.println(username);
		return service.findById(username);
	}



	 @PutMapping("member")	
	public int update( @RequestBody MemberForm form) {
		System.out.println(form);
		return service.update(form);
	} 

	


	

	
	
	//ajax contentType:"application/x-www-form-urlencoded"로 전송하고
	// { }의 객체로 전송할 때 url을 처리를 위한 코드이지만 전송되는 부분이 매칭되지 않는 문제 발생
	/*
	@PutMapping("member")	
	public int update(@RequestParam String username, 
			@RequestParam String password, 
			@RequestParam String email) {
		MemberForm form=new MemberForm(username, password, email);
		System.out.println(form);
		return service.update(form);
	}
	*/
	
	//파라메다를 이용하여 처리하는 방법
	@DeleteMapping("member")
	public int deleteParam(@Param("username")String username) {
		System.out.println(username);
		return service.delete(username);
	}
	//경로를 이용하여 처리하는 방법
	@DeleteMapping("member/{username}")
	public int deletePath(@PathVariable("username")String username) {
		System.out.println(username);
		return service.delete(username);
	}
}
