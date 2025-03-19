package user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import user.model.User;

@Mapper
@Repository
public interface UserMapper {
	User findUserById(String id);

	void updateUser(User user);
}
