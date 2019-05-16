package kr.or.nextit.attach.web;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
		
		String groupSeqNo = "";
		
		if(params.get("groupSeqNo") != null) {
			groupSeqNo = (String)params.get("groupSeqNo");
		}
		
		List<AttachVo> attachList = attachService.selectFileList(groupSeqNo);
		model.addAttribute("attachList",attachList);
		
		return "attach/testDownload";
	}
}
