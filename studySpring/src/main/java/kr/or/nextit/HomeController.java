package kr.or.nextit;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.nextit.test.service.HomeVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model, HttpServletRequest req, HttpServletResponse res) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		logger.info("req.getRemoteAddr() : {}",req.getRemoteAddr());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@GetMapping(value ="/test/getTest.do")					// get 만 받아서 처리 할 수 있음
	//@RequestMapping(value = "/test/getTest.do")				// get post put delete 등의 모든 메소드를 받아서 처리 할수 있음
	public String getTest(
			@RequestParam HashMap<String, Object> params,
			@RequestParam(name="title") String title,
			@ModelAttribute HomeVo home
			) {
		
		logger.info(" home 에서 보낸 값{}", params);
		logger.info(" home 에서 보낸 값 {}", params);
		logger.info(" home 에서 보낸 값 {}", params);
		logger.info(" home 에서 보낸 값 {}", params);
		
		logger.info(" home 에서 보낸 값 {}", home);
		logger.info(" home 에서 보낸 값 {}", home);
		logger.info(" home 에서 보낸 값 {}", home);
		logger.info(" home 에서 보낸 값 {}", home);

		return "/test/getTest";
	}
	
	@PostMapping(value = {"/test/postTest.do", "/test/postTest.daum"})
	public String postTest(
			@ModelAttribute HomeVo home) {
		
		log.info("home post : {}", home);
		log.error("home post : {}", home);
		log.debug("home post : {}", home);
		log.debug("home post : {}", home);
		log.debug("home post : {}", home);
		
		return "/test/postTest";
	}
}
