package kr.or.nextit.member.service;

import java.util.HashMap;
import java.util.List;

public interface MemberService {

	List<MemberVo> selectMemberList(MemberSearchVo searchVo)throws Exception;
	
	
	void insertMemberInfo(MemberVo memberVo) throws Exception;
	
	MemberVo selectMemberInfo(String seqNo) throws Exception;
	
	void updateMemberInfo(HashMap<String , Object> params) throws Exception;
	
	void deleteMemberInfo(String seqNo, MemberSearchVo searchVo) throws Exception;
	
	int selectMemberTotalCnt(MemberSearchVo searchVo) throws Exception;
	
	public MemberVo findIdCheck(String userId) throws Exception;

}