package kr.or.nextit.member.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/memberList.do")
	public String getMemberList(
			Model model, 
			@ModelAttribute(name="searchVo") MemberSearchVo searchVo) throws Exception{
		
		int totalCount = memberService.selectMemberTotalCnt(searchVo);
		
		searchVo.setTotalCount(totalCount);
//		searchVo.setCurPage(1);
		searchVo.setScreenSize(3);
		searchVo.setPageBlockSize(3);
		searchVo.pageSetting();
		
		
		List<MemberVo> resultList = memberService.selectMemberList(searchVo);
		
		model.addAttribute("memberList", resultList);
		
		
		
		return "member/memberList";
	}
	
	@RequestMapping(value= {"/memberInsertFront.do"})
	public String getMemberInsertFront(
			ModelAndView modelAndView
			) throws Exception {
		
		
		return "member/memberInsert";
	}
	
	
	@RequestMapping(value="/memberInsertProc.do")
	public ModelAndView setMemberInserProc(
			ModelAndView modelAndViw,
			@ModelAttribute(name="memberVo") MemberVo memberVo,
			HttpServletRequest req) throws Exception {
		
		
		
		memberVo.setUsrIp(req.getRemoteAddr());
		
		try {
			memberService.insertMemberInfo(memberVo);
			
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl("/member/memberList.do");
			modelAndViw.setView(redirectView);
			
		} catch (Exception e) {
			modelAndViw.setViewName("member/memberInsert");
			e.printStackTrace();
			throw new Exception("회원가입시 에러가 발생하였습니다.", e);
		}

		return modelAndViw;
	}
	
	
	
	@RequestMapping(value="/memberView.do")
	public String getMemberInfoView(
			Model model,
			@ModelAttribute(name="searchVo") MemberSearchVo searchVo
			) throws Exception {
		
		log.debug("searchVo : {}", searchVo);
		log.debug("searchVo : {}", searchVo);
		log.debug("searchVo : {}", searchVo);
		log.debug("searchVo : {}", searchVo);
		
		MemberVo m = memberService.selectMemberInfo(searchVo.getSeqNo());
		
		model.addAttribute("memberInfo", m);
		
		return "member/memberView";
	}
	
	
	
	
	@RequestMapping(value="/memberUpdateFront.do")
	public String getMemberUpdateFront(
			ModelMap model,
			@RequestParam HashMap<String, Object> params
			) throws Exception{
		
		
		
		
		log.debug("param : {}", params);
		
		
		String seqNo = (String)params.get("seqNo");
		MemberVo m = memberService.selectMemberInfo(seqNo);
		
		model.addAttribute("m", m);
		
		return "member/memberUpdate";
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/memberUpdateProc.do")
	public String setMemberUpdateProc(
			ModelMap model,
			@RequestParam HashMap<String, Object> params,
			HttpServletRequest req
			) throws Exception{
		
		log.debug("param : {}", params);

		params.put("usrIp",	req.getRemoteAddr());
		params.put("updUser", "system");
		
		try {
			memberService.updateMemberInfo(params);
			return String.format("redirect:/member/memberView.do?seqNo=%s", params.get("seqNo"));
		} catch (Exception e) {
			return String.format("redirect:/member/memberUpdateFront.do?seqNo=%s", params.get("seqNo"));
		}	
	}
	
	@RequestMapping(value="/memberDeleteProc.do")
	public String setDeleteMemberInfo(
			Model model,
			@RequestParam(name="seqNo", required=true) String seqNo,
			@ModelAttribute MemberSearchVo searchVo
			) throws Exception {
		
		memberService.deleteMemberInfo(searchVo.getSeqNo(), searchVo);
		
		return "redirect:/member/memberList.do";
	}
}
