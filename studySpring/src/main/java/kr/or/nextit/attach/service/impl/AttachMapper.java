package kr.or.nextit.attach.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.nextit.attach.service.AttachVo;

@Mapper
public interface AttachMapper {
	
	public void insertFileInfo(AttachVo attachVo) throws Exception;
	
	List<AttachVo> selectFileList(
			String groupSeqNo
			) throws Exception;
}
