package kr.or.nextit.board.web;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.nextit.board.service.BoardSearchVo;
import kr.or.nextit.board.service.BoardService;
import kr.or.nextit.board.service.BoardVo;
import kr.or.nextit.session.service.LoginInfoVo;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private BoardService boardService;

	@RequestMapping(value="/boardListFront.do")
	public String getBoardList(
			Model model,
			@ModelAttribute BoardSearchVo searchVo
			) throws Exception {
		
		List<BoardVo> boardList =  boardService.selectBoardList(searchVo);
		
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
	}
	
	@RequestMapping(value="/boardInsertForm.do")
	public String getBoardInsertForm(
			Model model,
			@ModelAttribute BoardSearchVo searchVo
			) throws Exception {
		
		return "board/boardForm";
	}
	
	@RequestMapping(value="/boardInsertProc.do")
	public String setBoardInsertProc(
			Model model,
			@ModelAttribute(name="boardVo") BoardVo boardVo,
			HttpServletRequest req
			) throws Exception {
		
		try {
			LoginInfoVo loginInfoVo = (LoginInfoVo) req.getSession().getAttribute("loginInfo");
			
			boardVo.setRegUser(loginInfoVo.getUsrId());
			boardVo.setUsrIp(req.getRemoteAddr());
			
			boardService.insertBoardInfo(boardVo);
			
			return "redirect:/board/boardListFront.do";
			
		} catch (Exception e) {
			e.printStackTrace();
			
			model.addAttribute("message",e.getMessage());
			
			return "board/boardForm";
		}
	}
	
	@RequestMapping(value="/boardViewFront.do")
	public String getBoardViewFront(
			ModelMap modelMap,
			@ModelAttribute(name="searchVo") BoardSearchVo searchVo
			) throws Exception {
		
		
		
		BoardVo boardVo = boardService.selectBoardInfo(searchVo.getSeqNo());
		
		modelMap.addAttribute("boardInfo",boardVo);
		
		return "board/boardView";
	}
	
	@RequestMapping(value="/boardDeleteProc.do")
	public String setBoardInfoProc(
			Model model,
			@RequestParam HashMap<String, Object> params
			) throws Exception {
		
		
		try {
			boardService.deleteBoardInfo(params);
			return "redirect:/board/boardListFront.do";
		} catch (Exception e) {
			e.printStackTrace();
			return String.format("redirect:/board/boardViewFront.do?seqNo=%s", (String)params.get("seqNo"));
		}

	}
	
	@RequestMapping(value="/boardUpdateFront.do")
	public String getBoardUpdateFront(
			Model model,
			@RequestParam HashMap<String, Object> params
			) throws Exception {
		
		BoardVo boardVo = boardService.selectBoardInfo((String)params.get("seqNo"));
		
		model.addAttribute("boardInfo", boardVo);
		
		return "board/boardUpdate";
	}
	
	@RequestMapping(value="/boardUpdateProc.do")
	public String getBoardUpdateProc(
			Model model,
			@RequestParam HashMap<String, Object> params,
			HttpSession session
			) throws Exception {
		
			params.put("updUser", ((LoginInfoVo)session.getAttribute("loginInfo")).getUsrId());
			
		try {			
			boardService.updateBoardInfo(params);
			return String.format("redirect:/board/boardViewFront.do?seqNo=%s", (String)params.get("seqNo"));
		} catch(Exception e) {
			e.printStackTrace();
			return String.format("redirect:/board/boardUpdateFront.do?seqNo=%s", (String)params.get("seqNo"));
		}
	}
}
