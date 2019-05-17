package kr.or.nextit.attach.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.nextit.attach.service.AttachService;
import kr.or.nextit.attach.service.AttachVo;

@Service("AttachService")
public class attachServiceImpl implements AttachService {

	@Autowired
	private AttachMapper attachMapper;

	@Override
	public HashMap<String, Object> insertFileUploads(String groupSeqNo, String serviceType, String savePath,
			String userId, String userIp, List<MultipartFile> attachFiles) throws Exception {
		
		HashMap<String, Object> result = new HashMap<>();
		
		
		try {
			for (MultipartFile attach : attachFiles) {
				
				if("".equalsIgnoreCase(attach.getOriginalFilename())) continue;
				
				AttachVo  fileInfo = new AttachVo();
				fileInfo.setGroupSeqNo(groupSeqNo);
				fileInfo.setRegUser(userId);
				fileInfo.setServiceType(serviceType);
				fileInfo.setUsrIp(userIp);

				fileInfo.setFileName(attach.getOriginalFilename());
				
				fileInfo.setSaveName(UUID.randomUUID().toString());
				fileInfo.setSavePath(String.format("%s%s%s", File.separator, serviceType, File.separator));
				fileInfo.setSaveSize(attach.getSize());
				fileInfo.setSaveContentType(attach.getContentType());
				
				
				
				attachMapper.insertFileInfo(fileInfo);
				
				StringBuilder serverPath = new StringBuilder();
				serverPath.append(savePath);
				serverPath.append(fileInfo.getSavePath());
				serverPath.append(fileInfo.getSaveName());
				
				File saveFile = new File(serverPath.toString());
				
				System.out.println(serverPath.toString());
				System.out.println(serverPath.toString());
				
				FileUtils.copyToFile(attach.getInputStream(), saveFile);
				
			}
			
			result.put("status", true);
			result.put("message", "파일 업로드 완료");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("status", false);
			result.put("message", e.getMessage());
		}
		
		return result;
	}

	@Override
	public List<AttachVo> selectFileList(String groupSeqNo) throws Exception {

		List<AttachVo> list = attachMapper.selectFileList(groupSeqNo);
		return list;
	}

	@Override
	public AttachVo selectFileInfo(int seqNo) throws Exception {

		attachMapper.updateFileInfoCnt(seqNo);
		
		AttachVo vo = attachMapper.selectFileInfo(seqNo);
		return vo;
	}
	
}
