package kr.or.nextit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.board.vo.BoardVo;
import kr.or.nextit.vo.SearchVo;

@Mapper
public interface BoardMapper {

	void insertBoardInfo(BoardVo vo) throws Exception;
	
	List<BoardVo> selectBoardListInfo(SearchVo vo) throws Exception;
	
	int selectBoardAmountItems(SearchVo vo) throws Exception;
}
