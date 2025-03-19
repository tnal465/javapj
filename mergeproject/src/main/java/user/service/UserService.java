package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.model.User;
import user.repository.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public User findUserById(String id) {
		return userMapper.findUserById(id);
	}
	
	@Transactional
	public void updateUser(User userSession) {
		userMapper.updateUser(userSession);
	}

	public boolean checkPassword(User user, String currentPassword) {
		return user.getPassword().equals(currentPassword);
	}
	
}
