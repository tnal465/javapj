package user.model;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
	 String id;
     String password;
     String name;
     String nickname;
     int age;
     String gender;
     String address;
}
