package kr.or.nextit.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.session.vo.LoginVo;

@Mapper
public interface LoginMapper {

	
	void insertLoginInfo(LoginVo loginVo) throws Exception;
}
