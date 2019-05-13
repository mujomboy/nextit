package kr.or.nextit.login.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.session.vo.LoginVo;

@Mapper
public interface LoginMapper {

	
	void insertLoginInfo(LoginVo loginVo) throws Exception;
	
	LoginVo selectLoginInfo(HashMap<String, Object> params) throws Exception;
}
