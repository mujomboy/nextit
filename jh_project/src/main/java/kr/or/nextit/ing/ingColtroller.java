package kr.or.nextit.ing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ingColtroller {

	
	@RequestMapping("/ing/ing.do")
	public String ing() throws Exception {
		
		
		return "ing/ing";
	}
}
