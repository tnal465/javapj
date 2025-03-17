package restapi;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//@RestController
@Controller
//@RequestMapping("/api")
public class WEB_APIController {
	
	@GetMapping("/")
	public String mainIndex() {
		return "index"; //views/index.jsp
	}

	@GetMapping("member")
	public void member() {}//views/member.jsp
	
	@GetMapping("list")
	public void list() {} //views/list.jsp
	
	@GetMapping("api2")
	public void api2() {} //views/api2.jsp
	
	//웹페이지 처리
	@GetMapping("api")
	public void index() {
		//localhost:8080/api
		// views/api.jsp
	}
	
	//localhost:8080/data1
	@GetMapping("data1")
	@ResponseBody
	public String data1() {
		return "{\"name\":\"kildong\",\"age\":23}";
	}
	
	//localhost:8080/data2
	@GetMapping("data2")
	@ResponseBody
	public Person data2() {
		return new Person("minsu",23);
	}
	
	//localhost:8080/data3
	@GetMapping("data3")
	@ResponseBody
	public JSONObject data3() {
		JSONObject json=new JSONObject();
		json.put("name","younghe");
		json.put("age", 26);
		return json;
	}
	
	//localhost:8080/data4
		@GetMapping("data4")
		@ResponseBody
		public List<Person> data4() {
			List<Person> list=new ArrayList<Person>();
			list.add(new Person("kildong",20));
			list.add(new Person("minsu",23));
			list.add(new Person("younghe",26));			
			return list;
		}
		
		//localhost:8080/data5
		@GetMapping("data5")
		@ResponseBody
		public Person[] data5() {
			Person[] persons=new Person[3];
			persons[0]=new Person("kildong",20);
			persons[1]=new Person("minsu",23);
			persons[2]=new Person("younghe",26);
			return persons;
		}
	
}
