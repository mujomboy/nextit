package kr.or.nextit.login;

import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.nextit.login.service.LoginService;
import kr.or.nextit.session.vo.LoginVo;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LoginService service;
	
	
	@RequestMapping(value="/loginView.do")
	public String loginView() throws Exception{

		log.info("로그인 페이지");
		return "login/login";
	}
	
	@RequestMapping(value="/loginExc.do")
	public String loginExcute(
			@RequestParam HashMap<String, Object> params,
			HttpSession session
			) throws Exception{
	
		String page = null;
		
		log.info("params : {}",params);
		log.info("로그인 가능 여부 판별");
		
		LoginVo loginVo = service.selectLoginInfo(params);
		
		if(loginVo != null) {
			log.info("로그인 성공");
			session.setAttribute("loginVo", loginVo);
			page = "redirect:/";
		} else {
			log.info("로그인 실패");
			page = "redirect:/login/loginView.do?fail=" + URLEncoder.encode("ID 또는 PASSWORD가 다릅니다.", "utf-8");
		}
		
		
		return page;
	}
	
	@RequestMapping(value="/signUpView.do")
	public String signUpView() throws Exception {
		
		log.info("회원가입 페이지");
		return "login/memberSignUp";
	}
	
	@RequestMapping(value="/signUpExc.do")
	public String signUpExcute(
			HttpServletRequest req,
			@ModelAttribute(name="loginVo") LoginVo loginVo
			) throws Exception {
		
		log.info("회원가입 여부 판별");
		log.info("정보 : {}", loginVo);
		
		String page = null;
		
		try {
			loginVo.setIp(req.getRemoteAddr());
			service.insertLoginInfo(loginVo);
			
			page = "login/memberSignUpComplete";
			
			log.info("회원 가입 성공");
		
		} catch(Exception e) {
			
			log.info("회원 가입 실패");
			throw new RuntimeException(e);
		}
		
		return page;
	}
}
