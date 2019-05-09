package kr.or.nextit.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.EnumeratedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter {

	private final Logger log =  LoggerFactory.getLogger(this.getClass());

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		log.debug("TestInterceptor.pre ");
		log.debug("url 요청 시 컨트롤러가 실행되기 전 ");
		
		Enumeration<String> names = request.getParameterNames();
		
		while (names.hasMoreElements()) {
			String string = (String) names.nextElement();
			log.debug("key name : {} , key value : {}", string, request.getParameter(string));
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		log.debug("TestInterceptor.post ");
		log.debug("url 요청 시 컨트롤러가 실행된 후  ");
		
		
		Enumeration<String> names =  request.getParameterNames();
		
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			log.debug("key name : {}, key value : {}", name, request.getParameter(name));
		}
		
//		log.debug("model {}",modelAndView.getModel());
//		log.debug("modelmap {}",modelAndView.getModelMap());
		
		modelAndView.addObject("userTitle", "인터셉터 ㅇ,.ㅇ");
	}
}



