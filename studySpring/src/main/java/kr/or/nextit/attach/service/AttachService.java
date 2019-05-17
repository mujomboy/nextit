package kr.or.nextit.attach.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface AttachService {

	public HashMap<String, Object> insertFileUploads(
			String groupSeqNo,
			String serviceType,
			String savePath,
			String userId,
			String userIp,
			List<MultipartFile> attachFiles
			) throws Exception;
	
	List<AttachVo> selectFileList(String groupSeqNo) throws Exception;
	
	AttachVo selectFileInfo(int seqNo) throws Exception;
}
