package kr.or.nextit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.nextit.session.vo.LoginVo;

// 로그인 상태 채크 어댑터
public class LogCheckInterceptor extends HandlerInterceptorAdapter{

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.info("로그인 상태 채크");
		
		LoginVo loginVo = (LoginVo) request.getSession().getAttribute("loginVo");
		
		//
		if(loginVo == null) {
			String page = "redirect:/login/loginView.do";
		
			ModelAndView modelAndView = new ModelAndView(page);
			log.info("로그 아웃 상태 -> 로그인 페이지 이동 : {}", page);
			throw new ModelAndViewDefiningException(modelAndView);
		}
		
		return true;
	}
}
