package kr.or.nextit.login.service;

import kr.or.nextit.session.vo.LoginVo;

public interface LoginService {

	void insertLoginInfo(LoginVo loginVo) throws Exception;
}
