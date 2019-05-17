package kr.or.nextit.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.session.vo.LoginVo;

@Mapper
public interface MemberMapper {

	void updateMyPage(LoginVo loginVo) throws Exception;
}
