package kr.or.nextit.login;

import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
			log.info("로그인 정보 : {}",loginVo);
			session.setAttribute("loginInfo", loginVo);
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
			@ModelAttribute LoginVo vo,
			Model model
			) throws Exception {
		
		log.info("회원가입 여부 판별");
		log.info("정보 : {}", vo);
		
		String page = null;
		
		try {
			vo.setIp(req.getRemoteAddr());
			service.insertLoginInfo(vo);
			
			page = "login/memberSignUpComplete";
			
			log.info("회원 가입 성공");
			model.addAttribute("title", "가입 완료");
			model.addAttribute("message", "SIGN UP COMPLETE!");
			model.addAttribute("insert","가입");
			
		} catch(Exception e) {
			
			log.info("회원 가입 실패");
			throw new RuntimeException(e);
		}
		
		return page;
	}
	
	@ResponseBody
	@RequestMapping(value="/duplicationId.json")
	public boolean getDuplicationCheck(
			@RequestParam HashMap<String, Object> params
			) throws Exception {
		
		
		String id = service.selectCheckId(params);
		
		log.debug("아이디 중복 채크 : {}", id);
		
		return id == null ? false : true;
	}
}
