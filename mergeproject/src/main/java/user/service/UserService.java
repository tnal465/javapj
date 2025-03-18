package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.model.User;
import user.repository.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public User findNicknameById(String id) {
		return userMapper.findNicknameById(id);
	}
}
