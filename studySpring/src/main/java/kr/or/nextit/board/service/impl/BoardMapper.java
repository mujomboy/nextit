package kr.or.nextit.board.service.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.board.service.BoardSearchVo;
import kr.or.nextit.board.service.BoardVo;

@Mapper
public interface BoardMapper {
	
	List<BoardVo> selectBoardList(BoardSearchVo searchVo) throws Exception;
	
	void insertBoardInfo(BoardVo boardVo) throws Exception;
	
	BoardVo selectBoardInfo(String seqNo) throws Exception;
	
	void updateBoardInfoCount(String seqNo) throws Exception;
	
	void deleteBoardInfo(HashMap<String, Object> params) throws Exception; 
}
