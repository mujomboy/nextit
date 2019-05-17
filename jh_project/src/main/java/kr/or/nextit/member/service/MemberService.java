package kr.or.nextit.member.service;

import kr.or.nextit.session.vo.LoginVo;

public interface MemberService {

	void updateMyPage(LoginVo loginVo) throws Exception;
}
