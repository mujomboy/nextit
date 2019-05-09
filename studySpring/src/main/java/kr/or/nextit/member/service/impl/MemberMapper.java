package kr.or.nextit.member.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberVo;

@Mapper
public interface MemberMapper {
	
	
	void insertMemberInfo(MemberVo memberVo) throws Exception;
	
	List<MemberVo> selectMemberList(
			// param 객체는 단 1개만 넘길 수 있음
			// map, vo, String, int 등 param 1개 이상을 넣을 수 있음.
			MemberSearchVo searchVo
			) throws Exception;
	
	MemberVo selectMemberInfo(String seqNo) throws Exception;
	
	void updateMemberInfo(HashMap<String, Object> params) throws Exception;
	
	void deleteMemberInfo(String seqNo) throws Exception;
	
	void deleteFlagMemberInfo(MemberSearchVo searchVo) throws Exception;
	
	int selectMemberTotalCnt(MemberSearchVo searchVo) throws Exception;
}
