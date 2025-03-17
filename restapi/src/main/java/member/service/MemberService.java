package member.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.model.Member;
import member.model.MemberForm;
import member.repository.MemberDAO;

@Service
public class MemberService {
	@Autowired
	MemberDAO dao; //객체대신 -> 인터페이스 mapper
	
	public int insert(MemberForm form) {
		Member member=new Member();
		BeanUtils.copyProperties(form, member);
		member.setRole("ROLE_USER");
		member.setRegdate(new java.sql.Date(new Date().getTime()));
		return dao.insert(member);		
	}

	public List<Member> findAll() {
		return dao.findAll();
	}

	public Member findById(String username) {
		return dao.findById(username);
	}

	public int update(MemberForm form) {
		Member umember=new Member();
		BeanUtils.copyProperties(form, umember);
		Member oldMember=dao.findById(form.getUsername());
		if(form.getPassword()==null) {
			umember.setPassword(oldMember.getPassword());
		}
		if(form.getEmail()==null) {
			umember.setEmail(oldMember.getEmail());
		}
		//기존데이터를 입력처리
		umember.setRole(oldMember.getRole());
		umember.setRegdate(oldMember.getRegdate());
		System.out.println(umember);
		return dao.update(umember);
	}

	public int delete(String username) {
		return dao.delete(username);
	}

}
