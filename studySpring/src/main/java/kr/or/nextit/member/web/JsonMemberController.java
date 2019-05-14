package kr.or.nextit.member.web;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;

@Controller
@RequestMapping(value="/json")
public class JsonMemberController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="propertyService")
	private Properties propertyService;
	
	@Resource(name="MemberService")
	private MemberService service;
	
	@RequestMapping(value="/memberListFront.do")
	public String getMemberListFront() throws Exception {
		
		return "json/memberList";
	}
	
	@ResponseBody
	@RequestMapping(value="memberListProc.json")
	public List<MemberVo> getMemberListProc(
			@ModelAttribute(name="searchVo") MemberSearchVo searchVo
			) throws Exception {
		
		int totalCount = service.selectMemberTotalCnt(searchVo);
		
		searchVo.setTotalCount(totalCount);
//		searchVo.setCurPage(1);
		searchVo.setScreenSize(3);
		searchVo.setPageBlockSize(3);
		searchVo.pageSetting();
		
		
		List<MemberVo> resultList = service.selectMemberList(searchVo);
		
		
		return resultList;
	}
	
	
	@RequestMapping(value= {"/memberInsertFront.do"})
	public String getMemberInsertFront(
			ModelAndView modelAndView
			) throws Exception {
		
		
		return "json/memberInsert";
	}
	
	@RequestMapping(value="/findIdCheckProc.json")
	@ResponseBody
	public HashMap<String, Object> findIdCheck(
			@RequestParam HashMap<String, Object> params
			) throws Exception {
		
		log.debug("params : {}",params);
		
		
		
		HashMap<String, Object> result = new HashMap<>();
		
		try {
			String userId = (String) params.get("usrId");
			
			if(userId == null || userId.isEmpty())
				throw new Exception("회원 아이디를 입력 해야함");
			
			if(service.findIdCheck(userId) == null) {
				result.put("status", true);
				result.put("message", "사용 가능 아이디");
				result.put("status", userId);
			} else {
				throw new Exception("아이디가 있음");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", false);
			result.put("message", e.getMessage());
			
		}
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	
}
