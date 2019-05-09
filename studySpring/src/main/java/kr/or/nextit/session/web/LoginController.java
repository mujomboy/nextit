package kr.or.nextit.session.web;

import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import kr.or.nextit.com.utils.CookieBox;
import kr.or.nextit.session.service.LoginInfoVo;
import kr.or.nextit.session.service.SessionService;

@Controller
public class LoginController {

	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SessionService sessionService;
	
	@RequestMapping(value= {"/session/loginFront.do"})
	public String actionLoginFront(
			ModelMap modelMap,
			HttpServletRequest req
			) throws Exception{
		
		
		CookieBox cookieBox = new CookieBox(req);
		
		
		if(cookieBox.exists("idSave")) {
			String idSave = cookieBox.getValue("idSave");
			modelMap.addAttribute("idSave", idSave);
		}
	
		modelMap.addAttribute("cUsrId", cookieBox.getValue("cUsrId"));
		
		
		return "session/loginFront";
	}
	
	@RequestMapping(value="/session/actionLoginProc.do")
	public String actionLoginProc(
			Model model,
			@RequestParam HashMap<String, Object> params,
			HttpSession session,
			HttpServletRequest req,
			HttpServletResponse res
			) throws Exception {
		
		
		log.debug("로그인 시동 시 params : {}", params);
		
		CookieBox cookieBox = new CookieBox(req.getCookies());
		
		if(params.containsKey("remember")) {
			Cookie idSave= cookieBox.createCookie("idSave", "checked=\"checked\"");
			res.addCookie(idSave);
			
			
			Cookie cUsrId= cookieBox.createCookie("cUsrId", (String)params.get("userId"), "/", 5000000);
			res.addCookie(cUsrId);
			
		} else {
			Cookie idSave = cookieBox.createCookie("idSave","", "/", 0);
			res.addCookie(idSave);
			
			Cookie cUsrId= cookieBox.createCookie("cUsrId", "", "/", 0);
			res.addCookie(cUsrId);
		}
		
		
		LoginInfoVo loginInfoResult = sessionService.selectMemberInfo(params);
		
		log.debug("loginInfo : {} ", loginInfoResult);
		log.debug("loginInfo : {} ", loginInfoResult);
		
		if(loginInfoResult != null) {
			session.setAttribute("loginInfo", loginInfoResult);
			return "redirect:/";
		} else {
			session.invalidate();
			
			model.addAttribute("message", "없음 : 없음");
//			return "session/loginFront";
			
			return "redirect:/session/loginFront.do?message=" + URLEncoder.encode("아이디 또는 비밀번호 틀림", "utf-8");
		}
		
	}
	
	@RequestMapping(value= {"/session/actionLogoutProc.do"})
	public ModelAndView actionLogoutProc(
			ModelAndView modelAndView,
			HttpSession session
			) throws Exception {
		
		session.setAttribute("loginInfo", null);
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/session/loginFront.do");
		
		modelAndView.setView(redirectView);
		
		return modelAndView;
	}
	
}
