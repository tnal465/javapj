package restapi;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class API2Controller {

	// curl http://localhost:8080/api2/member -v -X GET [POST/PUT/DELETE]
	
	@PostMapping("member")
	public String insert() {return "member post method";}
	@GetMapping("members")
	public String findAll() {return "member list get method";}
	@GetMapping("member")
	public String findById() {return "member get method";}
	@PutMapping("member")	
	public String update() {return "member put method";}
	@DeleteMapping("member")
	public String delete() {return "member delete method";}
}
