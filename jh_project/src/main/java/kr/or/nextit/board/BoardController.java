package kr.or.nextit.board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.nextit.board.service.BoardService;
import kr.or.nextit.board.vo.BoardVo;
import kr.or.nextit.vo.SearchVo;

@Controller
@RequestMapping(value="/board")
public class BoardController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService service;
	
	/*****************************************
	 ****** 자유 게시판 0  멤버 게시판 1******
	 *****************************************/
	
	// 게시판 리스트
	@RequestMapping("/boardListView.do/{type}")
	public String boardListView(
			@PathVariable int type,
			Model model
			) throws Exception {
		
		return setBoardListInfo(type, model);
	}
	
	String[][] listInfo = {
			{"자유 게시판", "FREE BOARD", "0"},
			{"멤버 게시판", "MEMBER BOARD", "1"}
	};
	
	// 게시판 세팅
	private String setBoardListInfo(int type, Model model) throws Exception{
		
		log.info(listInfo[type][0] + " 이동");
		
		model.addAttribute("title",listInfo[type][0]);
		model.addAttribute("who",writeInfo[type][1]);
		model.addAttribute("message",listInfo[type][1]);
		model.addAttribute("choiceType",listInfo[type][2]);
		
		return "board/boardList";
	}
	
	// 게시판 검색 기능
	@ResponseBody
	@RequestMapping("/searchBoardList.json")
	public List<BoardVo> searchBoardList(
			@RequestParam HashMap<String, Object> params
			) throws Exception {
		
		log.info("글 검색 진행");
		
		SearchVo sv = new SearchVo();
		sv.setHashmap(params);
		
		log.info("검색 키워드 : {}", sv);
		
		
		List<BoardVo> infoList = service.selectBoardListInfo(sv);
		
		log.info("검색 결과 : {}",infoList);
		
		return infoList;
	}
	
	// 게시글 총 갯수 구하기
	@ResponseBody
	@RequestMapping("/amountItem.json")
	public int amountItem(
			@RequestParam HashMap<String, Object> params
			) throws Exception {
		
		log.debug("게시글 총 수 조회");
		
		SearchVo sv = new SearchVo(params);
		
		log.info("검색 키워드 : {}", sv);

		
		int amount = service.selectBoardAmountItems(sv);
		
		log.info("검색 결과 : 총 아이템 갯수 {} 개",amount);

		
		return amount;
	}
	
	
	// 게시판 글쓰기 뷰
	@RequestMapping({"/boardWriteView.do/{type}", "/boardWriteView.member/{type}"})
	public String boardWriteView(
			@PathVariable int type,
			Model model) throws Exception {
		
		return setBoardWriteInfo(type, model);
	}
	
	String[][] writeInfo = {
			{"자유 게시판 글쓰기", "GUEST", "FREE BOARD : WRITE", "0"},
			{"멤버 게시판 글쓰기", "MEMBER", "MEMBER BOARD : WRITE", "1"}
	};
	
	// 게시판 글쓰기 세팅
	private String setBoardWriteInfo(int type, Model model) throws Exception{
		
		log.info(writeInfo[type][0] + " 이동");
		model.addAttribute("title",writeInfo[type][0]);
		model.addAttribute("who",writeInfo[type][1]);
		model.addAttribute("message",writeInfo[type][2]);
		model.addAttribute("choiceType",writeInfo[type][3]);
		
		model.addAttribute("regBoardWrite","/board/freeBoardWrieExc.do");
		model.addAttribute("moveBoardList","/board/freeBoardListView.do");
		
		return "board/boardWrite";
	}
	
	// 게시판 글 등록
	@RequestMapping("/boardWriteExc.do/{type}")
	public String boardWriteExcute(
			@PathVariable int type,
			BoardVo boardVo,
			Model model,
			HttpServletRequest req
			) throws Exception {
		
		boardVo.setUserIp(req.getRemoteAddr());
		if(boardVo.getCtnt() == null || boardVo.getCtnt().isEmpty())
			boardVo.setCtnt("");
		
		log.info("게시글 정보 : {}", boardVo);
		
		return regBoardWrite(type, boardVo, model);
	}
	
	
	
	String[][] regInfo = {
			{},
			{}		
	};
	
	// 글 등록 진행
	private String regBoardWrite(int type, BoardVo vo, Model model) throws Exception {
		
		log.info("글 등록 진행");
		
		service.insertBoardInfo(vo);
		
		// 글 등록 해야함
		
		return setBoardListInfo(type, model);
	}
	
	
}
