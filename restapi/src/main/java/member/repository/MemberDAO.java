package member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import member.model.Member;
import member.model.MemberForm;

public interface MemberDAO {
	public int insert(@Param("member") Member member);
	public List<Member> findAll();
	public Member findById(String username);
	public int update(@Param("member") Member member);
	public int delete(String username);
}
