package kr.or.nextit;

import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(
			@RequestParam HashMap<String, Object> params,
			HttpSession session
			) {
		
		String page = "home";
		
		if(params.containsKey("out")) {
			session.setAttribute("loginInfo", null);
			logger.info("로그 아웃");
			
		}
		
		logger.info("메인 페이지 {}.jsp 이동", page);
		
		
		return page;
	}
	
}
