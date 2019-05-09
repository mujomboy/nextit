package kr.or.nextit.test.web;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.hello.service.HelloService;

@Controller
public class TestController {

	@Autowired
	public HelloService helloService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	@RequestMapping(value="/test/modelAndViewTest.do")
	public ModelAndView modelandViewTest(
			ModelAndView modelAndView,
			@RequestParam HashMap<String, Object> params
			) throws Exception {
		
		
		log.debug("params {} ",params);
		log.debug("params {} ",params);
		log.debug("params {} ",params);
		
//		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/test/testFront");
		modelAndView.addObject("title", "modelAndView.addObject 테스트");
		
		
		List<HashMap<String, Object>> result = helloService.getHelloList("test");
		
		modelAndView.addObject("helloList", result);
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/test/testFront.do")
	public String testFront(
			Model model,
			@RequestParam(name="dan", defaultValue="1",required=false) int dan
			) throws Exception{
		
		log.debug("request.getp {}",dan);
		log.debug("request.getp {} {}",dan, "구구단");
		
		model.addAttribute("title", "model.addAttribute test");
		
		return "/test/testFront";
	}
	
	@RequestMapping(value="/test/modelMap.do")
	public String modelMapTestFront(
			ModelMap modelMap,
			@RequestParam HashMap<String, Object> map
			) throws Exception{
		
		log.debug("params : {} ", map);
		log.debug("params : {} ", map);
		log.debug("params : {} ", map);
		
		modelMap.addAttribute("title", "modleMap.addAttribute");
		
		return "/test/testFront";
	}
}
