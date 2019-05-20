package kr.or.nextit.scheduler.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.board.service.BoardService;
import kr.or.nextit.board.service.BoardVo;
import kr.or.nextit.scheduler.service.TestSchedulerService;

@Service("TestSchedulerService")
public class TestScedulerServiceImpl implements TestSchedulerService{

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void getTestPrint() throws Exception {

		log.debug("testPrint : {}", "쿠어츠 시작");
	}

	@Override
	public void getCronPrint() throws Exception {
		
		log.debug("cronPrint : {}","세세한 설정 시작");
	}

	@Autowired
	private BoardService service;
	
	@Override
	public void setBoardCount() throws Exception {
		
		BoardVo vo = service.selectBoardInfo("7");
		if(vo != null)
		log.debug("증가 : {}",vo.getReadCount());
	}

}
