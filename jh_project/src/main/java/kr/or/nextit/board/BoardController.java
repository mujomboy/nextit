package kr.or.nextit.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/freeBoardListView.do")
	public String freeBoardListView() throws Exception {
		
		String page = "board/FreeboardList";
		
		log.info("자유게시판 이동");
		
		return page;
	}
}
