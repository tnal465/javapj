package restapi;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

	//문자열 json
	//localhost:8080/api/data1
	@GetMapping("data1")
	public String data1() {
		return "{\"name\":\"kildong\",\"age\":23}";
	}
	
	//자바객체 json
	//localhost:8080/api/data2
	@GetMapping("data2")
	public Person data2() {
		return new Person("minsu",23);
	}
	
	//자바에서 지원하는 JSON객체형
	//localhost:8080/api/data3
	@GetMapping("data3")
	public JSONObject data3() {
		JSONObject json=new JSONObject();
		json.put("name","younghe");
		json.put("age", 26);
		return json;
	}
	
	//자바객체를 리스트에 입력하여 처리하는 배열형 객체
	//localhost:8080/api/data4
		@GetMapping("data4")
		public List<Person> data4() {
			List<Person> list=new ArrayList<Person>();
			list.add(new Person("kildong",20));
			list.add(new Person("minsu",23));
			list.add(new Person("younghe",26));
			list.add(new Person("lee",30));
			list.add(new Person("park",45));
			list.add(new Person("yoon",50));
			return list;
		}
		//자바객체를 배열에 입력하여 처리하는 배열형 객체
		//localhost:8080/api/data5
		@GetMapping("data5")
		public Person[] data5() {
			Person[] persons=new Person[3];
			persons[0]=new Person("kildong",20);
			persons[1]=new Person("minsu",23);
			persons[2]=new Person("younghe",26);
			return persons;
		}
	
}
