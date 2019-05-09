package kr.or.nextit.session.service.impl;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.session.service.LoginInfoVo;

@Mapper
public interface SessionMapper {

	LoginInfoVo selectMemberInfo(HashMap<String, Object> params) throws Exception;
}
