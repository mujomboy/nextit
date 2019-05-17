package kr.or.nextit.board.service;

import java.util.HashMap;
import java.util.List;

public interface BoardService {

	List<BoardVo> selectBoardList(BoardSearchVo searchVo) throws Exception;
	
	BoardVo insertBoardInfo(BoardVo boardVo) throws Exception;
	
	BoardVo selectBoardInfo(String seqNo) throws Exception;
	
	void deleteBoardInfo(HashMap<String, Object> params) throws Exception;
	
	void updateBoardInfo(HashMap<String, Object> params) throws Exception;
}
