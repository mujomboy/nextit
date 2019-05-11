package kr.or.nextit.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping(value="/loginView.do")
	public String loginView() throws Exception{
		
		log.info("로그인 페이지");
		return "login/memberSignUp";
	}
}
