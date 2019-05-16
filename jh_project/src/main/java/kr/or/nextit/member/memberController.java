package kr.or.nextit.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/member")
public class memberController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="/myPageView.do")
	public String myPageView() throws Exception {
		
		return "member/myPage";
	}
}
