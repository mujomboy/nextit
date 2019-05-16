package kr.or.nextit.login.service;

import java.util.HashMap;

import kr.or.nextit.session.vo.LoginVo;

public interface LoginService {

	void insertLoginInfo(LoginVo loginVo) throws Exception;
	
	LoginVo selectLoginInfo(HashMap<String, Object> params) throws Exception;
	
	String selectCheckId(HashMap<String, Object> params) throws Exception;
}
