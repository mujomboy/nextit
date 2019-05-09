package kr.or.hello.web;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.hello.service.HelloService;
import kr.or.nextit.test.service.HomeVo;

@Controller
public class HelloController {
	
	private String title;
	
	private HelloService helloService;

	@RequestMapping(value="/helloModelAndView.do")
	public ModelAndView helloTest(
			ModelAndView modelAndView,
			@ModelAttribute HomeVo paramVo
			) throws Exception {
		
		modelAndView.setViewName("/test/helloTest");
		modelAndView.addObject("siteTitle", getTitle());
		
		List<HashMap<String , Object>> result = getHelloService().getHelloList("test");
		
		modelAndView.addObject("helloList", result);
		
		return modelAndView;
	}
	
	@RequestMapping(value= {"/helloModel.do"})
	public String helloTest2(
			Model model,
			@RequestParam HashMap<String, Object> params
			)  throws Exception{
		
		model.addAttribute("siteTitle", getTitle());
		
		return "test/helloTest";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public HelloService getHelloService() {
		return helloService;
	}

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
	
	
}
