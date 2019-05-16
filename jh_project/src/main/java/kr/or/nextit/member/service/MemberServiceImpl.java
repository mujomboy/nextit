package kr.or.nextit.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.member.mapper.MemberMapper;
import kr.or.nextit.session.vo.LoginVo;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public void updateMyPage(LoginVo loginVo) throws Exception {
		mapper.updateMyPage(loginVo);
	}

	
}
