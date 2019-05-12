package kr.or.nextit.login;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.nextit.session.vo.LoginVo;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping(value="/loginView.do")
	public String loginView() throws Exception{
		
		log.info("로그인 페이지");
		return "login/login";
	}
	
	@RequestMapping(value="/signUpView.do")
	public String SignUpView() throws Exception {
		
		log.info("회원가입 페이지");
		return "login/memberSignUp";
	}
	
	@RequestMapping(value="/signUpExc.do")
	public String SignUpExcute(
			HttpServletRequest req,
			@ModelAttribute(name="loginVo") LoginVo loginVo
			) throws Exception {
		
		log.info("회원가입 여부 판별");
		
		loginVo.setIp(req.getRemoteAddr());
		
		return "redirect:/";
	}
}
