package kr.or.nextit.board.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.board.service.BoardSearchVo;
import kr.or.nextit.board.service.BoardService;
import kr.or.nextit.board.service.BoardVo;

@Service("BoardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardVo> selectBoardList(BoardSearchVo searchVo) throws Exception {
		
		try {
			List<BoardVo> resultList = boardMapper.selectBoardList(searchVo);
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException("질의어 수행중 에러 발생", e);
		}
	}

	@Override
	public void insertBoardInfo(BoardVo boardVo) throws Exception {
		
		boardMapper.insertBoardInfo(boardVo);
	}

	@Override
	public BoardVo selectBoardInfo(String seqNo) throws Exception {

		boardMapper.updateBoardInfoCount(seqNo);
		
		BoardVo boardVo = boardMapper.selectBoardInfo(seqNo);
		
		return boardVo;
	}

	@Override
	public void deleteBoardInfo(HashMap<String, Object> params) throws Exception {
		
		boardMapper.deleteBoardInfo(params);
	}

	@Override
	public void updateBoardInfo(HashMap<String, Object> params) throws Exception {

		boardMapper.updateBoardInfo(params);
	}
}
