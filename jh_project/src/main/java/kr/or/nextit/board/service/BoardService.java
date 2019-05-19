package kr.or.nextit.board.service;

import java.util.List;

import kr.or.nextit.board.vo.BoardVo;
import kr.or.nextit.vo.SearchVo;

public interface BoardService {

	void insertBoardInfo(BoardVo vo) throws Exception;
	
	List<BoardVo> selectBoardListInfo(SearchVo vo) throws Exception;
	
	
}
