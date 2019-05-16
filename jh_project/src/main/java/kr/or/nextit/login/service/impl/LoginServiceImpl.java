package kr.or.nextit.login.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.login.mapper.LoginMapper;
import kr.or.nextit.login.service.LoginService;
import kr.or.nextit.session.vo.LoginVo;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper mapper;
	
	@Override
	public void insertLoginInfo(LoginVo loginVo) throws Exception {
		mapper.insertLoginInfo(loginVo);
	}

	@Override
	public LoginVo selectLoginInfo(HashMap<String, Object> params) throws Exception {
		return mapper.selectLoginInfo(params);
	}

	@Override
	public String selectCheckId(HashMap<String, Object> params) throws Exception {
		
		return mapper.selectCheckId(params);
	}
	
	

}
