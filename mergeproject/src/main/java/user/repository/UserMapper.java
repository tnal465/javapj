package user.repository;

import org.apache.ibatis.annotations.Mapper;

import user.model.User;

@Mapper
public interface UserMapper {
	User findNicknameById(String id);
}
