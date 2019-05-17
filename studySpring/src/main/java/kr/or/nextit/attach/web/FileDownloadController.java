package kr.or.nextit.attach.web;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.nextit.attach.service.AttachService;
import kr.or.nextit.attach.service.AttachVo;

@Controller
public class FileDownloadController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "propertyService")
	private Properties propertyService;

	@Autowired
	private AttachService attachService;
	
	
	@RequestMapping(value="/attach/testDownload.do")
	public String testDownloadFront(
			Model model,
			@RequestParam HashMap<String, Object> params
			) throws Exception{
		
		String groupSeqNo = "982884fa-e21e-4e94-bd0f-81ff5fd186aa";
		
		if(params.get("groupSeqNo") != null) {
			groupSeqNo = (String)params.get("groupSeqNo");
		}
		
		List<AttachVo> attachList = attachService.selectFileList(groupSeqNo);
		model.addAttribute("attachList",attachList);
		
		return "attach/testDownload";
	}
	
	@RequestMapping(value="/attach/FileDownload.do")
	public void getFileDownload(
			@RequestParam(name="seqNo") int seqNo,
			HttpServletResponse res
			) throws Exception {
		
		String serverRootPath = propertyService.getProperty("server.save.path");
		
		AttachVo attachVo = attachService.selectFileInfo(seqNo);
		
		StringBuilder fileSavePath = new StringBuilder();
		fileSavePath.append(serverRootPath);
		fileSavePath.append(attachVo.getSavePath());
		fileSavePath.append(attachVo.getSaveName());
		
		log.debug("fileSavePath : {}",fileSavePath);
		
		File serverFile = new File(fileSavePath.toString());
		
		byte fileByte[] = FileUtils.readFileToByteArray(serverFile);
		
		
		res.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		res.setContentLength(fileByte.length);
		res.setHeader("Content-Transfer-Encoding", "binary");
		
		res.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\""+ URLEncoder.encode(attachVo.getFileName(), "utf-8") + "\";");
		
		res.getOutputStream().write(fileByte);
		res.getOutputStream().flush();
		res.getOutputStream().close();
		
		
	}
}
