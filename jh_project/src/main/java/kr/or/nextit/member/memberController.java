package kr.or.nextit.member;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.session.vo.LoginVo;

@Controller
@RequestMapping(value="/member")
public class memberController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MemberService service;

	@RequestMapping(value="/myPageView.do")
	public String myPageView(
			HttpSession session,
			Model model
			) throws Exception {
		
		LoginVo loginVo = (LoginVo)session.getAttribute("loginInfo");
		if(loginVo != null) {
			String[] nums = loginVo.getPhone().split("-");
			model.addAttribute("nums", nums);
		}
		
		log.info("마이페이지 이동");
		
		return "member/myPage";
	}
	
	@RequestMapping(value="/myPageUpdate.do")
	public String myPageUpdate(
			@ModelAttribute LoginVo loginVo,
			Model model,
			HttpSession session
			) throws Exception{
		
		String page = null;
		
		log.info("마이페이지 개인 정보 수정");
		log.info("수정 정보 : {}", loginVo);
		
		try {
			service.updateMyPage(loginVo);
			
			model.addAttribute("title", "수정 완료");
			model.addAttribute("message", "MODIFICATIONS COMPLETE!");
			model.addAttribute("insert","수정");
			
			page = "login/memberSignUpComplete";
			
			LoginVo orgLoginVo = (LoginVo)session.getAttribute("loginInfo");
			
			if(orgLoginVo == null) page = "home";
			else {
				orgLoginVo.setAge(loginVo.getAge());
				orgLoginVo.setName(loginVo.getName());
				orgLoginVo.setEmail(loginVo.getEmail());
				orgLoginVo.setPhone(loginVo.getPhone());
				
				session.setAttribute("loginInfo", orgLoginVo);
			}
		} catch(Exception e) {
			
			throw new RuntimeException(e);
		}
		
		return page;
	}
}
