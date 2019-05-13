package kr.or.nextit.member.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;

@Service("MemberService")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public List<MemberVo> selectMemberList(MemberSearchVo searchVo) throws Exception {
		
//		if(searchVo.getSearchType() == null || searchVo.getSearchType().isEmpty()) {
//			searchVo.setSearchType("usr_id");
//		}
		
		List<MemberVo> resultList =  memberMapper.selectMemberList(searchVo);
		
		return resultList;
	}

	@Override
	public void insertMemberInfo(MemberVo memberVo) throws Exception {
		
		memberMapper.insertMemberInfo(memberVo);
	}

	@Override
	public MemberVo selectMemberInfo(String seqNo) throws Exception {
		
		return memberMapper.selectMemberInfo(seqNo);
	}

	@Override
	public void updateMemberInfo(HashMap<String, Object> params) throws Exception {

		memberMapper.updateMemberInfo(params);
	}

	@Override
	public void deleteMemberInfo(String seqNo, MemberSearchVo searchVo) throws Exception {

		if(seqNo == null)
			throw new NullPointerException("seqNo 값이 넘어 오지 않았습니다.");
		
		//memberMapper.deleteMemberInfo(seqNo);
		
		memberMapper.deleteFlagMemberInfo(searchVo);
	}

	@Override
	public int selectMemberTotalCnt(MemberSearchVo searchVo) throws Exception {
		// TODO Auto-generated method stub
		try {
			return memberMapper.selectMemberTotalCnt(searchVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public MemberMapper getMemberMapper() {
		return memberMapper;
	}

	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

}
