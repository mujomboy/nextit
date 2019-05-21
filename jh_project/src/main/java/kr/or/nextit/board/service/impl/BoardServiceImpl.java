package kr.or.nextit.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.board.mapper.BoardMapper;
import kr.or.nextit.board.service.BoardService;
import kr.or.nextit.board.vo.BoardVo;
import kr.or.nextit.vo.SearchVo;

@Service("BoardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void insertBoardInfo(BoardVo vo) throws Exception {

		mapper.insertBoardInfo(vo);
		
	}

	@Override
	public List<BoardVo> selectBoardListInfo(SearchVo vo) throws Exception {
		
		return mapper.selectBoardListInfo(vo);
	}

	@Override
	public int selectBoardAmountItems(SearchVo vo) throws Exception {
		
		return mapper.selectBoardAmountItems(vo);
	}

}
